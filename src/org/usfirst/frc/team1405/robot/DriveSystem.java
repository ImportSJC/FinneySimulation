package org.usfirst.frc.team1405.robot;

import edu.wpi.first.wpilibj.Talon;

public class DriveSystem {
	
	Talon frontRight = new Talon(1);
	Talon frontLeft = new Talon(3);
	Talon backRight= new Talon(2);
	Talon backLeft = new Talon(4);
	
	public void tankDrive(double leftJoystick, double rightJoystick) {
		
		frontRight.set(rightJoystick);
		backRight.set(rightJoystick);
		frontLeft.set(-leftJoystick);
		backLeft.set(-leftJoystick);
		
	}
	


}
