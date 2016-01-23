package org.usfirst.frc.team1154.robot.subsystems;

import org.usfirst.frc.team1154.lib.RebelDrive;
import org.usfirst.frc.team1154.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {
	
	private RebelDrive rebelDrive;
	private Encoder leftEncoder;
	private Encoder rightEncoder;
	private enum Shifter{ High, Low }
	private Shifter currSpeed;
	private Compressor compressor;
	private DoubleSolenoid lTransmission;
	private DoubleSolenoid rTransmission;
	
	
	
	@Override
	protected void initDefaultCommand() {
		
	}
	
	public void arcadeDrive(Joystick stick) {
		rebelDrive.arcadeDrive(stick);
	}
	
	
	public void Drive() {
		
		rebelDrive = new RebelDrive(RobotMap.LEFT_FRONT_MOTOR, RobotMap.LEFT_BACK_MOTOR, 
									RobotMap.RIGHT_FRONT_MOTOR, RobotMap.RIGHT_BACK_MOTOR);
		
		leftEncoder = new Encoder (RobotMap.LEFT_ENCODER_A_CHANNEL, RobotMap.LEFT_ENCODER_B_CHANNEL);
		
		rightEncoder = new Encoder (RobotMap.RIGHT_ENCODER_A_CHANNEL, RobotMap.RIGHT_ENCODER_B_CHANNEL);
		
		currSpeed = Shifter.Low;
	}
		
	public double getLeftEncoderDistance() {
		
		return leftEncoder.getDistance();
			
	}
	
	public double getRightEncoderDistance() {
		
		return rightEncoder.getDistance();
			
	}
	

	public void resetEncoders() {
		
		leftEncoder.reset();
		rightEncoder.reset();
	
	}
	
	public Shifter shift(){
		
		if(currSpeed.equals(Shifter.Low)) {
			
			lTransmission.set(DoubleSolenoid.Value.kForward);
			rTransmission.set(DoubleSolenoid.Value.kForward);
			currSpeed = Shifter.High;
			
		} else {
			
			lTransmission.set(DoubleSolenoid.Value.kReverse);
			rTransmission.set(DoubleSolenoid.Value.kReverse);
			currSpeed = Shifter.Low;
		}
		
		return currSpeed;
		
	}
	

}
