package org.usfirst.frc.team1154.robot;

public class Constants {

	public static int WHEEL_DIAMETER = 10;
	public static int ENCODER_COUNTS_PER_REV = 128;
	public static double inchesPerTick = Constants.WHEEL_DIAMETER * Math.PI / Constants.ENCODER_COUNTS_PER_REV;
	public static double defaultMaxSpeed = 0.8;
}
