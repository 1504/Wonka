package org.usfirst.frc1504.Wonka;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANEncoder;

import org.usfirst.frc1504.Wonka.Update_Semaphore.Updatable;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Preferences;

public class Elevator implements Updatable {
	// Elevator
	private static double rotato = 0;
	private int reverse = 1;

	private boolean _elevator_enable = false;
	

	private WPI_TalonSRX _top_actuator;
	private WPI_TalonSRX _auger;
	//private WPI_TalonSRX _bottom_actuator;
	//private CANSparkMax _top_actuator;
	

	private static final Elevator instance = new Elevator();
	private DriverStation _ds = DriverStation.getInstance();

	
	private Potentiometer _top_potentiometer;
	//private CANEncoder _top_encoder;
	//private Glide _bottom_glide;
	//private Glide _top_glide;


	public static Elevator getInstance() // sets instance
	{
		return instance;
	}

	private Elevator() // Elevator constructor
	{
		AnalogInput b = new AnalogInput(Map.TOP_POTENTIOMETER_PORT);
		_top_potentiometer = new AnalogPotentiometer(b, 100, 0);

		_top_actuator = new WPI_TalonSRX(Map.TOP_ACTUATOR_PORT);
		
		_auger = new WPI_TalonSRX(Map.AUGER_PORT);
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

	private void ooger_speeds() 
    {
		if(IO.get_reverse())
		{
			reverse = -1;
		} else {
			reverse = 1;
		}
        _auger.set(reverse*IO.get_auger());
    }


	public void semaphore_update() // updates robot information
	{
		ooger_speeds();
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
