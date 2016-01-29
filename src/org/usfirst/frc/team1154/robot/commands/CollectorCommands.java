package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Robot;
import org.usfirst.frc.team1154.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CollectorCommands extends Command{
	public CollectorCommands(){
		requires(Robot.collect);
	}
	
	private Joystick opStick = new Joystick(RobotMap.OPERATOR_JOYSTICK);
	private Button opA = new JoystickButton(opStick,0);

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		SmartDashboard.putNumber("Pivot Encoder", Robot.collect.getPivotEncoderDistance());
		
		//Collecting and Releasing the Boulder
		if(opStick.getRawAxis(2) > .5){
			while(opStick.getRawAxis(2) > .5){
				Robot.collect.collectBoulder();
			}
		}
		
		if(opStick.getRawAxis(3) > .5){
			while(opStick.getRawAxis(3) > .5){
				Robot.collect.releaseBoulder();
			}
		}
		
		//Collector Movement
		if(opStick.getRawButton(0)){ //Button A pressed
			if(Robot.collect.checkCollectorState().equals("Out")){
				
				while(Robot.collect.getPivotEncoderDistance() < 1500){
					Robot.collect.raiseCollector();
				}
				
				Robot.collect.stopMotors();

			}else if(Robot.collect.checkCollectorState().equals("In")){

				while(Robot.collect.getPivotEncoderDistance() > 0){
					Robot.collect.lowerCollector();
				}
				
				Robot.collect.stopMotors();
			}	
		}
		
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
