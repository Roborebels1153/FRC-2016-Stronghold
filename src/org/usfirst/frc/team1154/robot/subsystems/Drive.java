package org.usfirst.frc.team1154.robot.subsystems;

import org.team2168.utils.BNO055;
import org.usfirst.frc.team1154.lib.DummyPIDOutput;
import org.usfirst.frc.team1154.lib.RebelDrive;
import org.usfirst.frc.team1154.lib.RebelGyro;
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
	private RebelGyro gyro;
	private DummyPIDOutput leftEncoderOutput;
	private DummyPIDOutput rightEncoderOutput;
	private DummyPIDOutput gyroOutput;
	private Victor leftFront;
	private Victor leftBack;
	private Victor rightFront;
	private Victor rightBack;
	public enum Shifter{ High, Low }
	private Shifter currSpeed;
	private DoubleSolenoid transmission;
	private PIDController leftEncoderPID;
	private PIDController rightEncoderPID;
	private PIDController gyroPID;
	
	public Drive() {
		
		leftFront = new Victor(RobotMap.LEFT_FRONT_MOTOR);
		
		leftBack = new Victor(RobotMap.LEFT_BACK_MOTOR);
		
		rightFront = new Victor(RobotMap.RIGHT_FRONT_MOTOR);
		
		rightBack = new Victor(RobotMap.RIGHT_BACK_MOTOR);
 
		leftEncoder = new Encoder (RobotMap.LEFT_ENCODER_A_CHANNEL, RobotMap.LEFT_ENCODER_B_CHANNEL, false, EncodingType.k4X);
		
		rightEncoder = new Encoder (RobotMap.RIGHT_ENCODER_A_CHANNEL, RobotMap.RIGHT_ENCODER_B_CHANNEL, false, EncodingType.k4X);
		
		gyro = new RebelGyro();
		
		transmission = new DoubleSolenoid (RobotMap.TRANSMISSION_SOLENOID_A, RobotMap.TRANSMISSION_SOLENOID_B);
		
		currSpeed = Shifter.Low;
		
		leftEncoderPID = new PIDController(.05, 0, 0, leftEncoder, leftEncoderOutput);
		
		rightEncoderPID = new PIDController(.05, 0, 0, rightEncoder, rightEncoderOutput);
		
		gyroPID = new PIDController(.05, 0, 0, gyro, gyroOutput);
		
		init();
		
		//now that everything is all set up, we can make RebelDrive
		rebelDrive = new RebelDrive(leftFront, leftBack, rightFront, rightBack);
	}
	
	private void init() {
		leftEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
		rightEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
		
		rightEncoder.setReverseDirection(true);
		
		resetEncoders();
		
		leftEncoderPID.setOutputRange(-0.8, 0.8);
		rightEncoderPID.setOutputRange(-0.8,  0.8);
		gyroPID.setOutputRange(-0.8, 0.8);
		
		enablePID();
		
	}
	
	public void enablePID() {
		
		leftEncoderPID.enable();
		rightEncoderPID.enable();
		gyroPID.enable();
		
	}
	
	public void disablePID() {
		
		leftEncoderPID.disable();
		rightEncoderPID.disable();
		gyroPID.disable();
		
	}
	
	public void setEncoderSetPoint(double setPoint) {
		leftEncoderPID.setSetpoint(setPoint);
		rightEncoderPID.setSetpoint(setPoint);
	}
	
	public void setGyroSetPoint(double setPoint) {
		gyroPID.setSetpoint(setPoint);
	}
	
	public double getLeftPIDOutput() {
		return leftEncoderPID.get();
	}
	
	public double getRightPIDOutput() {
		return rightEncoderPID.get();
	}

	public double getGyroPIDOutput() {
		return gyroPID.get();
	}
		
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand (new DriveWithJoysticks());
		
		
	}
	
	public void arcadeDrive(Joystick stick) {
		rebelDrive.arcadeDrive(stick, currSpeed);
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
	
	public double getLeftEncoderOutput() {
		return leftEncoderOutput.getOutput();
	}
	
	public double getRightEncoderOutput() {
		return rightEncoderOutput.getOutput();
	}
	
	public double getGyroOutput() {
		return gyroOutput.getOutput();
	}
	
	public Shifter getCurrSpeed() {
		return currSpeed;
	}
	
	public boolean isGyroInitialized() {
		return gyro.isInitialized();
	}
	
	public boolean isGyroCalibrated() {
		return gyro.isCalibrated();
	}
	
	public boolean isSensorPresant() {
		return gyro.isSensorPresant();
	}
	
	public BNO055.CalData getCalibration() {
		return gyro.getCalibration();
	}
	
	public double getAngle() {
		return gyro.getHeading();
	}

}
