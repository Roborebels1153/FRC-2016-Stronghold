package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveWithJoysticks extends Command {
	public DriveWithJoysticks() {
		requires(Robot.drive);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		Joystick stick = Robot.oi.getDriverStick();
		if(stick.getRawAxis(3) > .5) {
			Robot.drive.nicDrive(stick);
		}
		else {
			Robot.drive.arcadeDrive(Robot.oi.getDriverStick());
		}
		
		SmartDashboard.putNumber("Left Encoder", Robot.drive.getLeftEncoderDistance());
		SmartDashboard.putNumber("Right Encoder", Robot.drive.getRightEncoderDistance());
		SmartDashboard.putNumber("Right Trigger", stick.getRawAxis(3));
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
}
