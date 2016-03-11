package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.commands.DriveAtSpeedCommand;
import org.usfirst.frc.team1154.robot.commands.DriveUntilFrontLightCommand;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ChevalAutonomous extends CommandGroup {
	public ChevalAutonomous() {
		addSequential(new DriveWithPID(55));
//		addSequential(new DriveUntilFrontLightCommand());
//		addSequential(new DriveAtSpeedCommand(-1));
		}

}
