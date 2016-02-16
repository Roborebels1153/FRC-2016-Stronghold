package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

//public class DrawbridgeTurn extends Command  {
//	public DrawbridgeTurn() {
//		requires(Robot.drive);
//	}
//
//	@Override
//	protected void initialize() {
//		// TODO Auto-generated method stub
//		Robot.drive.disablePID();
//		
//	}
//
//	@Override
//	protected void execute() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	protected boolean isFinished() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	protected void end() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	protected void interrupted() {
//		// TODO Auto-generated method stub
//		
//	}
//	
//}

public class SallyPortTurn extends CommandGroup {
	public SallyPortTurn() {
		addSequential(new DriveWithPID(-36));
		addSequential(new TurnWithPID(180));
		addSequential(new DriveWithPID(98));
		
	}

}
