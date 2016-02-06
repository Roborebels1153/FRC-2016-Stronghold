package org.usfirst.frc.team1154.robot.subsystems;

import org.usfirst.frc.team1154.robot.Robot;
import org.usfirst.frc.team1154.robot.RobotMap;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Arm extends PIDSubsystem {
	
	private Encoder armEncoder;
	private Victor armMotor;
	private DigitalInput armInSwitch;
	private DigitalInput armOutSwitch;
	private PIDController armController;
	
	public Arm() {
		
		super("Arm", 0.5, 0, 0);
		
		armEncoder = new Encoder(RobotMap.ARM_ENCODER_A_CHANNEL, RobotMap.ARM_ENCODER_B_CHANNEL, false, EncodingType.k4X);
		
		armMotor = new Victor(RobotMap.ARM_MOTOR);
		
		armInSwitch = new DigitalInput(RobotMap.ARM_IN_SWITCH);
		
		armOutSwitch = new DigitalInput(RobotMap.ARM_OUT_SWITCH);
		
		armController = new PIDController(.05, 0, 0, armEncoder, armMotor);
		
		setAbsoluteTolerance(5);
		
		getPIDController().setContinuous(false);
	}
	
	public void init() {
		armEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
		
		armEncoder.reset();
		
		armController.setOutputRange(-0.8, 0.8);
	}
	
	public void enablePID() {
		
		armController.enable();
		
	}
	
	public void disablePID() {
		
		armController.disable();
		
	}
	
	protected void initDefaultCommand() {
	//Purposely left blank	
	}

	
	protected double returnPIDInput() {
		return armEncoder.pidGet();
	}


	protected void usePIDOutput(double output) {
		armMotor.set(output);
		SmartDashboard.putNumber("PIDWrite", output);
	}
	
	public void resetArmEncoder(){
		//Resets the encoder distance value back to zero.
		
		armEncoder.reset();
	}
	
	public void stopArm(){
		//Stops the Pivot motor
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
		//Sets the pivot motor to move the collector out
		armMotor.set(1);
	}

	public void in(){
		//Sets the pivot motor to move the collector in
		armMotor.set(-1);
	}
	
	public double getArmOutput() {
		return armMotor.get();
	}
	
	public double getArmPosition() {
		return armEncoder.get();
	}
	
//	public void setSetPoint(double setPoint) {
//		
//	}

	
}
