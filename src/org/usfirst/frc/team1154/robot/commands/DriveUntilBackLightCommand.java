package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveUntilBackLightCommand extends Command {
	
	private double speed;
	
	public DriveUntilBackLightCommand(double defenceSpeed) {
		requires(Robot.drive);
		this.speed = defenceSpeed;
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
		Robot.drive.arcadeDrive(speed, 0);
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return !Robot.drive.getFrontLightSensor();
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
