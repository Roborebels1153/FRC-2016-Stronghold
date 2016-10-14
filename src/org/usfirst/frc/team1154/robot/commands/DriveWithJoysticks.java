package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Constants;
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
	private double speed = 1.0;
	
	private Joystick driveStick = new Joystick(RobotMap.DRIVER_JOYSTICK);
	
	private Joystick bigBoyStick = new Joystick(RobotMap.OPERATOR_JOYSTICK);
	
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		 driveStick = Robot.oi.getDriverStick();
		 bigBoyStick = Robot.oi.getOperatorStick();

//		Robot.drive.arcadeDrive(bigBoyStick);
//		Robot.drive.arcadeDrive(driveStick);
		
		
		if((bigBoyStick.getRawAxis(1) > .5 || 
				bigBoyStick.getRawAxis(1) < -.5) ||
				(bigBoyStick.getRawAxis(4) > .5 ||
				bigBoyStick.getRawAxis(4) < -.5)) {
			Robot.drive.arcadeDrive(bigBoyStick);
		} else {
			speed = .65;
			Robot.drive.arcadeDrive(driveStick.getY() * speed , driveStick.getX() * speed);
		}
		
		
		if(bigBoyStick.getRawAxis(2) > .5){			
			Robot.drive.shiftHigh();
			
		} else{
			Robot.drive.shiftLow();
		}
		
		 if(bigBoyStick.getRawAxis(3) > .5){
			 Robot.drive.speedLow();
		 } else{
			 Robot.drive.speedNorm();
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
