package com.robototes.subsystem.simple;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * @author Alex Stedman
 *
 *         A simple subsystem for Double Solenoids
 */
public class SimpleDoubleSolenoidSubsystem extends SimpleSubsystem {
	// the Double Solenoid
	private DoubleSolenoid solenoid;

	// constructor
	public SimpleDoubleSolenoidSubsystem(DoubleSolenoid s) {
		solenoid = s;
	}

	// extend the Double Solenoid
	@Override
	public void in() {
		solenoid.set(Value.kReverse);
	}

	// Retract the Double Solenoid
	@Override
	public void out() {
		solenoid.set(Value.kForward);
	}

	// Stop/Turn off the Double Solenoid
	public void stop() {
		solenoid.set(Value.kOff);
	}
}