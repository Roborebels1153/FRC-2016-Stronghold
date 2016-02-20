package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveOverDefenceCommand extends Command {
	
	private double speed;
	
	public DriveOverDefenceCommand(double defenseSpeed) {
		requires(Robot.drive);
		this.speed = defenseSpeed;
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.drive.resetEncoders();
		Robot.drive.disablePID();
		Robot.drive.enableGyroPID();
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.drive.arcadeDrive(-this.speed, Robot.drive.getGyroPIDOutput());
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		 return Robot.drive.getFrontLightSensor() && Robot.drive.getBackLightSensor();
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
