package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.commands.ArmInCommand;
import org.usfirst.frc.team1154.robot.commands.ArmOutCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseAutonomousCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseAutonomousTimerCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseTeleopCommand;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;
import org.usfirst.frc.team1154.robot.commands.TurnWithPID;
import org.usfirst.frc.team1154.robot.commands.WaitInbetweenCommandsCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RoughTerrainAutonomousWithScoreInFive extends CommandGroup{
	public RoughTerrainAutonomousWithScoreInFive() {
		addSequential(new DriveWithPID(230 , Constants.roughTerrain));
		addSequential(new WaitInbetweenCommandsCommand(1));
//		addSequential(new DriveWithPID(268 , Constants.roughTerrain));
//		addSequential(new TurnWithPID(359));
//		addSequential(new WaitInbetweenCommandsCommand(2));
		addSequential(new TurnWithPID(310));
		addSequential(new WaitInbetweenCommandsCommand(2));
		addSequential(new DriveWithPID(24 , Constants.approachingGoalSpeed));
		addSequential(new ArmOutCommand());
		addSequential(new CollectorReleaseAutonomousTimerCommand());
		addSequential(new ArmInCommand());
	}
}