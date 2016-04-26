package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.commands.ArmInCommand;
import org.usfirst.frc.team1154.robot.commands.ArmOutCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseAutonomousCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseTeleopCommand;
import org.usfirst.frc.team1154.robot.commands.DriveForwardOverDefenceCommand;
import org.usfirst.frc.team1154.robot.commands.DriveUntilFrontLightCommand;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;
import org.usfirst.frc.team1154.robot.commands.TurnWithPID;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RoughTerrainAutonomous extends CommandGroup {
	public RoughTerrainAutonomous() {
		addSequential(new DriveWithPID(190, Constants.defaultDefenceSpeed));
//		addSequential(new TurnWithPID(180));
//		addSequential(new DriveUntilFrontLightCommand());
//		addSequential(new DriveForwardOverDefenceCommand(Constants.roughTerrain));
//		addSequential(new ArmOutCommand());
//		addSequential(new CollectorReleaseAutonomousCommand());
//		addSequential(new ArmInCommand());
//		addSequential(new DriveWithPID(36, Constants.defaultMaxSpeed));
	}

}
