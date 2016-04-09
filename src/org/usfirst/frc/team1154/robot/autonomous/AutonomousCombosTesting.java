package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.commands.ArmInCommand;
import org.usfirst.frc.team1154.robot.commands.ArmOutCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseAutonomousCommand;
import org.usfirst.frc.team1154.robot.commands.DriveBackwardOverDefenceCommand;
import org.usfirst.frc.team1154.robot.commands.DriveForwardOverDefenceCommand;
import org.usfirst.frc.team1154.robot.commands.DriveUntilBackLightCommand;
import org.usfirst.frc.team1154.robot.commands.DriveUntilFrontLightCommand;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;
import org.usfirst.frc.team1154.robot.commands.TurnWithPID;
import org.usfirst.frc.team1154.robot.commands.WaitInbetweenCommandsCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCombosTesting extends CommandGroup {
	public AutonomousCombosTesting() {
		
		addSequential(new DriveWithPID(60));
		addSequential(new WaitInbetweenCommandsCommand(2));
		addSequential(new TurnWithPID(180));

		
//		addSequential(new DriveUntilFrontLightCommand());
//		addSequential(new DriveForwardOverDefenceCommand(Constants.defaultTestSpeed));
		
		//addSequential(new DriveWithPID(-120, 1));
//		addSequential(new DriveUntilBackLightCommand(0.5));
//		addSequential(new DriveBackwardOverDefenceCommand(Constants.roughTerrain));
		//addSequential(new TurnWithPID(180));
		
//		addSequential(new DriveWithPID(120));
//		addSequential(new CollectorReleaseAutonomousCommand());
//		addParallel(new CollectorReleaseAutonomousCommand());
//		addSequential(new DriveWithPID(120));
//		addSequential(new TurnWithPID(45));
//		addSequential(new DriveWithPID(60, Constants.approachingGoalSpeed));
//		addSequential(new ArmOutCommand());
//		addSequential(new CollectorReleaseAutonomousCommand());
//		addSequential(new ArmInCommand());
		
//		addSequential(new DriveWithPID(24));
//		addSequential(new DriveWithPID(-12));
		
//		addSequential(new DriveUntilFrontLightCommand());
//		addSequential(new DriveForwardOverDefenceCommand(Constants.defaultDefenceSpeed));
//		addSequential(new DriveUntilBackLightCommand());
//		addSequential(new DriveBackwardOverDefenceCommand(Constants.defaultDefenceSpeed));

	}

}
