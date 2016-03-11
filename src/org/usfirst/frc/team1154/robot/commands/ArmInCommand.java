package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArmInCommand extends Command{
	public ArmInCommand(){
		requires(Robot.arm);
	}

	@Override
	protected void initialize() {
		Robot.arm.disablePID();
		Robot.arm.in();
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		
		return Robot.arm.getArmIn();
	}

	@Override
	protected void end() {
		//Stops the pivot motor when end is called
		Robot.arm.stopArm();
		Robot.arm.resetArmEncoder();
		
	}

	@Override
	protected void interrupted() {

		end();
	}

}
