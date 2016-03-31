package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.commands.ArmInCommand;
import org.usfirst.frc.team1154.robot.commands.ArmSetHeight;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseAutonomousCommand;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;
import org.usfirst.frc.team1154.robot.commands.TurnWithPID;
import org.usfirst.frc.team1154.robot.subsystems.Arm.ArmHeight;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TrialThingAutonomous extends CommandGroup {
	public TrialThingAutonomous() {
		addSequential(new DriveWithPID(190));
		addSequential(new TurnWithPID(180));
		addSequential(new ArmSetHeight(ArmHeight.SPIT));
		addSequential(new CollectorReleaseAutonomousCommand());
		//addSequential(new ArmInCommand());
		
	}
	

}
