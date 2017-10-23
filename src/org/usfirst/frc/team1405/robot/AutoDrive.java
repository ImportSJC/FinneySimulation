package org.usfirst.frc.team1405.robot;

public class AutoDrive extends DriveSystem{

	public void driveForward(int speed) {
			tankDrive(speed, speed);
		
	}
	
	public void turnRight (int leftSpeed, int rightSpeed) {
		tankDrive(leftSpeed, rightSpeed);
	}
}
