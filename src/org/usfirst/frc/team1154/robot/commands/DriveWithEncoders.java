package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.Robot;
import org.usfirst.frc.team1154.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveWithEncoders extends Command {
	
	private final double inchesPerTick = Constants.WHEEL_DIAMETER * Math.PI / Constants.ENCODER_COUNTS_PER_REV; 
	
	private final int inchesToDrive;
	
	public DriveWithEncoders(int inchesToDrive) {
		requires(Robot.drive);
		this.inchesToDrive = inchesToDrive;
	}
	
	
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		double leftInchesDriven = inchesPerTick * Robot.drive.getLeftEncoderDistance();
		double rightInchesDriven = inchesPerTick * Robot.drive.getRightEncoderDistance();
		
		if (leftInchesDriven < inchesToDrive ||
			rightInchesDriven < inchesToDrive)  {
			driveStraight();
		} else {
			stopDriving();
		}
		
		SmartDashboard.putNumber("Inches To Drive", inchesToDrive);
		SmartDashboard.putNumber("Left Encoder In Inches", leftInchesDriven);
		SmartDashboard.putNumber("Right Encoder In Inches", rightInchesDriven);
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	
	private void driveStraight() {
		Robot.drive.arcadeDrive(0.75, 0);
	}
	
	private void stopDriving() {
		Robot.drive.arcadeDrive(0, 0);
	}

}
