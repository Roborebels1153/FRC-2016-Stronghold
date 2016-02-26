package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CollectorReleaseCommand extends Command {
	
	public CollectorReleaseCommand(){
		requires(Robot.collector);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.collector.releaseBoulder();
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Robot.collector.getBallLightSensor();
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
