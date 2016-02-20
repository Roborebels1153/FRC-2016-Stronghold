package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.commands.DriveWithPID;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DrivinWithDono extends CommandGroup {
	public DrivinWithDono() {
		addSequential(new DriveWithPID(120));
//		addSequential(new DriveWithPID(-36));
		
	}

}
