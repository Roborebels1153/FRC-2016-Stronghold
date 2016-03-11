package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.commands.DoNothingCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StayStillAutonomous extends CommandGroup {
	public StayStillAutonomous() {
		addSequential(new DoNothingCommand());
	}
	}
