package org.usfirst.frc1504.Wonka;
import org.usfirst.frc1504.Wonka.Update_Semaphore.Updatable;
import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.Servo;


public class Wheels implements Updatable
{
    private static final Wheels instance = new Wheels();
    private DriverStation _ds = DriverStation.getInstance();

    private WPI_TalonSRX _left_spew;
	private WPI_TalonSRX _right_spew;
    private static double speedo = 0.32;
    private static final double max_speed = 0.55;
    private Servo card_rotator = new Servo(Map.CARD_SERVO);

    public static Wheels getInstance() // sets instance
	{
		return instance;
    }

    public static void initialize() // initialize
    {
        getInstance();
    }

    public static double put_on_speedo()
    {
        return speedo;
    }

    private Wheels()
    {
		_left_spew = new WPI_TalonSRX(Map.WHEEL_TALON_PORT_LEFT);
        _right_spew = new WPI_TalonSRX(Map.WHEEL_TALON_PORT_RIGHT);

        _left_spew.setNeutralMode(NeutralMode.Brake);
        _right_spew.setNeutralMode(NeutralMode.Brake);
        
        Update_Semaphore.getInstance().register(this);
        System.out.println("Wheels initialized");
    }

    private void update()
    {
        if(IO.hid_E())
        {
            speedo = speedo + 0.005;
        } else if(IO.hid_W())
        {
            speedo = speedo - 0.005;
        }

		if(speedo > max_speed)
		{
			speedo = max_speed;
		} else if(speedo < 0)
		{
			speedo = 0;
		}
        
        if(IO.get_ss_low())
		{
			speedo = 0.32;
		} else if(IO.get_ss_high())
		{
			speedo = 0.4;
        }
        
        if(IO.get_enabler())
        {
            _left_spew.set(-speedo);
            _right_spew.set(speedo);
        } else {
            _left_spew.set(0);
            _right_spew.set(0);
        }
        card_rotator();
        System.out.println(speedo);
    }

    private void card_rotator() 
    { 
        card_rotator.set((IO.card_servo_input()+1)/2); //cleans input into 0 to 1
    }

    public void semaphore_update() // updates robot information
	{		
		if (_ds.isDisabled()) // only runs in teleop
			return;

		update();
    }
}