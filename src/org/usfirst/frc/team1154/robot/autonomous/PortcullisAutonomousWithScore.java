package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.commands.ArmOutCommand;
import org.usfirst.frc.team1154.robot.commands.ArmSetHeight;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseCommand;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;
import org.usfirst.frc.team1154.robot.commands.TurnWithPID;
import org.usfirst.frc.team1154.robot.subsystems.Arm.ArmHeight;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PortcullisAutonomousWithScore extends CommandGroup {
	public PortcullisAutonomousWithScore() {
		addSequential(new ArmSetHeight(ArmHeight.LOW));
		addSequential(new DriveWithPID(106, Constants.portcullis));
		addSequential(new ArmSetHeight(ArmHeight.PORT));
		addSequential(new DriveWithPID(70, Constants.portcullis));
		addSequential(new ArmSetHeight(ArmHeight.LOW));
		addSequential(new TurnWithPID(90));
		addSequential(new DriveWithPID(80, Constants.portcullis));
		addSequential(new ArmOutCommand());
		addSequential(new CollectorReleaseCommand());
		

		
		
	}

}
