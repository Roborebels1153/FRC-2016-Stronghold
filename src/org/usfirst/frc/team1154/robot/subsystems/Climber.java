package org.usfirst.frc.team1154.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Climber extends Subsystem {
	
	private Solenoid fil;
	
	DriverStation ds = DriverStation.getInstance();

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean isEndGame() {
		return ds.getMatchTime() < 20;
	}
	
}
