package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurnWithPID extends Command{
	
	private final int degreesToTurn;
	
	private final double speed;
	
	public TurnWithPID(int degreesToTurn){
		requires(Robot.drive);
		this.degreesToTurn = degreesToTurn;
		this.speed = Constants.defaultTurnSpeed;
		
	}

	@Override
	protected void initialize() {
		Robot.drive.resetEncoders();
		//Robot.drive.setGyroPID(.035, 0, .015); //proto
		Robot.drive.setGyroPID(.03, 0, .015);
		Robot.drive.setGyroSetPoint(degreesToTurn);
		Robot.drive.setMaxDrivePIDOutput(speed);
		Robot.drive.enablePID();
		
		
	}

	@Override
	protected void execute() {
		double gyroOutput = Robot.drive.getGyroPIDOutput();
		Robot.drive.arcadeDrive(0,gyroOutput);
		SmartDashboard.putNumber("Turn with PID - Degrees To Turn", degreesToTurn);
		SmartDashboard.putNumber("Turn with PID - Gyro PID Output", gyroOutput);
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
	
	private void stopTurning(){
		Robot.drive.arcadeDrive(0, 0);

	}

}
