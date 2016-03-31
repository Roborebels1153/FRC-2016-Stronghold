package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnWithLeft extends Command {
	
	private final int degreesToTurn;
	
	private final double speed;
	
	public TurnWithLeft(int degreesToTurn) {
		this.degreesToTurn = degreesToTurn;
		this.speed = Constants.defaultTurnSpeed;		
	}
	
	public TurnWithLeft(int degreesToTurn, double speed) {
		this.degreesToTurn = degreesToTurn;
		this.speed = speed;
		
	}
	

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.drive.resetEncoders();
		Robot.drive.setGyroPID(.035, 0, .015); //proto
		//Robot.drive.setGyroPID(.03, 0, 0);
		Robot.drive.setGyroSetPoint(degreesToTurn);
		Robot.drive.setMaxDrivePIDOutput(speed);
		Robot.drive.enableLeftPID();
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		double gyroOutput = Robot.drive.getGyroPIDOutput();
		Robot.drive.arcadeDrive(0,gyroOutput);
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Robot.drive.gyroOnTarget();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.drive.disablePID();
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	
	

}
