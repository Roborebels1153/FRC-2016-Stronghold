package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class ChevalCrossCommand extends Command {
	public ChevalCrossCommand() {
		requires(Robot.drive);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.drive.enablePID();
		Robot.drive.speedLow();
		
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.drive.arcadeDrive(-Constants.defaultHalfSpeed, 0);
		
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
