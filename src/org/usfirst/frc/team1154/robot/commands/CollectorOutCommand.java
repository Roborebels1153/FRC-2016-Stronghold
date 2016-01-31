package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CollectorOutCommand extends Command {
	public CollectorOutCommand(){
		requires(Robot.collect);
	}

	@Override
	protected void initialize() {
		
		Robot.collect.out();
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		//Calls collector
		return Robot.collect.getCollectorOut();
	}

	@Override
	protected void end() {
		//Stops the pivot motor when end is called
		Robot.collect.stopPivoting();
	}

	@Override
	protected void interrupted() {
		
		end();
	}

}
