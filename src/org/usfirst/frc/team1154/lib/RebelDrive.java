package org.usfirst.frc.team1154.lib;

import org.usfirst.frc.team1154.robot.subsystems.Drive.Shifter;
import org.usfirst.frc.team1154.robot.subsystems.NegInertiaCalc;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;

public class RebelDrive extends RobotDrive {

	NegInertiaCalc lowSpeedNic;
	NegInertiaCalc highSpeedNic;
	
	public RebelDrive(SpeedController frontLeftMotor, SpeedController rearLeftMotor,
		      SpeedController frontRightMotor, SpeedController rearRightMotor) {
		 super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
			lowSpeedNic = new NegInertiaCalc(0);
			highSpeedNic = new NegInertiaCalc(2);
	 }
	
	public void arcadeDrive(GenericHID stick, Shifter gear) {
		if (Shifter.Low.equals(gear)) {
			arcadeDrive(stick.getY(), lowSpeedNic.calculate(stick.getRawAxis(4)), true);
		} else {
			arcadeDrive(-stick.getY(), highSpeedNic.calculate(stick.getRawAxis(4)), true);
		}
	}
}
