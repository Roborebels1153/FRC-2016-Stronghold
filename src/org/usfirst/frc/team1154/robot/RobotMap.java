package org.usfirst.frc.team1154.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static int LEFT_FRONT_MOTOR = 0;
	public static int LEFT_BACK_MOTOR = 1;
	public static int RIGHT_FRONT_MOTOR = 2;
	public static int RIGHT_BACK_MOTOR = 3;
	public static int COLLECTOR_ROLLERS = 4;
	public static int ARM_MOTOR = 5;
	
	public static int DRIVER_JOYSTICK = 0;
	public static int OPERATOR_JOYSTICK = 1; 
	
	public static int LEFT_ENCODER_A_CHANNEL = 0;
	public static int LEFT_ENCODER_B_CHANNEL = 1;
	public static int RIGHT_ENCODER_A_CHANNEL = 2;
	public static int RIGHT_ENCODER_B_CHANNEL = 3;
	public static int ARM_IN_SWITCH = 4;
	public static int ARM_OUT_SWITCH = 5;
	public static int BALL_LIGHT_SENSOR = 6;
	public static int FRONT_LIGHT_SENSOR = 7;
	public static int BACK_LIGHT_SENSOR = 8;
	public static int FORWARD_LIGHT_SENSOR_ONE = 12;
	public static int FORWARD_LIGHT_SENSOR_TWO = 13;
	public static int ARM_ENCODER_A_CHANNEL = 10;
	public static int ARM_ENCODER_B_CHANNEL = 11;
	
	public static int ULTRASONIC_ECHO_PULSE_OUTPUT = 0;
	public static int ULTRASONIC_TRIGGER_PULSE_INPUT = 1;

	

	public static int TRANSMISSION_SOLENOID_A = 0;
	public static int TRANSMISSION_SOLENOID_B = 1;
	public static int CLIMBER_SOLENOID_A = 2;
	public static int CLIMBER_SOLENOID_B = 3;
	public static int CLIMBER_SOLENOID_C = 4;
	public static int CLIMBER_SOLENOID_D = 5;


	
	
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
