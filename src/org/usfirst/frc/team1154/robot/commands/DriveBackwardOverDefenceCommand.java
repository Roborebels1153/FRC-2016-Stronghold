package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveBackwardOverDefenceCommand extends Command {

	private double speed;
	
	private double inchesToDrive = 20;
	
	public DriveBackwardOverDefenceCommand(double defenseSpeed) {
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
		Robot.drive.arcadeDrive(this.speed, 0); //Robot.drive.getGyroPIDOutput());
		if(Robot.drive.getFrontLightSensor()) {
			Robot.drive.startedCrossingDefence();
		}
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		 return !(Robot.drive.getFrontLightSensor() || Robot.drive.getBackLightSensor()) &&
				 Robot.drive.getCrossingDefence() &&
				 Robot.drive.getLeftEncoderDistance() > inchesToDrive / Constants.inchesPerTick;

	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.drive.disablePID();
		Robot.drive.resetEncoders();
		Robot.drive.resetCrossingDefence();
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
