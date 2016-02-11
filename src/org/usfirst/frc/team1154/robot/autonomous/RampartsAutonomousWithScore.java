package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.commands.ArmOutCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseCommand;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;
import org.usfirst.frc.team1154.robot.commands.TurnWithPID;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RampartsAutonomousWithScore extends CommandGroup {
	public RampartsAutonomousWithScore() {
		addSequential(new DriveWithPID(180));
		addSequential(new TurnWithPID(90));
		addSequential(new DriveWithPID(80));
		addSequential(new ArmOutCommand());
		addSequential(new CollectorReleaseCommand());
	}

}
