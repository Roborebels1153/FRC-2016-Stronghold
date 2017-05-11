package org.usfirst.frc.team1154.robot.subsystems;

import org.team2168.utils.BNO055;
import org.usfirst.frc.team1154.lib.DummyPIDOutput;
import org.usfirst.frc.team1154.lib.RebelDrive;
import org.usfirst.frc.team1154.lib.RebelGyro;
import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.Robot;
import org.usfirst.frc.team1154.robot.RobotMap;
import org.usfirst.frc.team1154.robot.commands.DriveWithJoysticks;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

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
	private Victor armMotor;
	private Victor collecterMotor;
	public enum Shifter{ High, Low }
	public enum Speed{Normal, Slow}
	private Shifter currGear;
	private Speed currSpeed;
	private DoubleSolenoid transmission;
	private PIDController leftEncoderPID;
	private PIDController rightEncoderPID;
	private PIDController gyroPID;
	private LiveWindow lw;
	private DigitalInput lightSensorFront;
	private DigitalInput lightSensorBack;
	private DigitalInput lightSensorForwardOne;
	private DigitalInput lightSensorForwardTwo;
	private double driveTolerance = 1;
	private double turnTolerance = 0;
	private boolean crossingDefence = false;
//	private Ultrasonic sonar;
	
	public Drive() {
		
		leftFront = new Victor(RobotMap.LEFT_FRONT_MOTOR);
		
		leftBack = new Victor(RobotMap.LEFT_BACK_MOTOR);
		
		rightFront = new Victor(RobotMap.RIGHT_FRONT_MOTOR);
		
		rightBack = new Victor(RobotMap.RIGHT_BACK_MOTOR);
		
		armMotor = new Victor(RobotMap.ARM_MOTOR);
		
		collecterMotor = new Victor(RobotMap.COLLECTOR_ROLLERS);
 
		leftEncoder = new Encoder (RobotMap.LEFT_ENCODER_A_CHANNEL, RobotMap.LEFT_ENCODER_B_CHANNEL, false, EncodingType.k4X);
		
		rightEncoder = new Encoder (RobotMap.RIGHT_ENCODER_A_CHANNEL, RobotMap.RIGHT_ENCODER_B_CHANNEL, false, EncodingType.k4X);

//		sonar = new Ultrasonic(RobotMap.ULTRASONIC_ECHO_PULSE_OUTPUT, RobotMap.ULTRASONIC_TRIGGER_PULSE_INPUT);
		
		gyro = new RebelGyro();
		
		transmission = new DoubleSolenoid (RobotMap.TRANSMISSION_SOLENOID_A, RobotMap.TRANSMISSION_SOLENOID_B);
		
		currGear = Shifter.Low;
		
		currSpeed = Speed.Normal;
		
		leftEncoderOutput = new DummyPIDOutput();
		rightEncoderOutput = new DummyPIDOutput();
		gyroOutput = new DummyPIDOutput();		
		
		//double encoderP = 0.8; //original 
		double encoderP = 0.78;
		double encoderI = 0;
		double encoderD = 0.25; //low bar score
		//double encoderD = 0.15;
		//double encoderD = 0;
		
		leftEncoderPID = new PIDController(encoderP, encoderI, encoderD, leftEncoder, leftEncoderOutput);
		
		rightEncoderPID = new PIDController(encoderP, encoderI, encoderD, rightEncoder, rightEncoderOutput);
		
		gyroPID = new PIDController(.35, 0, .015, gyro, gyroOutput); //turn numbers
//		gyroPID = new PIDController(0.4, 0, 0.2, gyro, gyroOutput);
		
		lightSensorFront = new DigitalInput(RobotMap.FRONT_LIGHT_SENSOR);
		 
		lightSensorBack = new DigitalInput(RobotMap.BACK_LIGHT_SENSOR);
		
//		lightSensorForwardOne = new DigitalInput(RobotMap.FORWARD_LIGHT_SENSOR_ONE);
		
//		lightSensorForwardTwo = new DigitalInput(RobotMap.FORWARD_LIGHT_SENSOR_TWO);
		
		
		init();
		
		//now that everything is all set up, we can make RebelDrive
		rebelDrive = new RebelDrive(leftFront, leftBack, rightFront, rightBack);
	}
	
	private void init() {
		leftEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
		rightEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
		
		resetEncoders();
		
		double maxSpeed = 0.7;
		
		leftEncoderPID.setOutputRange(-0.7, maxSpeed);
		rightEncoderPID.setOutputRange(-0.7, maxSpeed);
		gyroPID.setOutputRange(-0.8, 0.8);
		gyroPID.setInputRange(0, 360);
		gyroPID.setContinuous();
		
		driveTolerance = 15;
		
		turnTolerance = 5;
		
		enablePID();
		
		LiveWindow.addSensor("Gyro", "GyroPID", gyroPID);
		
//		LiveWindow.addSensor("Drive", "LeftFrontPID", leftFrontPID);
//		LiveWindow.addSensor("Drive", "LeftBackPID", leftBackPID);
//		LiveWindow.addSensor("Drive", "RightFrontPID", rightFrontPID);
//		LiveWindow.addSensor("Drive", "RightBackPID", rightBackPID);
		
	}
	
	
	
	public void enablePID() {
		
		leftEncoderPID.enable();
		rightEncoderPID.enable();
		gyroPID.enable();
		
	}
	
	public void enableLeftPID() {
		leftEncoderPID.enable();
		gyroPID.enable();
	}
	
	public void enableRightPID() {
		rightEncoderPID.enable();
		gyroPID.enable();
	}
	
	public void enableGyroPID() {
		
		gyroPID.enable();
		
	}
	
	public void disablePID() {
		
		leftEncoderPID.disable();
		rightEncoderPID.disable();
		gyroPID.disable();
		
	}
	
	public void setDriveEncoderSetPoint(double setPoint) {
		leftEncoderPID.setSetpoint(setPoint);
		rightEncoderPID.setSetpoint(setPoint);
	}
	
	public void leftWheelsTurnSetPoint(double setPoint) {
		leftEncoderPID.setSetpoint(setPoint);
	}
	
	public void rightWheelsTurnSetPoint(double setPoint) {
		rightEncoderPID.setSetpoint(setPoint);
	}
	
	public void setInitialAngle(double initialAngle) {
		gyro.setInitialAngle(initialAngle);
	}
	
	public double getInitialAngle() {
		return gyro.getInitialAngle();
	}
	
	public void setGyroSetPoint(double setPoint) {
		gyroPID.setSetpoint((setPoint + gyro.getInitialAngle()) % 360);
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
	
	public double getSetpoint() {
		return gyroPID.getSetpoint();
	}
		
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand (new DriveWithJoysticks());
	}
	
	public void arcadeDrive(Joystick stick) {
		rebelDrive.arcadeDrive(stick, currGear);
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
	
	public Shifter shiftHigh() {	
		if(currGear.equals(Shifter.Low)) {
			
				transmission.set(DoubleSolenoid.Value.kForward);
				currGear = Shifter.High;			
			}
		return currGear;	
	}
	
	public Shifter shiftLow() {
		if(currGear.equals(Shifter.High)) {
				
				transmission.set(DoubleSolenoid.Value.kReverse);
				currGear = Shifter.Low;
			}
		return currGear;
	}
	
	public Speed speedLow() {
		if(currSpeed.equals(Speed.Normal)) {
			
			currSpeed = Speed.Slow;
			
		}
		return currSpeed;
	}
	
	public Speed speedNorm() {
		if(currSpeed.equals(Speed.Slow)) {
			
			currSpeed = Speed.Normal;
		}
		return currSpeed;
	}
	
	public double getLeftEncoderOutput() {
		return leftEncoderOutput.getOutput();
	}
	
	public double getRightEncoderOutput() {
		return rightEncoderOutput.getOutput();
	}

	public void setMaxDrivePIDOutput(double speed) {
		leftEncoderPID.setOutputRange(-speed, speed);
		rightEncoderPID.setOutputRange(-speed, speed);
	}
	
	public double getGyroOutput() {
		return gyroOutput.getOutput();
	}
	
	public Shifter getCurrGear() {
		return currGear;
	}
	
	public Speed getCurrSpeed() {
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
	
	public double[] getVector() {
		return gyro.getVector();
	}
	
	public double getLeftPIDSetpoint() {
		return leftEncoderPID.getSetpoint();
	}
	
	public double getRightPIDSetpoint() {
		return rightEncoderPID.getSetpoint();
	}
	
	public boolean getFrontLightSensor() {
		return !lightSensorFront.get();
	}
	
	public boolean getBackLightSensor() {
		return !lightSensorBack.get();
	}
	
//	public boolean getForwardLightSensors() {
//		return !lightSensorForwardOne.get() & !lightSensorForwardTwo.get();
//		
//	}
	
//	public double getSonarDistance() {
//		return sonar.getRangeInches();
//	}
	
	
	public boolean isOnTarget() {
		return Math.abs(leftEncoderPID.getError()) < driveTolerance ||
				Math.abs(rightEncoderPID.getError()) < driveTolerance;
//		leftEncoderPID.
		
	}
	
	public boolean gyroOnTarget() {
		return Math.abs(gyroPID.getError()) < turnTolerance;
	}
	
	public double getLeftEncoderError() {
		return leftEncoderPID.getError();
	}
	
	public void setGyroPID(double P, double I, double D) {
		gyroPID.setPID(P, I, D);
		
	}
	
	public void resetCrossingDefence() {
		crossingDefence = false;
	}
	
	public void startedCrossingDefence() {
		crossingDefence = true;
	}
	
	public boolean getCrossingDefence() {
		return crossingDefence;
	}
	
	public void armForward() {
		armMotor.set(0.4);
	}
	
	public void armReverse() {
		armMotor.set(-0.4);
	}
	
	public void collecterIn() {
		collecterMotor.set(1);
	}
	
	public void collecterOut() {
		collecterMotor.set(-1);
	}
	
	public void armSthap() {
		armMotor.set(0);
	}
	
	public void collecterSthap() {
		collecterMotor.set(0);
	}
//	public void 
	
	

}
