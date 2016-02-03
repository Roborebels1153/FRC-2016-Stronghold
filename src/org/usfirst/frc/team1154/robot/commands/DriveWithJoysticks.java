package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Robot;
import org.usfirst.frc.team1154.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1154.robot.subsystems.Drive;

public class DriveWithJoysticks extends Command {
	public DriveWithJoysticks() {
		requires(Robot.drive);
	}
	
	private Joystick driveStick = new Joystick(RobotMap.DRIVER_JOYSTICK);
	
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		Joystick stick = Robot.oi.getDriverStick();
		Robot.drive.arcadeDrive(stick);
		
		SmartDashboard.putNumber("Left Encoder", Robot.drive.getLeftEncoderDistance());
		SmartDashboard.putNumber("Right Encoder", Robot.drive.getRightEncoderDistance());
		SmartDashboard.putNumber("Right Trigger", stick.getRawAxis(3));
		
		if(driveStick.getRawAxis(2) > .5){			
			Robot.drive.shiftHigh();
			
		}else{
			Robot.drive.shiftLow();
		}
		
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
