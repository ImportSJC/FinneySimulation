package org.usfirst.frc.team1405.robot;

import edu.wpi.first.wpilibj.Talon;

public class Claw {
	
	Talon leftClaw = new Talon(9);
	Talon rightClaw = new Talon(8);
	boolean previousStateOfClaw = false;
	boolean stateOfClaw = true;

	public void doStuff(boolean AButton) {
		
		if (AButton && stateOfClaw && !previousStateOfClaw) {
			leftClaw.set(-0.5);
			rightClaw.set(0.5);
			stateOfClaw = false;
			
		}else if (AButton && !stateOfClaw && !previousStateOfClaw) {
			leftClaw.set(0.2);
			rightClaw.set(-0.2);
			stateOfClaw = true;
			
		}
		
		previousStateOfClaw = AButton;
	}
	
}
