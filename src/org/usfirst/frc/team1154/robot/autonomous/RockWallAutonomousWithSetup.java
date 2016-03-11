package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.Robot;
import org.usfirst.frc.team1154.robot.commands.ArmInCommand;
import org.usfirst.frc.team1154.robot.commands.ArmOutCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseAutonomousCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseTeleopCommand;
import org.usfirst.frc.team1154.robot.commands.DriveBackwardOverDefenceCommand;
import org.usfirst.frc.team1154.robot.commands.DriveForwardOverDefenceCommand;
import org.usfirst.frc.team1154.robot.commands.DriveUntilBackLightCommand;
import org.usfirst.frc.team1154.robot.commands.DriveUntilFrontLightCommand;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;
import org.usfirst.frc.team1154.robot.commands.TurnWithPID;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RockWallAutonomousWithSetup extends CommandGroup {
	public RockWallAutonomousWithSetup () {
		addSequential(new DriveUntilFrontLightCommand());
		addSequential(new DriveForwardOverDefenceCommand(0.9));
		addSequential(new DriveWithPID(60, Constants.defaultDefenceSpeed));
		addSequential(new ArmOutCommand());
		addSequential(new CollectorReleaseAutonomousCommand());
		addSequential(new ArmInCommand());
		addSequential(new DriveUntilBackLightCommand(0.9));
		addSequential(new DriveBackwardOverDefenceCommand(0.9));
		addSequential(new DriveWithPID(-48, Constants.defaultDefenceSpeed));
		addSequential(new TurnWithPID(180));
		
	}

}
