package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.Robot;
import org.usfirst.frc.team1154.robot.commands.ArmOutCommand;
import org.usfirst.frc.team1154.robot.commands.ArmSetHeight;
import org.usfirst.frc.team1154.robot.commands.DriveBackwardOverDefenceCommand;
import org.usfirst.frc.team1154.robot.commands.DriveUntilBackLightCommand;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;
import org.usfirst.frc.team1154.robot.subsystems.Arm;
import org.usfirst.frc.team1154.robot.subsystems.Arm.ArmHeight;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DrawbridgeBackwardsCommand extends CommandGroup {
	public DrawbridgeBackwardsCommand() {
		addSequential(new ArmSetHeight(ArmHeight.DRAW));
		addSequential(new DriveUntilBackLightCommand(Constants.defaultDrawbridgeSpeed));
		addSequential(new DriveWithPID(-10, Constants.defaultDrawbridgeSpeed));
		addSequential(new ArmOutCommand());
		
	}

}
