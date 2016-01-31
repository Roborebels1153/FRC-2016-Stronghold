package org.usfirst.frc.team1154.robot.subsystems;

import org.usfirst.frc.team1154.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;

public class CollectorSubsystem  extends Subsystem  {
	
	private Encoder pivotEncoder;
	public enum CollectorState{In, Out, Up};
	private CollectorState currState;
	private Victor collectorRoller;
	private Victor pivotMotor;
	private DigitalInput collectorInSwitch;
	private DigitalInput collectorOutSwitch;
	
	public CollectorSubsystem(){
		
		pivotEncoder = new Encoder(RobotMap.PIVOT_ENCODER_A_CHANNEL, RobotMap.PIVOT_ENCODER_B_CHANNEL);
		
		currState = CollectorState.In;
		
		collectorRoller = new Victor(RobotMap.COLLECTOR_ROLLERS);
		
		pivotMotor = new Victor(RobotMap.PIVOT_MOTOR);
		
		collectorInSwitch = new DigitalInput(RobotMap.COLLECTOR_IN_SWITCH);
		
		collectorOutSwitch = new DigitalInput(RobotMap.COLLECTOR_OUT_SWITCH);
		
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public double getPivotEncoderDistance(){
		//Gets the encoder distance of the thing controlling the articulation of the collector
		
		return pivotEncoder.getDistance();
	}
	
	public void resetPivotEncoder(){
		//Resets the encoder distance value back to zero.
		
		pivotEncoder.reset();
	}
	
	public CollectorState checkCollectorState(){
	
		return currState;
	}
	
	public void collectBoulder(){
		//Spins the rollers to collect the ball
		collectorRoller.set(1);	
	}
	
	public void releaseBoulder(){
		//Spins the rollers opposite to collect to release the ball
		collectorRoller.set(-1);	
	}
	
	public void stopCollecting(){
		//Stops the Roller motors
		collectorRoller.set(0);
	}

	public void stopPivoting(){
		//Stops the Pivot motor
		pivotMotor.set(0);
	}
	
	public boolean getCollectorIn(){
		//Returns the state of the in switch 
		return collectorInSwitch.get();
	}
	
	public boolean getCollectorOut(){
		//Returns the state of the out switch
		return collectorOutSwitch.get();
	}
	
	public void out(){
		//Sets the pivot motor to move the collector out
		pivotMotor.set(1);
	}

	public void in(){
		//Sets the pivot motor to move the collector in
		pivotMotor.set(-1);
	}
	
	public double getPivotOutput() {
		return pivotMotor.get();
	}
}