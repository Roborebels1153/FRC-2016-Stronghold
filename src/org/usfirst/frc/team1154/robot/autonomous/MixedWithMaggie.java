package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.commands.DriveWithPID;
import org.usfirst.frc.team1154.robot.commands.TurnWithPID;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MixedWithMaggie extends CommandGroup {
	public MixedWithMaggie() {
		addSequential(new DriveWithPID(-48));
		addSequential(new TurnWithPID(90));
//		addSequential(new DriveWithPID(12));
//		addSequential(new DriveWithPID(-12));
	}

}
