package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.Robot;
import org.usfirst.frc.team1154.robot.RobotMap;
import org.usfirst.frc.team1154.robot.subsystems.Arm.ArmHeight;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArmSetHeight extends Command {
	
	private double setpoint;
	
	public ArmSetHeight(ArmHeight height) {
		requires(Robot.arm);
		this.setpoint = getHeight(height);
	}
	
	
	@Override
	protected void initialize() {
		Robot.arm.resetArmEncoder();
		Robot.arm.setSetpoint(setpoint);
		Robot.arm.setArmPIDOutput(Constants.defaultArmSpeed);
		Robot.arm.enablePID();
	}

	@Override
	protected void execute() {
		
		SmartDashboard.putNumber("ArmSetHeight - Current Setpoint", Robot.arm.getSetpoint());
		SmartDashboard.putNumber("ArmSetHeight - Current Arm PID Output", Robot.arm.getArmOutput());
		
	}
	
	@Override
	protected void end() {
		Robot.arm.disablePID();
		Robot.arm.stopArm();
		Robot.arm.resetArmEncoder();
		
	}

	@Override
	protected boolean isFinished() {
		
//		boolean limitLowCheck = Robot.arm.getArmOut();
//
//		
//		if(limitLowCheck){
//			return true;
//		} 
		
		return Robot.arm.onTarget();
	}	

	@Override
	protected void interrupted() {
		end();
	}

	private double getHeight(ArmHeight height) {
		double armSetpoint;
		switch (height) {
			case SPIT : {
				armSetpoint = -30;
				break;
			}
			case HIGH : {
				
				armSetpoint = -100;
				break;
			}
			case SCORE : {
				armSetpoint = -160;
				break;
			}
			default : {
				armSetpoint =  0;
				break;
			}
		
		}
		return armSetpoint;
	}
}
