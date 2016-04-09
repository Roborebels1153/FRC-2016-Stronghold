package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.commands.TurnWithPID;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TurnWithPIDTest extends CommandGroup {
	public TurnWithPIDTest() {
		addSequential(new TurnWithPID(90));
		
	}
}