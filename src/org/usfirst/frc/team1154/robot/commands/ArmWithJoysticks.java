package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.Robot;
import org.usfirst.frc.team1154.robot.RobotMap;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

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
		Robot.arm.driveArm(stick);
		
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
