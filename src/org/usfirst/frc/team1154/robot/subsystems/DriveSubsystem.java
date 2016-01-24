package org.usfirst.frc.team1154.robot.subsystems;

import org.usfirst.frc.team1154.lib.RebelDrive;
import org.usfirst.frc.team1154.robot.RobotMap;
import org.usfirst.frc.team1154.robot.commands.DriveWithJoysticks;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveSubsystem extends Subsystem {
	
	private RebelDrive rebelDrive;
	private Encoder leftEncoder;
	private Encoder rightEncoder;
	private enum Shifter{ High, Low }
	private Shifter currSpeed;
	private DoubleSolenoid lTransmission;
	private DoubleSolenoid rTransmission;
	
	public DriveSubsystem() {
		
		rebelDrive = new RebelDrive(RobotMap.LEFT_FRONT_MOTOR, RobotMap.LEFT_BACK_MOTOR, 
									RobotMap.RIGHT_FRONT_MOTOR, RobotMap.RIGHT_BACK_MOTOR);
		
		leftEncoder = new Encoder (RobotMap.LEFT_ENCODER_A_CHANNEL, RobotMap.LEFT_ENCODER_B_CHANNEL);
		
		rightEncoder = new Encoder (RobotMap.RIGHT_ENCODER_A_CHANNEL, RobotMap.RIGHT_ENCODER_B_CHANNEL);
		
		currSpeed = Shifter.Low;
	}
		
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand (new DriveWithJoysticks());
	}
	
	public void arcadeDrive(Joystick stick) {
		rebelDrive.arcadeDrive(stick);
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
	
	public Shifter shiftHigh(){	
		if(currSpeed.equals(Shifter.Low)) {
			
				lTransmission.set(DoubleSolenoid.Value.kForward);
				rTransmission.set(DoubleSolenoid.Value.kForward);
				currSpeed = Shifter.High;			
			}
		return currSpeed;	
	}
	
	public Shifter shiftLow(){
		if(currSpeed.equals(Shifter.High)) {
				
				lTransmission.set(DoubleSolenoid.Value.kReverse);
				rTransmission.set(DoubleSolenoid.Value.kReverse);
				currSpeed = Shifter.Low;
			}
		return currSpeed;
	}

}
