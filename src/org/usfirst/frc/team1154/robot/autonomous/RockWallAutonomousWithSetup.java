package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.Robot;
import org.usfirst.frc.team1154.robot.commands.ArmOutCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseCommand;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;
import org.usfirst.frc.team1154.robot.commands.TurnWithPID;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RockWallAutonomousWithSetup extends CommandGroup {
	public RockWallAutonomousWithSetup () {
		addSequential(new DriveWithPID(180));
		addSequential(new ArmOutCommand());
		addSequential(new CollectorReleaseCommand());
		addSequential(new TurnWithPID(270));
		addSequential(new DriveWithPID(24));
		addSequential(new TurnWithPID(180));
		
	}

}
