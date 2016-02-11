package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.commands.ArmOutCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseCommand;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;
import org.usfirst.frc.team1154.robot.commands.TurnWithPID;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LowBarAutonomousWithScore extends CommandGroup{
	public LowBarAutonomousWithScore() {
		addSequential(new DriveWithPID(218)); // this brings the robot through the doggy door past the green line rdy to turn
		addSequential(new TurnWithPID(90)); // turns the robot 90 mother lovin degrees
		addSequential(new DriveWithPID(80)); // moves the robit right to the low goal
		addSequential(new ArmOutCommand()); // puts the arm down yo
		addSequential(new CollectorReleaseCommand()); // releases the boulder
	}

}
