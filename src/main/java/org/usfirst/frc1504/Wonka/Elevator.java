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
	private static double speedo = 0;

	private boolean _elevator_enable = false;
	

	private WPI_TalonSRX _top_actuator;
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

	public boolean getEnabled()
	{
		return _elevator_enable;
	}
	
	
	private void update()
	{
		// Disable elevator if encoder and potentiometer drift too far apart
		/*if(	Math.abs(_top_encoder.getPosition() - _top_potentiometer.get()) > 3.7 ||
			Math.abs(_bottom_encoder.getPosition() - _bottom_potentiometer.get()) > 3.7)
			_elevator_enable = false;*/
		
		if(!_elevator_enable)
		{
			if(!IO.override())
			{
				_top_actuator.set(0.0);
			}
			//_moving = false;
			return;
		}
		//double top_error = (_top_setpoints[_setpoint][_mode.ordinal()] - _top_encoder.getPosition());
		//double bottom_error = (_bottom_setpoints[_setpoint][_mode.ordinal()] - _bottom_encoder.getPosition());
		
		//top_error = Math.pow(top_error / 1.4, 2.0) * Math.signum(top_error);
	}


	public void semaphore_update() // updates robot information
	{
		if (_ds.isDisabled()) // only runs in teleop
		{
			_elevator_enable = false;
			return;
		}

		
		if(IO.override())
		{
			_elevator_enable = false;
		}
		if(IO.hid_N())
        {
            speedo = speedo + 0.01;
        } else if(IO.hid_S())
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
        
        if(IO.get_la_low())
		{
			speedo = 0.5;
		} else if(IO.get_la_high())
		{
			speedo = 0.7;
        }
			_top_actuator.set(speedo * .7);

			update();
		}

		
		
	}
