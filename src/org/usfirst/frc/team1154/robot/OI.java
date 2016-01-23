package org.usfirst.frc.team1154.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team1154.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Joystick driveStick = new Joystick(RobotMap.DRIVER_JOYSTICK = 0);
	private Joystick opStick = new Joystick(RobotMap.DRIVER_JOYSTICK = 1);
	/**
	 * The abbreviations are as follows: LB = left Bumper RB = right Bumper BA = Back button ST = Start Button
	 * 									LJ = left Joystick RJ = right Joystick
	 */
	private Button buttonA = new JoystickButton(opStick,0);
	private Button buttonB = new JoystickButton(opStick,1);
	private Button buttonX = new JoystickButton(opStick,2);
	private Button buttonY = new JoystickButton(opStick,3);
	private Button buttonLB = new JoystickButton(opStick,4);
	private Button buttonRB = new JoystickButton(opStick,5);
	private Button buttonBA = new JoystickButton(opStick,7);
	private Button buttonST = new JoystickButton(opStick,6);
	private Button buttonLJ = new JoystickButton(opStick,8);
	private Button buttonRJ = new JoystickButton(opStick,9);
	
	
	public Joystick getDriverStick(){
		return driveStick;
	}
	
}


