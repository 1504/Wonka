package org.usfirst.frc1504.Wonka;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.usfirst.frc1504.Wonka.Update_Semaphore.Updatable;

import edu.wpi.first.wpilibj.DriverStation;

public class Elevator implements Updatable {
	// Elevator

	private WPI_TalonSRX _top_actuator;
	//private WPI_TalonSRX _bottom_actuator;
	//private CANSparkMax _top_actuator;
	

	private static final Elevator instance = new Elevator();
	private DriverStation _ds = DriverStation.getInstance();

	
	//private CANEncoder _top_encoder;
	//private Glide _bottom_glide;
	//private Glide _top_glide;


	public static Elevator getInstance() // sets instance
	{
		return instance;
	}

	private Elevator() // Elevator constructor
	{

		_top_actuator = new WPI_TalonSRX(Map.TOP_ACTUATOR_PORT);
		//_bottom_actuator = new WPI_TalonSRX(Map.BOTTOM_ACTUATOR_PORT);
		_top_actuator.setNeutralMode(NeutralMode.Brake);

		//_top_glide = new Glide(.007, .025);
		//_bottom_glide = new Glide(.007, .025);
		Update_Semaphore.getInstance().register(this);
		System.out.println("Elevator initialized");
	}

	public static void initialize() // initialize
	{
		getInstance();
	}



	public void semaphore_update() // updates robot information
	{
		if (_ds.isDisabled()) // only runs in teleop
		{
			return;
		}

		if(IO.hid_N())
        {
            _top_actuator.set(1.0);
        } else if(IO.hid_S())
        {
            _top_actuator.set(-1.0);
		}
		else
		{
			_top_actuator.set(0.0);
		}
		
	}

		
		
}
