package org.usfirst.frc.team1405.robot;

import edu.wpi.first.wpilibj.Talon;

public class Flipper {
	
	Talon flipperTalon = new Talon(5);
	
	public void doStuff (double rightTrigger) {
		
		if (rightTrigger == 1) {
			flipperTalon.set(0);
			
		}else {
			flipperTalon.set(1);
		}
	}
}