package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArmStopCommand extends Command{
	public ArmStopCommand() {
		requires(Robot.arm);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.arm.disablePID();
		Robot.arm.stopArm();
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.arm.stopArm();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub\
		return true;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.arm.stopArm();
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
		end();
		
	}

}
