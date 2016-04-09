package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class WaitInbetweenCommandsCommand extends Command {
	
	private double runCount;
	
	private int timer = 0;
	
	public WaitInbetweenCommandsCommand(double runCount) {
		this.runCount = runCount * 50;
		
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		timer = 0;
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		timer++;
		Robot.drive.arcadeDrive(0, 0);
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return timer > runCount;
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
