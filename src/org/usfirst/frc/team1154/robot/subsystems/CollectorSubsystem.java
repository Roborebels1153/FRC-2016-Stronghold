package org.usfirst.frc.team1154.robot.subsystems;

import org.usfirst.frc.team1154.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;

public class CollectorSubsystem  extends Subsystem  {
	
	private Encoder artEncoder;
	private enum CollectorState{In, Out, Up};
	private CollectorState currState;
	private Victor topRoller;
	private Victor bottomRoller;
	
	public CollectorSubsystem(){
		
		artEncoder = new Encoder(RobotMap.ART_ENCODER_A_CHANNEL, RobotMap.ART_ENCODER_B_CHANNEL);
		
		currState = CollectorState.In;
		
		topRoller = new Victor(RobotMap.COLLECTOR_TOP_ROLLER);
		
		bottomRoller = new Victor(RobotMap.COLLECTOR_BOTTOM_ROLLER);
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void collectBoulder(){
		//Spins the rollers to collect the ball
		topRoller.set(1);
		bottomRoller.set(-1);		
	}
	
	public void releaseBoulder(){
		//Spins the rollers opposite to collect to release the ball
		topRoller.set(-1);
		bottomRoller.set(1);	
	}
	
	public void stopMotors(){
		//Stops all motors
		topRoller.set(0);
		bottomRoller.set(0);	
	}
	
	public void switchCollectorPostion(){
		//Switches the collectors postion from either outside the robot or in it
	}
	
	public CollectorState raiseCollector(){
		
		if(currState.equals(CollectorState.Out)) {
			//Put the code to raise the collector here
			
			currState = CollectorState.In;		
		}
		
		
		return currState;
		
	}
	
	public CollectorState lowerCollector(){
		if(currState.equals(CollectorState.In)) {
			//put the code to lower the collector here
			
			currState = CollectorState.Out;		
		}
		
		
		return currState;
	}
	
	public double getArtEncoderDistance(){
		//Gets the encoder distance of the thing controlling the articulation of the collector
		
		return artEncoder.getDistance();
	}
	
	public void liftPort(){
		//the collector lifting up the portcullis
		
	}
	
	
}
