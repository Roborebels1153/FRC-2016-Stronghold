package org.usfirst.frc.team1154.robot.autonomous;


import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.commands.DriveOverDefenceCommand;
import org.usfirst.frc.team1154.robot.commands.DriveUntilFrontLightCommand;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LowBarAutonomous extends CommandGroup{
	public LowBarAutonomous() {
		addSequential(new DriveUntilFrontLightCommand());
		addSequential(new DriveOverDefenceCommand(Constants.defaultDefenceSpeed));
		addSequential(new DriveWithPID(36, Constants.defaultMaxSpeed));
		
	}

}
