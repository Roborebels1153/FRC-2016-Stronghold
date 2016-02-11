package org.usfirst.frc.team1154.robot;

public class Constants {

	public static int WHEEL_DIAMETER = 10;
	public static int ENCODER_COUNTS_PER_REV = 128;
	public static double inchesPerTick = Constants.WHEEL_DIAMETER * Math.PI / Constants.ENCODER_COUNTS_PER_REV;
	public static double defaultMaxSpeed = 0.8;
	public static double moatSpeed = 0.75;
	public static double rockWall = 0.7;
	public static double ramparts = 6;
	public static double roughTerrain = 0.8;
}
