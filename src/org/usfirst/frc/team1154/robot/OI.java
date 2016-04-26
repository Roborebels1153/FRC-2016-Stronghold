package org.usfirst.frc.team1154.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team1154.robot.commands.ArmSetHeight;
import org.usfirst.frc.team1154.robot.commands.ArmStopCommand;
import org.usfirst.frc.team1154.robot.commands.ChevalCrossCommand;
import org.usfirst.frc.team1154.lib.RebelTrigger;
import org.usfirst.frc.team1154.robot.autonomous.DrawbridgeBackwardsCommand;
import org.usfirst.frc.team1154.robot.autonomous.LowBarAutonomous;
import org.usfirst.frc.team1154.robot.autonomous.SpitOutBallCommand;
import org.usfirst.frc.team1154.robot.commands.ArmInCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorIntakeCommand;
import org.usfirst.frc.team1154.robot.commands.ArmOutCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseTeleopCommand;
import org.usfirst.frc.team1154.robot.commands.DriveForwardOverDefenceCommand;
import org.usfirst.frc.team1154.robot.commands.DriveUntilFrontLightCommand;
import org.usfirst.frc.team1154.robot.commands.DriveWithJoysticks;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;
import org.usfirst.frc.team1154.robot.commands.SallyPortTurn;
import org.usfirst.frc.team1154.robot.commands.RampartCrossCommand;
import org.usfirst.frc.team1154.robot.commands.ResetEncoders;
import org.usfirst.frc.team1154.robot.commands.TurnWithPID;
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
	private Button opLB = new JoystickButton(opStick,5);// when LB is pressed the arm does the sthaping
	private Button opRB = new JoystickButton(opStick,6);//When RB is pressed the arm goes to the seesaws
	private Button opBA = new JoystickButton(opStick,7);
	private Button opST = new JoystickButton(opStick,8);
	private Button opLJ = new JoystickButton(opStick,9);
	private Button opRJ = new JoystickButton(opStick,10);
	private Button opLT = new RebelTrigger(opStick,2);//When LT is pressed and held, the collector starts spittin up da ball
	private Button opRT = new RebelTrigger(opStick,3);//When RT is pressed and held, the collector starts suckin up da ball
	
	/**
	 * The D added on is just to differentiate between Driver Stick and Operator Stick
	 */
	private Button drA = new JoystickButton(driveStick,1);
	private Button drB = new JoystickButton(driveStick,2);
	private Button drX = new JoystickButton(driveStick,3);
	private Button drY = new JoystickButton(driveStick,4);
	private Button drLB = new JoystickButton(driveStick,5);
	private Button drRB = new JoystickButton(driveStick,6);
	private Button drBA = new JoystickButton(driveStick,7);
	private Button drST = new JoystickButton(driveStick,8);
	private Button drLJ = new JoystickButton(driveStick,9);
	private Button drRJ = new JoystickButton(driveStick,10);
	private Button drLT = new RebelTrigger(driveStick,2);
	private Button drRT = new RebelTrigger(driveStick,3);
	
	public OI(){
		
		opA.whenPressed(new ArmInCommand());
		opB.whenPressed(new ArmOutCommand());
		opLT.whileHeld(new CollectorReleaseTeleopCommand());
		opRT.whileHeld(new CollectorIntakeCommand());
		opLB.whenPressed(new ArmStopCommand());
		opRB.whenPressed(new ArmSetHeight(ArmHeight.SCORE));
		//Test Stuff, we can get rid of this whenever we actually need these buttons.
		opY.whenPressed(new ArmSetHeight(ArmHeight.HIGH));
		opX.whenPressed(new ArmSetHeight(ArmHeight.SPIT));
		opST.whenPressed(new ArmSetHeight(ArmHeight.PORT));
		
		
		drA.whileHeld(new ChevalCrossCommand());
		drY.whenPressed(new DrawbridgeBackwardsCommand());
		drX.whenPressed(new ResetEncoders());
		drB.whenPressed(new TurnWithPID(180));
		drLB.whenPressed(new DriveWithJoysticks());// stops any command that y9ou are driving.
	
		
		
//		drA.whileHeld(new RampartCrossCommand());
//		drB.whenPressed(new TurnWithPID(90));
//		drX.whenPressed(new DriveWithPID(30));
//		drY.whenPressed(new ResetEncoders());
//		drST.whenPressed(new LowBarAutonomous());
//		drBA.whenPressed(new DriveOverDefenceCommand());
		
		
	}
	
	public Joystick getDriverStick(){
		return driveStick;
	}
	
	public Joystick getOperatorStick(){
		return opStick;
	}
	
	
	
}


