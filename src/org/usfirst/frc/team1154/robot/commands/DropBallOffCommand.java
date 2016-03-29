package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DropBallOffCommand extends Command {
	public DropBallOffCommand() {
		requires(Robot.arm);
		requires(Robot.collector);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.arm.disablePID();
		Robot.arm.out();
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
		Robot.arm.stopArm();
		Robot.collector.stopCollecting();
		Robot.arm.in();
		Robot.arm.armLimitHitIn(); //my name is Toshak and I like to Toshak things all the time in the hood cus im a Troshak lookin guy
		
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		end();
	}
	

}
