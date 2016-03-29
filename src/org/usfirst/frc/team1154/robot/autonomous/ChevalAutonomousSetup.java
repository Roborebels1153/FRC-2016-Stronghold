package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.commands.ArmInCommand;
import org.usfirst.frc.team1154.robot.commands.ArmOutCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseAutonomousCommand;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;
import org.usfirst.frc.team1154.robot.commands.TurnWithPID;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ChevalAutonomousSetup extends CommandGroup {
	public ChevalAutonomousSetup() {
		addSequential(new DriveWithPID(102, Constants.defaultChevalSpeed));
		addSequential(new ArmOutCommand());
		addSequential(new DriveWithPID(15, Constants.defaultChevalSpeed));
		addSequential(new ArmInCommand());
		addSequential(new DriveWithPID(40, Constants.defaultChevalSpeed));
		addSequential(new DriveWithPID(23, Constants.defaultDefenceSpeed));
		addSequential(new ArmOutCommand());
		addSequential(new CollectorReleaseAutonomousCommand());
		addSequential(new ArmInCommand());
		addSequential(new TurnWithPID(180));
		
	}

}
