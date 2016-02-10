package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurnWithPID extends Command{
	
	private final int degreesToTurn;
	
	public TurnWithPID(int degreesToTurn){
		requires(Robot.drive);
		this.degreesToTurn = degreesToTurn;
	}

	@Override
	protected void initialize() {
		Robot.drive.resetEncoders();
		Robot.drive.setGyroSetPoint(degreesToTurn);
	}

	@Override
	protected void execute() {
		double gyroOutput = Robot.drive.getGyroPIDOutput();
		Robot.drive.arcadeDrive(0,gyroOutput);		
		SmartDashboard.putNumber("Degrees To Turn", degreesToTurn);
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
	
	private void stopTurning(){
		Robot.drive.arcadeDrive(0, 0);

	}

}
