package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArmMoveForTimeCommand extends Command {
	
	public ArmMoveForTimeCommand() {
		requires(Robot.arm);
	}
	

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.arm.armMotorSet(0.7);
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Robot.arm.getArmIn() | Robot.arm.getArmOut();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.arm.stopArm();;
		Robot.arm.resetArmEncoder();
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	

}
