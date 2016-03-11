package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.commands.DriveWithPID;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DrivingWithPIDTest extends CommandGroup {
	public DrivingWithPIDTest() {
		addSequential(new DriveWithPID(120));

		
	}

}
