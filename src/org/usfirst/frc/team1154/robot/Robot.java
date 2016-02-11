
package org.usfirst.frc.team1154.robot;

import java.text.DecimalFormat;

import org.team2168.utils.BNO055;
import org.usfirst.frc.team1154.robot.autonomous.TurninWithTyler;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;
import org.usfirst.frc.team1154.robot.subsystems.Arm;
import org.usfirst.frc.team1154.robot.subsystems.Collector;
import org.usfirst.frc.team1154.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static final Collector collector = new Collector();
	public static final Arm arm = new Arm();
	public static final Drive drive = new Drive();
	public static OI oi;
	private Compressor compressor = new Compressor();
	private double[] pos = new double[3]; // [x,y,z] position data
	private BNO055.CalData cal;
	private DecimalFormat f = new DecimalFormat("+000.000;-000.000");
	
	private CameraServer server;
	
    Command autonomousCommand;
    SendableChooser chooser;
    
    public Robot() {
    	server = CameraServer.getInstance();
    	server.setQuality(1);
    	server.startAutomaticCapture("cam0");
    }

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        chooser = new SendableChooser();
        compressor.setClosedLoopControl(true);
        
        chooser.addObject("Turn Test", new TurninWithTyler());
        SmartDashboard.putData("Auto mode", chooser);
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		
//		System.out.println("COMMS: " + drive.isSensorPresant()
//							+ ", INITIALIZED: " + drive.isGyroInitialized()
//							+ ", CALIBRATED: " + drive.isGyroCalibrated());
//		if(drive.isGyroInitialized()) {
//			pos = drive.getVector();
//			
//			
//			/* Display the floating point data */
//			System.out.println("\tX: " + f.format(pos[0])
//							+ " Y: " + f.format(pos[1]) + " Z: " + f.format(pos[2])
//							+ " H: " + drive.getHeading());
//			
//			/*Display calibration status for each sensor. */
//			cal = drive.getCalibration();
//			System.out.println("\tCALIBRATION: Sys=" + cal.sys
//							+ " Gyro=" + cal.gyro + "Accel=" + cal.accel
//							+ " Mag=" + cal.mag);
//		}
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
    	
//    	autonomousCommand = new DriveWithPID(120);
        autonomousCommand = (Command) chooser.getSelected();
       
//		String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
//		switch(autoSelected) {
//		case "My Auto":
//			autonomousCommand = new MyAutoCommand();
//			break;
//		case "Default Auto":
//		default:
//			autonomousCommand = new ExampleCommand();
//			break;
//		} 
    	
    	 //schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        updateSmartDashboard();
    }

    public void teleopInit() {
    	
        if (autonomousCommand != null) autonomousCommand.cancel();
        
        Robot.drive.disablePID();
        
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        updateSmartDashboard();
		
    }
    
    private void updateSmartDashboard() {
    	SmartDashboard.putNumber("Pivot Value", Robot.arm.getArmOutput());
		SmartDashboard.putBoolean("Pivot Limit Switch Out", Robot.arm.getArmOut());
		SmartDashboard.putBoolean("Pivot Limit Switch In", Robot.arm.getArmIn());
		SmartDashboard.putNumber("Arm Encoder", Robot.arm.getArmPosition());
		SmartDashboard.putNumber("Arm Setpoint", Robot.arm.getSetpoint());
		SmartDashboard.putBoolean("Light Sensor(Please Boss?)", Robot.collector.getLightsensor());
		SmartDashboard.putNumber("Current Angle", Robot.drive.getAngle());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
