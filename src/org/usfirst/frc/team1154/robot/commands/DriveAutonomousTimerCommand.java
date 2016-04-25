package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveAutonomousTimerCommand extends Command {
	
	private int runCount = 0;
	private double stopCount;
	private double speed;
	
	public DriveAutonomousTimerCommand(double speed, double time) {
		requires(Robot.drive);
		this.speed = speed;
		this.stopCount = time * 50;
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		runCount = 0;
		Robot.drive.disablePID();	
	}

	@Override
	protected void execute() {
		runCount++;
		Robot.drive.arcadeDrive(-this.speed, 0.5);
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return runCount > stopCount; // about 1 seconds

	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.collector.stopCollecting();
		Robot.arm.disablePID();
		Robot.drive.disablePID();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		end();
	}
	

}
