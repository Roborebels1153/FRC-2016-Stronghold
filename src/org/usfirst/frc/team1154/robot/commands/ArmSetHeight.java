package org.usfirst.frc.team1154.robot.commands;

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
		Robot.arm.enablePID();
		Robot.arm.resetArmEncoder();
		Robot.arm.setSetpoint(setpoint);		
		
	}

	@Override
	protected void execute() {
		SmartDashboard.putNumber("Current Arm Position" , Robot.arm.getArmPosition());
		SmartDashboard.putNumber("Arm PID Output", Robot.arm.getArmOutput());
		
	}
	
	@Override
	protected void end() {
		Robot.arm.disablePID();
		Robot.arm.stopArm();
	}

	@Override
	protected boolean isFinished() {
		
		boolean limitLowCheck = Robot.arm.getArmOut();
		boolean limitHighCheck = Robot.arm.getArmIn();
		
		if(limitLowCheck || limitHighCheck == true){
			return true;
		} 
		
		return false;
	}	

	@Override
	protected void interrupted() {
		end();
	}

	private double getHeight(ArmHeight height) {
		double armSetpoint;
		switch (height) {
			case LOW : {
				armSetpoint = 100;
				break;
			}
			case HIGH : {
				armSetpoint = 150;
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
