package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveUntilLightSensors extends Command {
	
	private int runCount = 0;
	
	public DriveUntilLightSensors() {
		requires(Robot.drive);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		runCount = 0;
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		runCount++;
		Robot.drive.arcadeDrive(0.9, 0);
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return runCount > 450  ;
//		Robot.drive.getForwardLightSensors() || 
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
