package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class RampartCrossCommand extends Command {
	
	private final double turnSpeed = 0.3;
	
	public RampartCrossCommand(){
		requires(Robot.drive); 
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.drive.disablePID();
		Robot.drive.speedLow();
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.drive.arcadeDrive(Robot.oi.getDriverStick().getY(), turnSpeed);
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Scheduler.getInstance().add(new DriveWithJoysticks());
		
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		end();
	}

}
