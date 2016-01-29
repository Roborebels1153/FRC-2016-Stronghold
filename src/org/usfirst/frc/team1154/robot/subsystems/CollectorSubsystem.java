package org.usfirst.frc.team1154.robot.subsystems;

import org.usfirst.frc.team1154.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;

public class CollectorSubsystem  extends Subsystem  {
	
	private Encoder pivotEncoder;
	public enum CollectorState{In, Out, Up};
	private CollectorState currState;
	private Victor collectorRoller;
	private Victor pivotMotor;
	
	public CollectorSubsystem(){
		
		pivotEncoder = new Encoder(RobotMap.PIVOT_ENCODER_A_CHANNEL, RobotMap.PIVOT_ENCODER_B_CHANNEL);
		
		currState = CollectorState.In;
		
		collectorRoller = new Victor(RobotMap.COLLECTOR_ROLLERS);
		
		pivotMotor = new Victor(RobotMap.PIVOT_MOTOR);
		
		
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
	
	public void stopMotors(){
		//Stops all motors
		collectorRoller.set(0);
		pivotMotor.set(0);
	}
	
	public CollectorState raiseCollector(){
			
		pivotMotor.set(-1);

		currState = CollectorState.In;
		
		return currState;	
	}
	
	public CollectorState lowerCollector(){
			
		pivotMotor.set(1);

		currState = CollectorState.Out;
	
		return currState;	
	}

}