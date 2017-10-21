package org.usfirst.frc.team1405.robot;

import edu.wpi.first.wpilibj.Talon;

public class Loader {
	
	Talon leftLoader = new Talon(7);
	Talon rightLoader = new Talon(6);
	boolean stateOfLoader = false;
	boolean stateOfClaw = true;
	boolean previousStateOfClaw = false;
	
	public void doStuff (boolean AButton , boolean BButton) {
		
		if (AButton && stateOfClaw && !previousStateOfClaw) {
			stateOfClaw = false;
			
		}else if (AButton && !stateOfClaw && !previousStateOfClaw) {
			stateOfClaw = true;
			
		}
		
		if (BButton && stateOfClaw && !stateOfLoader) {
			leftLoader.set(-2);
			rightLoader.set(-2);
			stateOfLoader = true;
			
		} else if (!BButton && stateOfLoader){
			leftLoader.set(0.4);
			rightLoader.set(0.4);
			stateOfLoader = false;
		}
	
		previousStateOfClaw = AButton;
	}
}