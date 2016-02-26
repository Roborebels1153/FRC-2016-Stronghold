package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.commands.ArmOutCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SpitOutBallCommand extends CommandGroup {
	public SpitOutBallCommand() {
		addSequential(new ArmOutCommand());
		addSequential(new CollectorReleaseCommand());
	}

}
