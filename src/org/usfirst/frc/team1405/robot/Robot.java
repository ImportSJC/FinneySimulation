package org.usfirst.frc.team1405.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
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
	DriveSystem driveMode;
	Talon flipperTalon;
	Talon leftClaw;
	Talon rightClaw;
	Talon leftLoader;
	Talon rightLoader;
	boolean stateOfFlipper = true;
	boolean stateOfClaw = true;
	boolean previousStateOfClaw = false;
	boolean stateOfLoader = false;
	double leftStickRawValue;
	double rightStickRawValue;
	Joystick myJoystick;
	
	final String defaultAuto = "Default";
	final String customAuto = "My Auto";
	String autoSelected;
	SendableChooser<String> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
		flipperTalon = new Talon(5);
		leftClaw = new Talon(9);
		rightClaw = new Talon(8);
		leftLoader = new Talon(7);
		rightLoader = new Talon(6);
		myJoystick = new Joystick(0);
		driveMode = new DriveSystem();
		chooser.addDefault("Default Auto", defaultAuto);
		chooser.addObject("My Auto", customAuto);
		SmartDashboard.putData("Auto choices", chooser);
	}


	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		autoSelected = chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		switch (autoSelected) {
		case customAuto:
			// Put custom auto code here
			break;
		case defaultAuto:
		default:
			// Put default auto code here
			break;
		}
	}

	/**
	 * ROBOT OPORATION:
	 * Tank Drive
	 * Press A Button: Open/Close ball grabbing mechanism
	 * Hold B Button: Ball loading mechanism
	 * Hold Right Trigger: Launch Ball
	 */
	@Override
	public void teleopPeriodic() {
		

		
		driveMode.tankDrive(myJoystick.getRawAxis(1) , myJoystick.getRawAxis(4));
		
		if (myJoystick.getRawAxis(5) == 1) {
			flipperTalon.set(0);
			
		}else {
			flipperTalon.set(1);
			
		}
		
		if (myJoystick.getRawButton(1) && stateOfClaw && !previousStateOfClaw) {
			leftClaw.set(-0.5);
			rightClaw.set(0.5);
			stateOfClaw = false;
			
		}else if (myJoystick.getRawButton(1) && !stateOfClaw && !previousStateOfClaw) {
			leftClaw.set(0.5);
			rightClaw.set(-0.5);
			stateOfClaw = true;
			
		}
		
		if (myJoystick.getRawButton(2) && stateOfClaw && !stateOfLoader) {
			leftLoader.set(-2);
			rightLoader.set(-2);
			stateOfLoader = true;
			System.out.println("Test One");
			
		} else if (!myJoystick.getRawButton(2) && stateOfLoader){
			leftLoader.set(0.4);
			rightLoader.set(0.4);
			stateOfLoader = false;
			System.out.println("Test Two");
			
		}
		
		previousStateOfClaw = myJoystick.getRawButton(1);
		
	}
	


	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	}
}

