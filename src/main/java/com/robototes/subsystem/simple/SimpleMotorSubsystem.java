package com.robototes.subsystem.simple;

import java.util.Arrays;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 * @author Alex Stedman
 *
 *         A simple subsystem to control a group of motors
 */
public class SimpleMotorSubsystem extends SimpleSubsystem {
	// Motor Controller/Controller Group
	private SpeedController controller;

	// Constructor
	public SimpleMotorSubsystem(SpeedController... speedControllers) {
		if (speedControllers.length > 1) {
			controller = new SpeedControllerGroup(speedControllers[0],
					Arrays.copyOfRange(speedControllers, 1, speedControllers.length - 1));
		} else {
			controller = speedControllers[0];
		}
	}

	// Set the Motor to run in
	@Override
	public void in() {
		controller.set(1);
	}

	// Set the motor to run out
	@Override
	public void out() {
		controller.set(-1);
	}

	// Stop the motor
	public void stop() {
		controller.set(0);
	}

	// Set the motor to run at a set speed
	public void set(double speed) {
		controller.set(speed);
	}

}