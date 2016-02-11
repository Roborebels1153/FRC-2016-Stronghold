package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.commands.TurnWithPID;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TurninWithTyler extends CommandGroup {
	public TurninWithTyler() {
		addSequential(new TurnWithPID(270));
	}
}