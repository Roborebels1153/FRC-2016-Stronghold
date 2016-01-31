package org.usfirst.frc.team1154.lib;

import org.usfirst.frc.team1154.robot.subsystems.NegInertiaCalc;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.RobotDrive;

public class RebelDrive extends RobotDrive {

	NegInertiaCalc lowSpeedNic;
	NegInertiaCalc highSpeedNic;
	
	public RebelDrive(int frontLeftMotor, int rearLeftMotor, int frontRightMotor, int rearRightMotor) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		lowSpeedNic = new NegInertiaCalc(0);
		highSpeedNic = new NegInertiaCalc(2);
			
	}
	
	@Override
	public void arcadeDrive(GenericHID stick, boolean squaredInputs){
		arcadeDrive(-stick.getY(), stick.getRawAxis(4), squaredInputs);
	}
	
	public void nicDrive(GenericHID stick, boolean squaredInputs) {
		arcadeDrive(-stick.getY(), highSpeedNic.calculate(stick.getRawAxis(4)),squaredInputs);
	}
}
