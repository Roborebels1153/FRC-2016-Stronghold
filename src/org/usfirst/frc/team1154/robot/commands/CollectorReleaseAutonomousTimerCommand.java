package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CollectorReleaseAutonomousTimerCommand extends Command {
	
	private int runCount = 0;
	
	public CollectorReleaseAutonomousTimerCommand() {
		requires(Robot.collector);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		runCount = 0;
		Robot.collector.releaseBoulder();
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		runCount++;
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return runCount > 50; // about 1 seconds

	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.collector.stopCollecting();
		Robot.arm.disablePID();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		end();
	}
	

}
