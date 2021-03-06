package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.commands.ArmInCommand;
import org.usfirst.frc.team1154.robot.commands.ArmOutCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseAutonomousCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseTeleopCommand;
import org.usfirst.frc.team1154.robot.commands.DriveBackwardOverDefenceCommand;
import org.usfirst.frc.team1154.robot.commands.DriveForwardOverDefenceCommand;
import org.usfirst.frc.team1154.robot.commands.DriveUntilBackLightCommand;
import org.usfirst.frc.team1154.robot.commands.DriveUntilFrontLightCommand;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;
import org.usfirst.frc.team1154.robot.commands.TurnWithPID;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoatAutonomousWithSetup extends CommandGroup {
	public MoatAutonomousWithSetup() {
		addSequential(new DriveWithPID(191 + 36, Constants.defaultMaxSpeed));
//		addSequential(new DriveUntilFrontLightCommand());
//		addSequential(new DriveForwardOverDefenceCommand(Constants.defaultMaxSpeed));
		addSequential(new ArmOutCommand());
		addSequential(new CollectorReleaseAutonomousCommand());
		addSequential(new ArmInCommand());
		addSequential(new DriveWithPID(-227, Constants.defaultMaxSpeed));
//		addSequential(new TurnWithPID(180));
//		addSequential(new DriveUntilFrontLightCommand());
//		addSequential(new DriveForwardOverDefenceCommand(Constants.defaultMaxSpeed));
//		addSequential(new DriveWithPID(120, 1)); //Constants.defaultDefenceSpeed));
//		addSequential(new TurnWithPID(180));
	}

}
