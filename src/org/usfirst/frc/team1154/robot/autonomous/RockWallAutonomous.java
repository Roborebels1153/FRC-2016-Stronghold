package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.commands.ArmOutCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseCommand;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;
import org.usfirst.frc.team1154.robot.commands.TurnWithPID;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RockWallAutonomous extends CommandGroup {
	public RockWallAutonomous() {
		addSequential(new DriveWithPID(180 , Constants.rockWall));
		addSequential(new ArmOutCommand());
		addSequential(new CollectorReleaseCommand());
	}

}
