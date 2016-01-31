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
	
	private double leftInchesDriven;
	
	private double rightInchesDriven;
	
	public DriveWithEncoders(int inchesToDrive) {
		requires(Robot.drive);
		this.inchesToDrive = inchesToDrive;
	}
	
	
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.drive.resetEncoders();
		Robot.drive.setSetPoint(inchesToDrive / inchesPerTick);
	}

	@Override
	protected void execute() {
		
		Robot.drive.setSetPoint(inchesToDrive / inchesPerTick);
		
		leftInchesDriven = inchesPerTick * Robot.drive.getLeftEncoderDistance();
		rightInchesDriven = inchesPerTick * Robot.drive.getRightEncoderDistance();
		

		
		SmartDashboard.putNumber("Inches To Drive", inchesToDrive);
		SmartDashboard.putNumber("Left Encoder In Inches", leftInchesDriven);
		SmartDashboard.putNumber("Right Encoder In Inches", rightInchesDriven);
		SmartDashboard.putNumber("Dillo", inchesToDrive / inchesPerTick);
		SmartDashboard.putNumber("Legit Value", Robot.drive.getLeftEncoderDistance());
		SmartDashboard.putNumber("PID Output", Robot.drive.getPIDOutput());
		SmartDashboard.putNumber("Motor Output", Robot.drive.getMotorOutput());
		
	}

	@Override
	protected boolean isFinished() {
		return false;
//		return leftInchesDriven < inchesToDrive;
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
		//Robot.drive.arcadeDrive(Robot.d, 0);
	}
	
	private void stopDriving() {
		Robot.drive.arcadeDrive(0, 0);
	}

}
