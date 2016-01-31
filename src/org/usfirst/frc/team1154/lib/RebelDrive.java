package org.usfirst.frc.team1154.lib;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;

public class RebelDrive extends RobotDrive {

	public RebelDrive(int frontLeftMotor, int rearLeftMotor, int frontRightMotor, int rearRightMotor) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
			
	}
	
	 public RebelDrive(SpeedController frontLeftMotor, SpeedController rearLeftMotor,
		      SpeedController frontRightMotor, SpeedController rearRightMotor) {
		 super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
	 }
	
	@Override
	public void arcadeDrive(GenericHID stick, boolean squaredInputs){
		arcadeDrive(stick.getY(), stick.getRawAxis(4), squaredInputs);
	}
}
