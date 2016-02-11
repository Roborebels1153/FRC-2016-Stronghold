package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.commands.ArmOutCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseCommand;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;
import org.usfirst.frc.team1154.robot.commands.TurnWithPID;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoatAutonomous extends CommandGroup{
	public MoatAutonomous() {
		addSequential(new DriveWithPID(230 , Constants.moatSpeed));
		addSequential(new ArmOutCommand());
		addSequential(new CollectorReleaseCommand());
	}
}