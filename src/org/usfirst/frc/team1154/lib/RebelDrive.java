package org.usfirst.frc.team1154.lib;

import org.usfirst.frc.team1154.robot.Robot;
import org.usfirst.frc.team1154.robot.subsystems.Drive.Shifter;
import org.usfirst.frc.team1154.robot.subsystems.Drive.Speed;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;

public class RebelDrive extends RobotDrive {

	NegInertiaCalc lowSpeedNic;
	NegInertiaCalc highSpeedNic;
	private static double STRAIGHT_THROTTLE = 1;
	private static double TURN_THROTTLE = 1;
	private static double SLOW = 0.8; 
	
	public RebelDrive(SpeedController frontLeftMotor, SpeedController rearLeftMotor,
		      SpeedController frontRightMotor, SpeedController rearRightMotor) {
		 super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
			lowSpeedNic = new NegInertiaCalc(2);
			highSpeedNic = new NegInertiaCalc(4);
	 }
	
	
	
	public void arcadeDrive(GenericHID stick, Shifter gear) {
		
		
		
		if (Shifter.Low.equals(gear)) {
			
			if(Speed.Slow.equals(Robot.drive.getCurrSpeed())) {
				arcadeDrive(stick.getY() * SLOW,
						lowSpeedNic.calculate(stick.getRawAxis(4)),
						true);
			} else {
				arcadeDrive(stick.getY() * STRAIGHT_THROTTLE,
						lowSpeedNic.calculate(stick.getRawAxis(4) * TURN_THROTTLE),
						true);
			}
		} else {
			arcadeDrive(stick.getY(), highSpeedNic.calculate(stick.getRawAxis(4)), true);
		}
	}
	
}
