package org.usfirst.frc.team1154.robot.subsystems;

import org.usfirst.frc.team1154.lib.RebelDrive;
import org.usfirst.frc.team1154.robot.RobotMap;
import org.usfirst.frc.team1154.robot.commands.DriveWithJoysticks;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem {
	
	private RebelDrive rebelDrive;
	private Encoder leftEncoder;
	private Encoder rightEncoder;
	private Victor leftFront;
	private Victor leftBack;
	private Victor rightFront;
	private Victor rightBack;
	private enum Shifter{ High, Low }
	private Shifter currSpeed;
	private DoubleSolenoid transmission;
	private PIDController leftFrontPID;
	private PIDController rightFrontPID;
	private PIDController leftBackPID;
	private PIDController rightBackPID;
	
	public Drive() {
		
		rebelDrive = new RebelDrive(leftFront, leftBack, rightFront, rightBack);
 
		leftEncoder = new Encoder (RobotMap.LEFT_ENCODER_A_CHANNEL, RobotMap.LEFT_ENCODER_B_CHANNEL, false, EncodingType.k4X);
		
		rightEncoder = new Encoder (RobotMap.RIGHT_ENCODER_A_CHANNEL, RobotMap.RIGHT_ENCODER_B_CHANNEL);
		
		transmission = new DoubleSolenoid (RobotMap.TRANSMISSION_SOLENOID_A, RobotMap.TRANSMISSION_SOLENOID_B);
		
		currSpeed = Shifter.Low;
		
		leftFront = new Victor(RobotMap.LEFT_FRONT_MOTOR);
		
		leftBack = new Victor(RobotMap.LEFT_BACK_MOTOR);
		
		rightFront = new Victor(RobotMap.RIGHT_FRONT_MOTOR);
		
		rightBack = new Victor(RobotMap.RIGHT_BACK_MOTOR);
		
		leftFrontPID = new PIDController(.05, 0, 0, leftEncoder, leftFront);
		
		leftBackPID = new PIDController(.05, 0, 0, leftEncoder, leftBack);
		
		rightFrontPID = new PIDController(.05, 0, 0, rightEncoder, rightFront);
		
		rightBackPID = new PIDController(.05, 0, 0, rightEncoder, rightBack);
		
		init();
	}
	
	private void init() {
		leftEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
		rightEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
		
		rightEncoder.setReverseDirection(true);
		
		resetEncoders();
		
		leftFrontPID.setOutputRange(-0.8, 0.8);
		leftBackPID.setOutputRange(-0.8, 0.8);
		rightFrontPID.setOutputRange(-0.8, 0.8);
		rightBackPID.setOutputRange(-0.8, 0.8);
		
		enablePID();
		
	}
	
	public void enablePID() {
		
		leftFrontPID.enable();
		leftBackPID.enable();
		rightFrontPID.enable();
		rightBackPID.enable();
		
	}
	
	public void disablePID() {
		
		leftFrontPID.disable();
		leftBackPID.disable();
		rightFrontPID.disable();
		rightBackPID.disable();
		
	}
	
	public void setSetPoint(double setPoint) {
		leftFrontPID.setSetpoint(setPoint);
		leftBackPID.setSetpoint(setPoint);
		rightFrontPID.setSetpoint(setPoint);
		rightBackPID.setSetpoint(setPoint);
	}
	
	public double getPIDOutput() {
		return leftFrontPID.get();
	}
		
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand (new DriveWithJoysticks());
		
		
	}
	
	public void arcadeDrive(Joystick stick) {
		rebelDrive.arcadeDrive(stick);
	}
	
	public void arcadeDrive(double driveSpeed, double turnSpeed) {
		rebelDrive.arcadeDrive(driveSpeed, turnSpeed);
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
			
				transmission.set(DoubleSolenoid.Value.kForward);
				currSpeed = Shifter.High;			
			}
		return currSpeed;	
	}
	
	public Shifter shiftLow(){
		if(currSpeed.equals(Shifter.High)) {
				
				transmission.set(DoubleSolenoid.Value.kReverse);
				currSpeed = Shifter.Low;
			}
		return currSpeed;
	}
	
	public double getMotorOutput() {
		return leftFront.get();
	}

}
