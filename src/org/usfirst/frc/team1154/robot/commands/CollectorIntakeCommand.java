package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CollectorIntakeCommand extends Command {
	
	public CollectorIntakeCommand(){
		requires(Robot.collector);
	}


	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.collector.collectBoulder();
	}

	@Override
	protected boolean isFinished() {
		return !Robot.collector.getBallLightSensor();
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
