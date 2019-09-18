package org.usfirst.frc1504.Wonka;

public class IO
{
	private static Latch_Joystick _drive_forward = new Latch_Joystick(Map.DRIVE_CARTESIAN_JOYSTICK);
	private static Latch_Joystick _drive_rotation = new Latch_Joystick(Map.DRIVE_POLAR_JOYSTICK);
	private static Latch_Joystick _secondary = new Latch_Joystick(Map.DRIVE_SECONDARY_JOYSTICK);

	public static final long ROBOT_START_TIME = System.currentTimeMillis();
	
	public static boolean override()
	{
		return _secondary.getRawButton(Map.OVERRIDE_BUTTON);
	}

	/**
	 * Drive stuff
	 */
	
	/**
	 * Handle getting joystick values
	 * @return
	 */
	public static boolean camera_port()
	{
		return _secondary.getRawButton(Map.VISION_INTERFACE_CAMERA_PORT_BUTTON);
	}
	
	/**
	 * Pickup stuff
	 */
	
	public static double override_input()
	{
		return Utils.deadzone(_secondary.getRawAxis(Map.INTAKE_POWER_AXIS));
	}
	

	public static boolean get_la_high()
	{
		return _secondary.getRawButton(Map.LAHIGH);
	}

	public static boolean get_la_low()
	{
		return _secondary.getRawButton(Map.LALOW);
	}

	public static boolean get_ss_high()
	{
		return _secondary.getRawButton(Map.SSHIGH);
	}

	public static boolean get_ss_low()
	{
		return _secondary.getRawButton(Map.SSLOW);
	}

	public static boolean get_enabler()
	{
		return _secondary.getRawButton(Map.ENABLER);
	}

	
	/** Hid Stuff
	 * 
	 */
	public static int hid()
	{
		return _secondary.getPOV();
	}
	public static boolean hid_N()
	{
		if(hid() == 0)
			return true;
		else 
			return false;
	}
	public static boolean hid_E()
	{
		if(hid() == 90)
			return true;
		else 
			return false;
	}
	public static boolean hid_S()
	{
		if(hid() == 180)
			return true;
		else 
			return false;
	}
	public static boolean hid_W()
	{
		if(hid() == 270)
			return true;
		else
			return false;
	}

	/**
	 * Drive stuff
	 */
	
	public static double[] drive_input() {
		double[] inputs = new double[3];

		inputs[0] = Map.DRIVE_INPUT_MAGIC_NUMBERS[0] * Math.pow(Utils.deadzone(_drive_forward.getRawAxis(Map.JOYSTICK_Y_AXIS)), 2) * Math.signum(_drive_forward.getRawAxis(Map.JOYSTICK_Y_AXIS));// y
		inputs[1] = Map.DRIVE_INPUT_MAGIC_NUMBERS[1] * Math.pow(Utils.deadzone(_drive_forward.getRawAxis(Map.JOYSTICK_X_AXIS)), 2) * Math.signum(_drive_forward.getRawAxis(Map.JOYSTICK_X_AXIS));//x
		inputs[2] = Map.DRIVE_INPUT_MAGIC_NUMBERS[2] * Math.pow(Utils.deadzone(_drive_rotation.getRawAxis(Map.JOYSTICK_X_AXIS)), 2) * Math.signum(_drive_rotation.getRawAxis(Map.JOYSTICK_X_AXIS));//w
		return inputs;
	}
	public static double drive_wiggle()
	{
		return (_drive_rotation.getRawButton(4) ? -1.0 : 0.0) + (_drive_rotation.getRawButton(5) ? 1.0 : 0.0);
	}
	public static boolean reset_front_side()
	{
		return (_drive_forward.getRawButton(Map.DRIVE_FRONTSIDE_FRONT));
	}
	public static boolean get_drive_op_toggle()
	{
		return (_drive_rotation.getRawButton(Map.DRIVE_OP_BUTTONS[0]) || _drive_rotation.getRawButton(Map.DRIVE_OP_BUTTONS[1]) || _drive_rotation.getRawButton(Map.DRIVE_OP_BUTTONS[2]) || _drive_rotation.getRawButton(Map.DRIVE_OP_BUTTONS[3]) || _drive_forward.getRawButton(Map.DRIVE_OP_BUTTONS[0]) || _drive_forward.getRawButton(Map.DRIVE_OP_BUTTONS[1]) || _drive_forward.getRawButton(Map.DRIVE_OP_BUTTONS[2]) || _drive_forward.getRawButton(Map.DRIVE_OP_BUTTONS[3]));
	}	
}
