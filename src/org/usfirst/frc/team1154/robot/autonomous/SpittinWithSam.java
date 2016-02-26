package org.usfirst.frc.team1154.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SpittinWithSam extends CommandGroup {
	public SpittinWithSam() {
		addSequential(new SpitOutBallCommand());
	}

}
