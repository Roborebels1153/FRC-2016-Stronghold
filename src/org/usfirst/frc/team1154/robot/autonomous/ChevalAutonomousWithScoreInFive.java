package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.commands.ArmInCommand;
import org.usfirst.frc.team1154.robot.commands.ArmOutCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseAutonomousTimerCommand;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;
import org.usfirst.frc.team1154.robot.commands.TurnWithPID;
import org.usfirst.frc.team1154.robot.commands.WaitInbetweenCommandsCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ChevalAutonomousWithScoreInFive extends CommandGroup {
	public ChevalAutonomousWithScoreInFive() {
		addSequential(new DriveWithPID(91, Constants.defaultChevalAutoSpeedOne));
		addSequential(new WaitInbetweenCommandsCommand(0.5));
//		addSequential(new DriveWithPID(-1, Constants.defaultChevalAutoSpeedOne));
		addSequential(new WaitInbetweenCommandsCommand(0.5));
		addSequential(new ArmOutCommand());
		addSequential(new DriveWithPID(20, Constants.defaultChevalAutoSpeedTwo));
		addSequential(new ArmInCommand());
		addSequential(new DriveWithPID(40, Constants.defaultChevalAutoSpeedTwo));
		addSequential(new DriveWithPID(120, Constants.defaultChevalAutoSpeedOne));
		addSequential(new WaitInbetweenCommandsCommand(0.5));
//		addSequential(new DriveWithPID(-12, Constants.defaultChevalAutoSpeedTwo));
		addSequential(new WaitInbetweenCommandsCommand(0.5));
		addSequential(new TurnWithPID(310));
		addSequential(new WaitInbetweenCommandsCommand(2));
		addSequential(new DriveWithPID(20, Constants.approachingGoalSpeed));
		addSequential(new ArmOutCommand());
		addSequential(new CollectorReleaseAutonomousTimerCommand());
		addSequential(new ArmInCommand());


	}

}
