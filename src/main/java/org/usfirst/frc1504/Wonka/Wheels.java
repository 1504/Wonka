package org.usfirst.frc1504.Wonka;
import org.usfirst.frc1504.Wonka.Update_Semaphore.Updatable;
import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Wheels implements Updatable
{
    private static final Wheels instance = new Wheels();
    private DriverStation _ds = DriverStation.getInstance();

    private WPI_TalonSRX _left_spew;
	private WPI_TalonSRX _right_spew;
    public static double speedo = 0;

    public static Wheels getInstance() // sets instance
	{
		return instance;
    }

    public static void initialize() // initialize
    {
        getInstance();
    }

    private Wheels()
    {
		_left_spew = new WPI_TalonSRX(Map.WHEEL_TALON_PORT_LEFT);
        _right_spew = new WPI_TalonSRX(Map.WHEEL_TALON_PORT_RIGHT);
        
        Update_Semaphore.getInstance().register(this);
        System.out.println("Wheels initialized");
    }

    private void update()
    {
        if(IO.hid_up())
        {
            speedo = speedo + 0.01;
        } else if(IO.hid_down())
        {
            speedo = speedo - 0.01;
        }

		if(speedo > 1)
		{
			speedo = 1;
		} else if(speedo < 0)
		{
			speedo = 0;
		}
        
        if(IO.hid() == 270)
		{
			speedo = 0.5;
		} else if(IO.hid() == 90)
		{
			speedo = 0.7;
		}
        if(IO.get_enabler())
        {
            _left_spew.set(-speedo);
            _right_spew.set(speedo);
        } else {
            _left_spew.set(0);
            _right_spew.set(0);
        }
    }

    public void semaphore_update() // updates robot information
	{		
		if (_ds.isDisabled()) // only runs in teleop
			return;

		update();
    }
}