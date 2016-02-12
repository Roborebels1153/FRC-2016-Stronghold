package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.commands.ArmOutCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseCommand;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;
import org.usfirst.frc.team1154.robot.commands.TurnWithPID;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LowBarAutonomous extends CommandGroup{
	public LowBarAutonomous() {
		addSequential(new DriveWithPID(180, Constants.defaultMaxSpeed)); // this brings the robot through the doggy door past the green line rdy to turn
		addSequential(new ArmOutCommand()); // puts the arm down yo
		addSequential(new CollectorReleaseCommand()); // releases the boulder
	}

}
