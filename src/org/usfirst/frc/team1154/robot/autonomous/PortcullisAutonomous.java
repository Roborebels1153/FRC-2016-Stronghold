package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.commands.ArmInCommand;
import org.usfirst.frc.team1154.robot.commands.ArmSetHeight;
import org.usfirst.frc.team1154.robot.commands.DriveForwardOverDefenceCommand;
import org.usfirst.frc.team1154.robot.commands.DriveUntilFrontLightCommand;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;
import org.usfirst.frc.team1154.robot.subsystems.Arm.ArmHeight;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PortcullisAutonomous extends CommandGroup{
	public PortcullisAutonomous() {	
		addSequential(new ArmSetHeight(ArmHeight.PORT));
		addSequential(new DriveWithPID(45, Constants.portcullisOne));
		addSequential(new DriveWithPID(5, Constants.portcullisTwo));
		addSequential(new DriveWithPID(10,Constants.portcullisTwo));
		addParallel(new ArmInCommand());
		
		
	}

}
