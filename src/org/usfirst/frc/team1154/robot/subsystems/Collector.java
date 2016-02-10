package org.usfirst.frc.team1154.robot.subsystems;

import org.usfirst.frc.team1154.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;

public class Collector  extends Subsystem  {
	
	
	public enum CollectorState{In, Out, Up};
	private CollectorState currState;
	private Victor collectorRoller;
	private DigitalInput lightsensor;
	
	
	public Collector() {
		
		currState = CollectorState.In;
		
		collectorRoller = new Victor(RobotMap.COLLECTOR_ROLLERS);
		
		lightsensor = new DigitalInput(RobotMap.LIGHT_SENSOR);
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
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
	
	public boolean getLightsensor(){
		
		return lightsensor.get();
	}

	
}