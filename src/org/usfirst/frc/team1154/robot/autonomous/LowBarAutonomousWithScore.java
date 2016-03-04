package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.commands.ArmOutCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseTeleopCommand;
import org.usfirst.frc.team1154.robot.commands.DriveForwardOverDefenceCommand;
import org.usfirst.frc.team1154.robot.commands.DriveUntilFrontLightCommand;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;
import org.usfirst.frc.team1154.robot.commands.TurnWithPID;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LowBarAutonomousWithScore extends CommandGroup{
	public LowBarAutonomousWithScore() {
		addSequential(new DriveUntilFrontLightCommand());
		addSequential(new DriveForwardOverDefenceCommand(Constants.defaultDefenceSpeed)); // this brings the robot through the doggy door past the green line rdy to turn
		addSequential(new TurnWithPID(45)); // turns the robot 90 mother lovin degrees
		addSequential(new DriveWithPID(80, Constants.approachingGoalSpeed)); // moves the robit right to the low goal
		addSequential(new SpitOutBallCommand()); //spit and score.
		
//		// puts the arm down yo
//		addSequential(new CollectorReleaseCommand()); // releases the boulder
	}

}
