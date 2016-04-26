package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RoughTerrainAutonomousInFive extends CommandGroup {
	public RoughTerrainAutonomousInFive() {
		addSequential(new DriveWithPID(260 , Constants.defaultMaxSpeed));
//		addSequential(new TurnWithPID(309));
//		addSequential(new DriveWithPID(50 , Constants.approachingGoalSpeed));
//		addSequential(new ArmOutCommand());
//		addSequential(new CollectorReleaseAutonomousCommand());
//		addSequential(new ArmInCommand());
	}

}
