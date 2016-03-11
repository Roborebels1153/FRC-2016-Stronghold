package org.usfirst.frc.team1154.lib;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.autonomous.LowBarAutonomous;
import org.usfirst.frc.team1154.robot.commands.DriveForwardOverDefenceCommand;
import org.usfirst.frc.team1154.robot.commands.DriveUntilFrontLightCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GuideForDummies {
	/*
	 * This class will mostly be a document of things so that others will be able to easily access our code and utilize it when they need.
	 * 
	 * To tune the Negative Inertia, go to Rebel Drive to change the high gear and low gear turning inertia
	 * 
	 * To tune the Driving PIDs, go to drive and go to init. Right above, should be all the P, I and D values for the Encoders and the Gyro. 
	 *  Set All the PID stuff here. P does how fast it gets to its target and D slows you down as you get closer. I is not necessary for driving 
	 * in straight lines like we want to so don't mind it too much.
	 *  
	 * Going into ArmWithJoysticks, you can tune how the arm reads the Joystick.
	 * 
	 * Go into Constants to tune any and all Speeds of things. Things like defense crossing speeds, arm speeds, and our gear ratio, are located here,
	 * so for quick fixes, come here.
	 * 
	 * Creating an new autonomous mode will be done in autonomous.
	 * an example would be:
	 * 
 public class LowBarAutonomous extends CommandGroup{
	public LowBarAutonomous() {
		addSequential(new DriveUntilFrontLightCommand());
		addSequential(new DriveForwardOverDefenceCommand(Constants.defaultDefenceSpeed));
	}
}
	 * Create a command for the autonomous by doing a addSequential() with a new (command) followed by a argument, inside the argument. Complicated,
	 * but it should look like the ones above. Note how the new DriveUntil.... command is inside the addSequential's command and then it has an argument itself.
	 * 
	 * Once you've created a new autonomous, you need to put it into the SmartDashboard, go to Robot, and then Robotinit.
	 * Here, you can copy what we've done before. It looks something like this:
	 * 
	 *  chooser.addObject("Low Bar Plain", new LowBarAutonomous());
	 * 
	 * Adding buttons is done in OI. Look at other buttons to add one to the robot. dr stands for the Driver Stick and op Stands for the Operator Stick. 
	 * Make sure you add the button to the right Controller.
	 * 
	 * private double theBest = loser;
	 * 
	 * maximillianCowan == theBest
	 */

}
