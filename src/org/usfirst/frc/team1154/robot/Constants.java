package org.usfirst.frc.team1154.robot;

public class Constants {

	public static int WHEEL_DIAMETER = 10;
	public static double ENCODER_COUNTS_PER_REV = 8.5;
	public static int TICKS_PER_ENCODER_REV = 128;
	public static double inchesPerTick = WHEEL_DIAMETER * Math.PI / (ENCODER_COUNTS_PER_REV * TICKS_PER_ENCODER_REV);
	public static double defaultMaxSpeed = 1; //0.8; Scott thought the speed was a bit slow so we changed it to max speed
	public static double defaultChevalSpeed = 0.85;
	public static double defaultDrawbridgeSpeed = 0.75;
	public static double defaultTurnSpeed = 0.8; // Scott wants the turn speed to still be slow
	public static double defaultArmSpeed = 0.9;
	public static double approachingGoalSpeed = 0.7;
	public static double defaultDefenceSpeed = 0.9;
	public static double defaultTestSpeed = 0.8;
	//They are all the same as ^
	public static double moatSpeed = 0.9;
	public static double rockWall = 0.8;
	public static double ramparts = 0.8;
	public static double roughTerrain = 0.7;
	public static double portcullis = 0.7;
	
}
