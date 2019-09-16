package org.usfirst.frc1504.Wonka;
import org.usfirst.frc1504.Wonka.Update_Semaphore.Updatable;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Wheels implements Updatable
{
    private static final Wheels instance = new Wheels();
    private DriverStation _ds = DriverStation.getInstance();

    private WPI_TalonSRX _left_spew;
	private WPI_TalonSRX _right_spew;

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
        if(IO.get_enabler())
        {
            _left_spew.set(IO.get_intake_speed());
            _right_spew.set(-IO.get_intake_speed());
        }
    }

    public void semaphore_update() // updates robot information
	{		
		if (_ds.isDisabled()) // only runs in teleop
			return;

		update();
    }
}