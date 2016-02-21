package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.Robot;
import org.usfirst.frc.team1154.robot.RobotMap;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArmWithJoysticks extends Command {
	
	private final double speed;
	
	public ArmWithJoysticks(double speed) {
		requires(Robot.arm);
		this.speed = Constants.defaultArmSpeed;

	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.arm.disablePID();
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Joystick stick = Robot.oi.getOperatorStick();
		
		if (Robot.oi.getOperatorStick().getRawButton(5)) {
			Robot.arm.driveArm(stick);
		}else if (Robot.arm.getArmIn() && Robot.arm.getArmOutput() < 0.1) {
			Robot.arm.driveArm(0);
		} else if (Robot.arm.getArmOut() && Robot.arm.getArmOutput() < 0.1) {
			Robot.arm.driveArm(0);
		} else {
			Robot.arm.driveArm(stick);
		}
		
		SmartDashboard.putBoolean("Arm With Joysticks IN STOP", Robot.arm.getArmIn() && Robot.arm.getArmOutput() < 0.1);
		SmartDashboard.putBoolean("Arm With Joysticks OUT STOP", Robot.arm.getArmOut() && Robot.arm.getArmOutput() > 0.1);
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
