package org.usfirst.frc.team1154.robot.autonomous;


import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.commands.ArmInCommand;
import org.usfirst.frc.team1154.robot.commands.ArmOutCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseAutonomousCommand;
import org.usfirst.frc.team1154.robot.commands.DriveForwardOverDefenceCommand;
import org.usfirst.frc.team1154.robot.commands.DriveUntilFrontLightCommand;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LowBarAutonomous extends CommandGroup{
	public LowBarAutonomous() {
		addSequential(new DriveWithPID(191 + 36, Constants.defaultDefenceSpeed));
//		addSequential(new DriveUntilFrontLightCommand());
//		addSequential(new DriveForwardOverDefenceCommand(Constants.defaultDefenceSpeed));
		addSequential(new ArmOutCommand());
		addSequential(new CollectorReleaseAutonomousCommand());
		addSequential(new ArmInCommand());
//		addSequential(new DriveWithPID(10, Constants.defaultMaxSpeed));
		
	}

}
