package org.usfirst.frc.team1154.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team1154.robot.commands.ArmSetHeight;
import org.usfirst.frc.team1154.lib.RebelTrigger;
import org.usfirst.frc.team1154.robot.commands.ArmInCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorIntakeCommand;
import org.usfirst.frc.team1154.robot.commands.ArmOutCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseCommand;
import org.usfirst.frc.team1154.robot.subsystems.Arm.ArmHeight;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Joystick driveStick = new Joystick(RobotMap.DRIVER_JOYSTICK);
	private Joystick opStick = new Joystick(RobotMap.OPERATOR_JOYSTICK);
	/**
	 * The abbreviations are as follows: LB = left Bumper RB = right Bumper BA = Back button ST = Start Button
	 * 									LJ = left Joystick RJ = right Joystick
	 */
	private Button opA = new JoystickButton(opStick,1);
	private Button opB = new JoystickButton(opStick,2);
	private Button opX = new JoystickButton(opStick,3);// When X is pressed the collector goes to the park
	private Button opY = new JoystickButton(opStick,4);// when Y is pressed the arm climbs the gate
	private Button opLB = new JoystickButton(opStick,5);
	private Button opRB = new JoystickButton(opStick,6);//When RB is pressed the arm goes to the seesaws
	private Button opBA = new JoystickButton(opStick,7);
	private Button opST = new JoystickButton(opStick,8);
	private Button opLJ = new JoystickButton(opStick,9);
	private Button opRJ = new JoystickButton(opStick,10);
	private Button opLT = new RebelTrigger(opStick,2);
	private Button opRT = new RebelTrigger(opStick,3);
	
	public OI(){
		opX.whenPressed(new ArmInCommand());
		opB.whenPressed(new ArmSetHeight(ArmHeight.HIGH));
		opA.whenPressed(new ArmSetHeight(ArmHeight.LOW));
		opY.whenPressed(new ArmOutCommand());
		opLT.whileHeld(new CollectorIntakeCommand());
		opRT.whileHeld(new CollectorReleaseCommand());
	}
	
	public Joystick getDriverStick(){
		return driveStick;
	}
	
	public Joystick getOperatorStick(){
		return opStick;
	}
	
	
	
}


