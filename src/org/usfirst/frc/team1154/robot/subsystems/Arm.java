package org.usfirst.frc.team1154.robot.subsystems;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.Robot;
import org.usfirst.frc.team1154.robot.RobotMap;
import org.usfirst.frc.team1154.robot.commands.ArmWithJoysticks;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


public class Arm extends Subsystem {
	
//  private Encoder armEncoder;
	private Encoder armEncoder;
	private PIDController armController;
	private AnalogInput ai;
	public Victor armMotor;
	private DigitalInput armInSwitch;
	private DigitalInput armOutSwitch;
	private PIDController armEncoderPID;
	
	
	public enum ArmHeight {
		SPIT,
		HIGH,
		DRAW,
		SCORE,
		PORT
	}
	
	public Arm() {
		
		
		ai = new AnalogInput(0);
		
//		armEncoder = new AnalogPotentiometer(ai,360,0);
		
		armEncoder = new Encoder(RobotMap.ARM_ENCODER_A_CHANNEL, RobotMap.ARM_ENCODER_B_CHANNEL, false, EncodingType.k4X);
				
		armMotor = new Victor(RobotMap.ARM_MOTOR);
		
		armInSwitch = new DigitalInput(RobotMap.ARM_IN_SWITCH);
		
		armOutSwitch = new DigitalInput(RobotMap.ARM_OUT_SWITCH);
		
		armEncoderPID = new PIDController(.2, 0, 0, armEncoder, armMotor);
		
		init();
		
	}
	
	public void init() {
		armEncoder.setPIDSourceType(PIDSourceType.kDisplacement);

		armEncoderPID.setOutputRange(-0.8, 0.8);
		
		LiveWindow.addSensor("Arm Encoder", "Potentiometer",  armEncoderPID);
	}
	
	public void enablePID() {
		
		armEncoderPID.enable();
		
	}
	
	public void disablePID() {
	
		armEncoderPID.disable();
		
	}
	
	protected void initDefaultCommand() {
		
		setDefaultCommand (new ArmWithJoysticks(Constants.defaultArmSpeed));
	}
	
//	public void resetArmEncoder(){
//		//Resets the encoder distance value back to zero.
//		
//		armEncoder.reset();
//	}
	
	public void stopArm(){
		//Stops the Arm motor
		armMotor.set(0);
	}
	
	public boolean getArmIn(){
		//Returns the state of the in switch 
		return armInSwitch.get();
	}
	
	public boolean getArmOut(){
		//Returns the state of the out switch
		return armOutSwitch.get();
	}
	
	public void out(){
		//Sets the Arm motor to move the collector out
		armMotor.set(-Constants.defaultArmSpeed);
	}

	public void in(){
		//Sets the Arm motor to move the collector in
		armMotor.set(Constants.defaultArmSpeed);
	}
	
	public void armLimitHitIn() {
		while(Robot.arm.getArmIn() == false) {
			in();
		}
	}
	
	public void armLimitHitOut() {
		while(Robot.arm.getArmOut() == false) {
			out();
		}
	}
	
	public void driveArm(Joystick stick) {
		double speed = stick.getY();
		if(Robot.oi.getOperatorStick().getRawButton(5)) {
			armMotor.set(speed);
		} else if(Robot.arm.getArmIn() && speed > 0 ) {
			armMotor.set(0);
		} else if(Robot.arm.getArmOut() && speed < 0) {
			armMotor.set(0);
		} else if(Math.abs(speed) < 0.1){
			armMotor.set(0);
		} else {
			armMotor.set(speed);
		}
	}
	
	public void driveArm(double speed) {
		armMotor.set(speed);
	}
	
	public double getArmOutput() {
		return armMotor.get();
	}
	
	public double getArmPosition() {
		return armEncoder.get();
	}
	
	public double getArmEncoderDistance() {
		return armEncoder.getDistance();
	}
	
	public double getArmVoltage() {
		return ai.getAverageVoltage();
	}
	
	public void setArmPIDOutput(double speed) {
		armEncoderPID.setOutputRange(-speed, speed);
	}
	
	public void resetArmEncoder() {
		armEncoder.reset();
	}
	
	public double getArmPIDOutput() {
		return armEncoderPID.get();
	}

	public void setSetpoint(double setpoint) {
		// TODO Auto-generated method stub
		armEncoderPID.setSetpoint(setpoint);
		
	}

	public double getSetpoint() {
		// TODO Auto-generated method stub
		return armEncoderPID.getSetpoint();
	}

	public boolean onTarget() {
		// TODO Auto-generated method stub
		return Math.abs(armEncoder.get() - getSetpoint()) < 5;
	}
	
	public void armMotorSet(double armSpeed) {
		armMotor.set(armSpeed);
	}
	

}
