package org.usfirst.frc.team1154.robot.subsystems;

import org.usfirst.frc.team1154.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Climber extends Subsystem {
	
	private Solenoid climber;
	private Solenoid actuator;
	private enum ClimberState {IN, OUT};
	private ClimberState currState;
	private enum ActuatorState{UP, DOWN};
	private ActuatorState currPosition;
	  
	DriverStation ds = DriverStation.getInstance();

	
	public Climber() {
		
		climber = new Solenoid(RobotMap.CLIMBER_SOLENOID_A);
		
		actuator = new Solenoid( RobotMap.CLIMBER_SOLENOID_B);
		
		currState = ClimberState.IN;
		
		currPosition = ActuatorState.DOWN;
		
	}
	
	public ActuatorState actuatorOut() {
		if(currPosition.equals(ActuatorState.DOWN)) {
			
		//	actuator.set(on);;
			currPosition = ActuatorState.UP;
			
		}
		return currPosition;
	}
	
	public ActuatorState actuatorIn() {
		if(currPosition.equals(ActuatorState.UP)) {
			
		//	actuator.set(Solenoid.Value.kReverse);
			currPosition = ActuatorState.DOWN;
			
		}
		return currPosition;
	}
	
	
	
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
	public boolean armState() {
		if(currPosition.equals(ActuatorState.UP)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public boolean isEndGame() {
		return ds.getMatchTime() < 20;
	}
	
}
