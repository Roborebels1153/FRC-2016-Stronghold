package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.commands.ArmInCommand;
import org.usfirst.frc.team1154.robot.commands.ArmOutCommand;
import org.usfirst.frc.team1154.robot.commands.ArmSetHeight;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseAutonomousCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseAutonomousTimerCommand;
import org.usfirst.frc.team1154.robot.commands.DriveAtSpeedCommand;
import org.usfirst.frc.team1154.robot.commands.DriveUntilFrontLightCommand;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;
import org.usfirst.frc.team1154.robot.commands.TurnWithPID;
import org.usfirst.frc.team1154.robot.commands.WaitInbetweenCommandsCommand;
import org.usfirst.frc.team1154.robot.subsystems.Arm.ArmHeight;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ChevalAutonomous extends CommandGroup {
	public ChevalAutonomous() {
		addSequential(new DriveWithPID(91, Constants.defaultChevalAutoSpeedOne));
		addSequential(new WaitInbetweenCommandsCommand(0.5));
//		addSequential(new DriveWithPID(, Constants.defaultChevalAutoSpeedOne));
		addSequential(new WaitInbetweenCommandsCommand(0.5));
		addSequential(new ArmOutCommand());
		addSequential(new DriveWithPID(20, Constants.defaultChevalAutoSpeedTwo));
		addSequential(new ArmInCommand());
		addSequential(new DriveWithPID(40, Constants.defaultChevalAutoSpeedTwo));
		addSequential(new DriveWithPID(50, Constants.defaultChevalAutoSpeedOne));
		addSequential(new TurnWithPID(180));
		addSequential(new ArmSetHeight(ArmHeight.SPIT));
		addSequential(new CollectorReleaseAutonomousCommand());
		addSequential(new ArmInCommand());
		
//		addSequential(new DriveUntilFrontLightCommand());
//		addSequential(new DriveAtSpeedCommand(-1));
		}

}
