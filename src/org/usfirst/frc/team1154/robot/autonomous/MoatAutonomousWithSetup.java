package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.commands.ArmOutCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseCommand;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;
import org.usfirst.frc.team1154.robot.commands.TurnWithPID;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoatAutonomousWithSetup extends CommandGroup {
	public MoatAutonomousWithSetup() {
		addSequential(new DriveWithPID(180));
		addSequential(new ArmOutCommand());
		addSequential(new CollectorReleaseCommand());
		addSequential(new TurnWithPID(270));
		addSequential(new DriveWithPID(24));
		addSequential(new TurnWithPID(180));
	}

}
