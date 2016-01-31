package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CollectorInCommand extends Command{
	public CollectorInCommand(){
		requires(Robot.collect);
	}

	@Override
	protected void initialize() {
		
		Robot.collect.in();
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		
		return Robot.collect.getCollectorIn();
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
