package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.Robot;
import org.usfirst.frc.team1154.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveWithPID extends Command {
	
	private final int inchesToDrive;
	
	private double leftInchesDriven;
	
	private double rightInchesDriven;
	
	private final double speed;
	
	public DriveWithPID(int inchesToDrive) {
		requires(Robot.drive);
		this.inchesToDrive = inchesToDrive;
		this.speed = Constants.defaultMaxSpeed;
	}
	
	public DriveWithPID(int inchesToDrive, double speed) {
		requires(Robot.drive);
		this.inchesToDrive = inchesToDrive;
		this.speed = speed;
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.drive.resetEncoders();
		Robot.drive.setEncoderSetPoint(inchesToDrive / Constants.inchesPerTick);
		Robot.drive.setGyroSetPoint(0);
		Robot.drive.setMaxPIDOutput(speed);
		Robot.drive.enablePID();
		
	}

	@Override
	protected void execute() {
		double leftOutput = Robot.drive.getLeftPIDOutput();
		double rightOutput = Robot.drive.getRightPIDOutput();
		double gyroOutput = Robot.drive.getGyroPIDOutput();
		
		double averageOutput = leftOutput + rightOutput / 2;
		//TODO: replace with average output when using on Real Robot
		Robot.drive.arcadeDrive(-leftOutput, gyroOutput);
		
		leftInchesDriven = Constants.inchesPerTick * Robot.drive.getLeftEncoderDistance();
		rightInchesDriven = Constants.inchesPerTick * Robot.drive.getRightEncoderDistance();

		SmartDashboard.putNumber("Drive With PID - Inches To Drive", inchesToDrive);
		SmartDashboard.putNumber("Drive With PID - Left Encoder In Inches", leftInchesDriven);
		SmartDashboard.putNumber("Drive With PID - Right Encoder In Inches", rightInchesDriven);
		SmartDashboard.putNumber("Drive With PID - Sven-Olaf EncoderTick WallDoff", inchesToDrive / Constants.inchesPerTick);
		SmartDashboard.putNumber("Drive With PID - Legit Value", Robot.drive.getLeftEncoderDistance());
		SmartDashboard.putNumber("Drive With PID - Left PID Output", Robot.drive.getLeftPIDOutput());
		SmartDashboard.putNumber("Drive With PID - Right PID Output", Robot.drive.getRightPIDOutput());
		SmartDashboard.putNumber("Drive With PID - Left PID Setpoint", Robot.drive.getLeftPIDSetpoint());
		SmartDashboard.putNumber("Drive With PID - Right PID Setpoint", Robot.drive.getRightPIDSetpoint());
		SmartDashboard.putNumber("Drive With PID - Gyro PID Output", Robot.drive.getGyroPIDOutput());
		SmartDashboard.putBoolean("Drive With PID - On Target", Robot.drive.isOnTarget());

		
	}

	@Override
	protected boolean isFinished() {
		return Robot.drive.isOnTarget();
	}

	@Override
	protected void end() {
		Robot.drive.resetEncoders();
		Robot.drive.disablePID();
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	
}
