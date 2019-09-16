package org.usfirst.frc1504.Wonka;

public class Map {
	/**
	 * Utilities
	 */
	public static final double UTIL_JOYSTICK_DEADZONE = 0.05;

	/**
	 * Inputs
	 */
	public static final int DRIVE_CARTESIAN_JOYSTICK = 0;
	public static final int DRIVE_POLAR_JOYSTICK = 1;
	public static final int DRIVE_SECONDARY_JOYSTICK = 2;

	public static final int OVERRIDE_BUTTON = 5;

	public static final int ENABLER = 3;


	public static final int TO_THE_GOOD_OLD_DAYS = 2;

	public static final double ROLLER_SPEED_MULTIPLIER = 0.75;

	//1 : A  - Auto_alignment_button
	//2 : B  - Grabber
	//3 : X  - Auto_placement_button
	//4 : Y  - extend/retract arms
	//5 : LB - Endgame Lift Front
	//6 : RB - Endgame Lift Back
	//7 : Back 
	//8 : Start
	//9 : Press left joystick
	//10 : Press right joystick
	
	//0 : X axis-left joystick
	//1 : Y axis-left joystick - spinning rotors
	//2 : LT
	//3 : RT
	//4 : X axis-right joystick
	//5 : Y axis-right joystick

	public static final double POTENTIOMETER_LIMIT = 5;
	// Joystick-rotation buttons

	//2
	//3
	//4
	//5

/**
 * Pickup stuff
 */
		
		public static final int INTAKE_POWER_AXIS = 1;
		
		public static final int WHEEL_TALON_PORT_LEFT = 20;
		public static final int WHEEL_TALON_PORT_RIGHT = 21;
		
		public static final double PICKUP_GAIN = 0.03;
		public static final double ROTATION_SPEED = 1;

		public static final int GRAB_PISTON_HIGHSIDE_PORT = 0;
		public static final int GRAB_PISTON_LOWSIDE_PORT = 1;
		
		public static final int ARM_EXTENSION_HIGHSIDE_PORT = 2;
		public static final int ARM_EXTENSION_LOWSIDE_PORT = 3;


		/**
		 * Potentiometer Values
		 * 
		 * These are the hard coded values returned from the potentiometers 
		 * for the positions we set the linear actuators to when delivering balls and hatch panels.
		 * First/Front/Lower Linear Actuator
		 * Second/Back/Higher Linear Actuator
		 */

		
/**
 * Drive class things
 */
	
	// Drive Motor enumeration
	public static enum DRIVE_MOTOR {
		FRONT_LEFT, BACK_LEFT, BACK_RIGHT, FRONT_RIGHT
	}

	// Drive Motor ports
	public static final int FRONT_LEFT_TALON_PORT = 11;
	public static final int BACK_LEFT_TALON_PORT = 12;
	public static final int BACK_RIGHT_TALON_PORT = 13;
	public static final int FRONT_RIGHT_TALON_PORT = 10;
	//public static final int[] DRIVE_MOTOR_PORTS = { FRONT_LEFT_TALON_PORT, BACK_LEFT_TALON_PORT, BACK_RIGHT_TALON_PORT, FRONT_RIGHT_TALON_PORT };
	public static final int[] DRIVE_MOTOR_PORTS = { 11, 12, 13, 10 };

	// Drive disable orbit point buttons

	public static final int DRIVE_LEFT_BOTTOM = 7;
	public static final int DRIVE_LEFT_TOP = 6;
	public static final int DRIVE_RIGHT_BOTTOM = 10;
	public static final int DRIVE_RIGHT_TOP = 11;

	public static final int[] DRIVE_OP_BUTTONS = { DRIVE_LEFT_BOTTOM, DRIVE_LEFT_TOP, DRIVE_RIGHT_BOTTOM,
			DRIVE_RIGHT_TOP };

	// Drive Input magic numbers
	public static final double[] DRIVE_INPUT_MAGIC_NUMBERS = { -1.0, 1.0, -0.6 };
	public static final double DRIVE_INPUT_TURN_FACTOR = 0.2;

	public static final double DRIVE_INPUT_VISION_SPEED = 0.75;

	// Drive Front Side changing
	public static final int DRIVE_FRONTSIDE_FRONT = 1;
	public static final int DRIVE_FRONTSIDE_BACK = 1;

	// Glide gain
	public static final double[][] DRIVE_GLIDE_GAIN = { { 0.0015, 0.003 }, { 0.008, 0.008 } };

	// Drive Output magic numbers - for getting everything spinning the correct
	// direction
	public static final double[] DRIVE_OUTPUT_MAGIC_NUMBERS = { 1.0, 1.0, -1.0, -1.0 };

	public static final int DRIVE_MAX_UNLOGGED_LOOPS = 15;

	/**
	 * Robot config stuff
	 */
	public static final double ROBOT_WARNING_TIME_LONG = 20.0;
	public static final double ROBOT_WARNING_TIME_SHORT = 10.0;

	/**
	 * Buttons
	 */
	public static final int VISION_INTERFACE_CAMERA_PORT_BUTTON = 5;
	public static final int MASTER_OVERRIDE = 6; // RT1 -- RB

	/**
	 * Camera
	 */
	public static final long CAMERA_X = 180;
	public static final long CAMERA_Y = 160;

	/**
	 * Arduino addresses
	 */
	public static final byte ARDUINO_ADDRESS = 64;
	public static final byte GROUNDTRUTH_ADDRESS = 1;
	public static final byte ARM_LIGHTS_ADDRESS = 2;
	public static final byte ARM_MODE_ADDRESS = 3;
	public static final byte POST_LIGHTS_ADDRESS = 4;
	public static final byte POST_MODE_ADDRESS = 5;
	public static final byte PARTY_MODE_ADDRESS = 8;
	public static final byte PULSE_SPEED_ADDRESS = 11;

	/**
	 * Gear stuff
	 */
	public static final double GEAR_DISTANCE = .06;
	public static final double GEAR_GAIN = .75;
	public static final double GEAR_MAX_OUTPUT_POWER = .25;

	/**
	 * Ground truth sensor
	 */
	public static final byte GROUNDTRUTH_QUALITY_MINIMUM = 40;
	public static final double GROUNDTRUTH_DISTANCE_PER_COUNT = 1.0;
	public static final double GROUNDTRUTH_TURN_CIRCUMFERENCE = 3.1416 * 1.25;
	public static final int GROUNDTRUTH_SPEED_AVERAGING_SAMPLES = 4;

	// Maximum (empirically determined) speed the robot can go in its three
	// directions.
	public static final double[] GROUNDTRUTH_MAX_SPEEDS = { 12.0, 5.0, 7.0 };

	/**
	 * IO stuff
	 */

	// Joystick raw axes
	public static final int JOYSTICK_Y_AXIS = 1;
	public static final int JOYSTICK_X_AXIS = 0;


	/**
	 * Pneumatics stuff
	 */


	// norm/starting conditions arm down, lift down, facing alliance station
	public static final double CRASH_DETECTION_THRESHOLD_MULTIPLIER = 1.1;
	public static final int CRASH_DETECTION_DISTANCE_THRESHOLD = 700;
	public static final int CRASH_DETECTION_MODE = 0;
	public static final double DETECTION_DELAY = 1000;

	// {angle,strength/speed,turning,mode,time}
	// {forward, right, counterclock}
	/**
	 * Logger stuff
	 */
	public static enum LOGGED_CLASSES {
		SEMAPHORE, DRIVE, GROUNDTRUTH, PNEUMATICS, SHOOTER
	}

	public static final String TEAM_BANNER = "ICAgICAgICAgICBfX18gICAgICAgICAgICAgIF9fICBfXw0KICAgICAgICAgICAgfCBfIF8gIF8gICAgL3wgfF8gIC8gIFwgfF9ffA0KICAgICAgICAgICAgfCgtKF98fHx8ICAgIHwgX18pIFxfXy8gICAgfA0KDQogICAgICAgICAgICAgICAgICAgICAgICAgXy4NCiAgICAgICAgICAgICAgICAgICAgICAgLicgb28NCiAgICAgICAgICAgICAgICAgICAgICAgfCAgICA+DQogICAgICAgICAgICAgICAgICAgICAgLyAvIDogYC4NCiAgICAgICAgICAgICAgICAgICAgIHxfLyAvICAgfA0KICAgICAgICAgICAgICAgICAgICAgICB8LyAgd3cNCl9fXyAgICAgICAgX18gICAgICAgICAgICAgICAgICAgICAgX18NCiB8IHxfICBfICB8ICBcIF8gXyBfICBfIF8gXyB8XyBfICB8X18pXyBfICBfICAgIC4gXyAgXw0KIHwgfCApKC0gIHxfXy8oLV8pfF8pKC18IChffHxfKC0gIHwgICgtfCApKF8pfF98fHwgKV8pDQogICAgICAgICAgICAgICAgICB8ICAgICAgICAgICAgICAgICAgICAgICBfLw==";
	public static final String ROBOT_BANNER = "ICAgICAvXCAgICAgL1wgICAgICAgICAgICAgICoNCiAgICAnLiBcICAgLyAsJyAgICAgICAgICAgICAgXCAgIH4NCiAgICAgIGAuXC0vLCcgICAgICAgICAgICAgXywsIFwge10NCiAgICAgICAoIFggICApICAgICAgICAgICAiLT1cO19cICUNCiAgICAgICwnLyBcYC5cICAgICAgICAgICAgXyBcXDsoIyklDQogICAgLicgLyAgIFwgYCwgICAgICAgICAgIF9cfCBcXyUlDQogICAgIFwvLS0tLS1cLycgICAgICAgICAgIFwgIFwvXCAgXA0KX19fX19fIHxfSF9fX3xfX19fX19fX19fX19fX18gKCApfn5+X19fXw0KICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgfCBcDQogICAgICAgICAgICAgICAgICAgICAgICAgICAgIC8gIC8=";
}
