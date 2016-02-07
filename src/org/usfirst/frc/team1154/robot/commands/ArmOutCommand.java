package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArmOutCommand extends Command {
	public ArmOutCommand(){
		requires(Robot.arm);
	}

	@Override
	protected void initialize() {
		Robot.arm.disablePID();
		Robot.arm.out();
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		//Calls collector
		return Robot.arm.getArmOut();
	}

	@Override
	protected void end() {
		//Stops the pivot motor when end is called
		Robot.arm.stopArm();
		
	}

	@Override
	protected void interrupted() {
		
		end();
	}

}
