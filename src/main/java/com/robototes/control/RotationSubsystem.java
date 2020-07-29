package com.robototes.control;

import com.robototes.motors.PIDMotorController;
import com.robototes.units.InterUnitRatio;
import com.robototes.units.Rotations;
import com.robototes.units.UnitTypes.RotationUnits;

/**
 * A subsystem that rotates with PID Control.
 *
 * @author Eli Orona
 *
 */
@Deprecated
public class RotationSubsystem implements PIDSubsystem<Rotations> {

	private PIDMotorController<?>[] motors;
	private InterUnitRatio<RotationUnits, RotationUnits> rotationsToDistance;
	private Rotations currentReference = new Rotations(0);

	RotationSubsystem(PIDMotorController<?>[] motors, InterUnitRatio<RotationUnits, RotationUnits> ratio) {
		this.motors = motors;
		rotationsToDistance = ratio;
	}

	@Override
	public void addRefecence(Rotations addRefernce) {
		currentReference = currentReference.add(addRefernce);
		Rotations rotationReference = new Rotations(rotationsToDistance.calculateReverseRatio(currentReference));
		for (PIDMotorController<?> motor : motors) {
			motor.setRotations(rotationReference);
		}
	}

	@Override
	public Rotations getError() {
		Rotations totalDistance = new Rotations(0);
		for (PIDMotorController<?> motor : motors) {
			totalDistance.add(new Rotations(rotationsToDistance.calculateReverseRatio(motor.getRotations())));
		}
		totalDistance.divide(new Rotations(motors.length));
		return currentReference.subtract(totalDistance);
	}

	@Override
	public PIDMotorController<?>[] getMotors() {
		return motors;
	}

	@Override
	public void setMotorSpeed(double speed) {
		for (PIDMotorController<?> motor : motors) {
			motor.setSpeed(speed);
		}
	}

	@Override
	public void setReference(Rotations reference) {
		currentReference = reference;
		Rotations rotationReference = new Rotations(rotationsToDistance.calculateReverseRatio(reference));
		for (PIDMotorController<?> motor : motors) {
			motor.setRotations(rotationReference);
		}
	}

	@Override
	public void usePID() {
		for (PIDMotorController<?> motor : motors) {
			motor.usePIDOutput();
		}
	}
}
