package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.commands.ArmInCommand;
import org.usfirst.frc.team1154.robot.commands.ArmOutCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseAutonomousCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseAutonomousTimerCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseTeleopCommand;
import org.usfirst.frc.team1154.robot.commands.DriveAutonomousTimerCommand;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;
import org.usfirst.frc.team1154.robot.commands.TurnWithPID;
import org.usfirst.frc.team1154.robot.commands.WaitInbetweenCommandsCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class BackUpAndScore extends CommandGroup{
	public BackUpAndScore() {
		addSequential(new DriveWithPID(260, Constants.rockWall));
		addSequential(new DriveAutonomousTimerCommand(Constants.rockWall, 1));
//		addSequential(new DriveWithPID(230 , Constants.roughTerrain));
//		addSequential(new DriveWithPID(30 , Constants.roughTerrain));
		addSequential(new WaitInbetweenCommandsCommand(.75));
		addSequential(new DriveWithPID(-7, Constants.roughTerrain));
//		addSequential(new WaitInbetweenCommandsCommand(1));
		addSequential(new TurnWithPID(309));
		addSequential(new WaitInbetweenCommandsCommand(2));
		addSequential(new DriveWithPID(40, Constants.roughTerrain));
		addSequential(new ArmOutCommand());
		addSequential(new CollectorReleaseAutonomousTimerCommand());
		addSequential(new ArmInCommand());
	}
}