
package org.usfirst.frc.team1154.robot;

import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

import org.team2168.utils.BNO055;
import org.usfirst.frc.team1154.robot.autonomous.ChevalAutonomous;
import org.usfirst.frc.team1154.robot.autonomous.DrivingWithPIDTest;
import org.usfirst.frc.team1154.robot.autonomous.StayStillAutonomous;
import org.usfirst.frc.team1154.robot.autonomous.TrialThingAutonomous;
import org.usfirst.frc.team1154.robot.autonomous.LowBarAutonomous;
import org.usfirst.frc.team1154.robot.autonomous.LowBarAutonomousWithScore;
import org.usfirst.frc.team1154.robot.autonomous.LowBarAutonomousWithSetup;
import org.usfirst.frc.team1154.robot.autonomous.AutonomousCombosTesting;
import org.usfirst.frc.team1154.robot.autonomous.MoatAutonomous;
import org.usfirst.frc.team1154.robot.autonomous.MoatAutonomousWithScore;
import org.usfirst.frc.team1154.robot.autonomous.MoatAutonomousWithSetup;
import org.usfirst.frc.team1154.robot.autonomous.PortcullisAutonomous;
import org.usfirst.frc.team1154.robot.autonomous.PortcullisAutonomousWithScore;
import org.usfirst.frc.team1154.robot.autonomous.RampartsAutonomous;
import org.usfirst.frc.team1154.robot.autonomous.RampartsAutonomousWithScore;
import org.usfirst.frc.team1154.robot.autonomous.RampartsAutonomousWithSetup;
import org.usfirst.frc.team1154.robot.autonomous.RockWallAutonomous;
import org.usfirst.frc.team1154.robot.autonomous.RockWallAutonomousWithScore;
import org.usfirst.frc.team1154.robot.autonomous.RockWallAutonomousWithSetup;
import org.usfirst.frc.team1154.robot.autonomous.RoughTerrainAutonomous;
import org.usfirst.frc.team1154.robot.autonomous.RoughTerrainAutonomousWithScore;
import org.usfirst.frc.team1154.robot.autonomous.RoughTerrainAutonomousWithSetup;
import org.usfirst.frc.team1154.robot.autonomous.SpitOutBallCommand;
import org.usfirst.frc.team1154.robot.autonomous.TurnWithPIDTest;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;
import org.usfirst.frc.team1154.robot.subsystems.Arm;
import org.usfirst.frc.team1154.robot.subsystems.Collector;
import org.usfirst.frc.team1154.robot.subsystems.Drive;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.FlipAxis;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
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
	private Timer visionScheduler = new Timer("Vision Scheduler", true);
	
	private int cameraSession;
	private Image frame;
	
	
//	private CameraServer server;
	
    Command autonomousCommand;
    SendableChooser chooser;
    
    public Robot() {
//    	server = CameraServer.getInstance();
//    	server.setQuality(1);
//    	server.startAutomaticCapture("cam0");
//    	NIVision.imaqFlip(server.get, null, FlipAxis.HORIZONTAL_AXIS);
    	
    }

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        chooser = new SendableChooser();
        compressor.setClosedLoopControl(true);
        
        frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
        cameraSession = NIVision.IMAQdxOpenCamera("cam0", NIVision.IMAQdxCameraControlMode.CameraControlModeController); 
        NIVision.IMAQdxConfigureGrab(cameraSession);
        NIVision.IMAQdxStartAcquisition(cameraSession);
        
        chooser.addObject("Low Bar Plain", new LowBarAutonomous());
        chooser.addObject("Low Bar Score", new LowBarAutonomousWithScore());
        chooser.addObject("Low Bar Setup", new LowBarAutonomousWithSetup());
        chooser.addObject("Moat Plain", new MoatAutonomous());
        chooser.addObject("Moat Score", new MoatAutonomousWithScore());
        chooser.addObject("Moat Setup", new MoatAutonomousWithSetup());
        chooser.addObject("Ramparts Plain", new RampartsAutonomous());
        chooser.addObject("Ramparts Score", new RampartsAutonomousWithScore());
        chooser.addObject("Ramparts Setup", new RampartsAutonomousWithSetup());
        chooser.addObject("Cheval Plain", new ChevalAutonomous());
        chooser.addObject("Rock Wall Plain", new RockWallAutonomous());
        chooser.addObject("Rock Wall Score", new RockWallAutonomousWithScore());
        chooser.addObject("Rock Wall Setup", new RockWallAutonomousWithSetup());
        chooser.addObject("Rough Terrain Plain", new RoughTerrainAutonomous());
        chooser.addObject("Rough Terrain Score", new RoughTerrainAutonomousWithScore());
        chooser.addObject("Rough Terrain Setup", new RoughTerrainAutonomousWithSetup());
        chooser.addObject("Portcullis Plain", new PortcullisAutonomous());
        chooser.addObject("Portcullis Score", new PortcullisAutonomousWithScore());
        chooser.addObject("TurnWithPID Test", new TurnWithPIDTest());
        chooser.addObject("DriveWithPID Test", new DriveWithPID(120));//new DrivinWithDono());
        chooser.addObject("Turn and Drive Testing", new AutonomousCombosTesting());
        chooser.addObject("Ball Spit Command", new SpitOutBallCommand());
        chooser.addObject("Stay Still", new StayStillAutonomous());
        chooser.addObject("TestWithToshak'sPermission/DontUse", new TrialThingAutonomous());
        
        
        SmartDashboard.putData("Auto mode", chooser);
        
    	visionScheduler.scheduleAtFixedRate(new TimerTask() {
    		public void run() {
    			displayCamera();
    		}
    	}, 0, 50);
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
		
		System.out.println("COMMS: " + drive.isSensorPresant()
							+ ", INITIALIZED: " + drive.isGyroInitialized()
							+ ", CALIBRATED: " + drive.isGyroCalibrated());
		if(drive.isGyroInitialized()) {
			pos = drive.getVector();
			
			
			/* Display the floating point data */
			System.out.println("\tX: " + f.format(pos[0])
							+ " Y: " + f.format(pos[1]) + " Z: " + f.format(pos[2])
							+ " H: " + drive.getAngle());
			
			/*Display calibration status for each sensor. */
			cal = drive.getCalibration();
			System.out.println("\tCALIBRATION: Sys=" + cal.sys
							+ " Gyro=" + cal.gyro + "Accel=" + cal.accel
							+ " Mag=" + cal.mag);
			
			Robot.drive.setInitialAngle(drive.getAngle());
		}
		
//		displayCamera();
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
    	
//    	if(DriverStation.getInstance().getMatchTime() < 3) {
//    		Scheduler.getInstance().removeAll();
//    		Robot.drive.arcadeDrive(0, 0);
//    	} else {
//    		Scheduler.getInstance().run();
//    	}
        Scheduler.getInstance().run();
        updateSmartDashboard();
    }

    public void teleopInit() {
    	
        if (autonomousCommand != null) autonomousCommand.cancel();
        Robot.drive.disablePID();
        
        Scheduler.getInstance().removeAll();
        
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        updateSmartDashboard();
		
    } 
    
    private void updateSmartDashboard() {

    	
    	SmartDashboard.putData("Robot - Scheduler", Scheduler.getInstance());
    	SmartDashboard.putData("Robot - Collector Subsystem" , collector);
    	SmartDashboard.putData("Robot - Arm Subsystem" , arm);
    	SmartDashboard.putData("Robot - Drive Subsystem" ,drive);
     
		SmartDashboard.putBoolean("Robot - Arm Limit Switch Out", Robot.arm.getArmOut());
		SmartDashboard.putBoolean("Robot - Arm Limit Switch In", Robot.arm.getArmIn());
		SmartDashboard.putNumber("Robot - Arm Encoder", Robot.arm.getArmEncoderDistance());
		SmartDashboard.putNumber("Robot - Arm Setpoint", Robot.arm.getSetpoint());
		
		SmartDashboard.putBoolean("Robot - Ball Light Sensor(Please Boss?)", Robot.collector.getBallLightSensor());
		SmartDashboard.putBoolean("Robot - Front Light Sensor(Boss Please?)", Robot.drive.getFrontLightSensor());
		SmartDashboard.putBoolean("Robot - Back Light Sensor(Prank Boss?)", Robot.drive.getBackLightSensor());
		
		SmartDashboard.putNumber("Robot - Current Gyro Angle", Robot.drive.getAngle());
		SmartDashboard.putNumber("Robot - Current Voltage Value", Robot.arm.getArmVoltage());
		SmartDashboard.putBoolean("Robot - Arm In Switch", Robot.arm.getArmIn());
		SmartDashboard.putBoolean("Robot - Arm Out Switch",Robot.arm.getArmOut());
		
		SmartDashboard.putNumber("Robot - Arm motor", Robot.arm.getArmOutput());
		
		
		SmartDashboard.putNumber("Robot - Initial Gyro Value", Robot.drive.getInitialAngle());
		SmartDashboard.putNumber("Robot - Gyro PID Setpoint", Robot.drive.getSetpoint());
		
		SmartDashboard.putNumber("Robot - Left Encoder", Robot.drive.getLeftEncoderDistance());
		SmartDashboard.putNumber("Robot - Right Encoder", Robot.drive.getRightEncoderDistance());
		
		SmartDashboard.putNumber("Robot - Average Error", Robot.drive.getLeftEncoderError());
		
    }
    
    public void displayCamera() {
//    	try {
    	NIVision.IMAQdxGrab(cameraSession, frame, 1);
    	NIVision.imaqFlip(frame, frame, FlipAxis.HORIZONTAL_AXIS);
    	NIVision.imaqFlip(frame, frame, FlipAxis.VERTICAL_AXIS);
    	
    	CameraServer.getInstance().setImage(frame);
//    	} catch(Exception ex) {
//    		 cameraSession = NIVision.IMAQdxOpenCamera("cam0", NIVision.IMAQdxCameraControlMode.CameraControlModeController); 
//    	        NIVision.IMAQdxConfigureGrab(cameraSession);
//    	        NIVision.IMAQdxStartAcquisition(cameraSession);
//    	}
    }

    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
