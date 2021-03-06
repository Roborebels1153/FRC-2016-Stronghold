package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.commands.ArmInCommand;
import org.usfirst.frc.team1154.robot.commands.ArmOutCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseAutonomousCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseTeleopCommand;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;
import org.usfirst.frc.team1154.robot.commands.TurnWithPID;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoatAutonomousWithScore extends CommandGroup{
	public MoatAutonomousWithScore() {
		addSequential(new DriveWithPID(180 , Constants.defaultMaxSpeed));
		addSequential(new TurnWithPID(90));
		addSequential(new DriveWithPID(80 , Constants.defaultMaxSpeed));
		addSequential(new ArmOutCommand());
		addSequential(new CollectorReleaseAutonomousCommand());
		addSequential(new ArmInCommand());
	}
}