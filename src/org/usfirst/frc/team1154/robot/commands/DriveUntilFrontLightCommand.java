package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveUntilFrontLightCommand extends Command {
	
	public DriveUntilFrontLightCommand() {
		requires(Robot.drive);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.drive.resetEncoders();
		Robot.drive.enablePID();
		
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.drive.arcadeDrive(-Constants.defaultMaxSpeed, 0); //Robot.drive.getGyroPIDOutput());
	
			
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Robot.drive.getFrontLightSensor() == false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.drive.disablePID();
		Robot.drive.resetEncoders();
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
