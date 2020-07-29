package com.robototes.motors;

import com.robototes.units.Rotations;
import com.robototes.units.Time;

/**
 * An easy way to set up PID control with a motor
 *
 * @author Eli Orona
 *
 * @param <T> The rotation type of the motor
 */
@Deprecated
public interface PIDMotorController<T extends MotorRotations> {

	/**
	 * Adds rotations for PID control
	 *
	 * @param rotationReference
	 */
	public void addRotations(Rotations rotationReference);

	/**
	 * Adds rotations for PID control
	 *
	 * @param rotationReference
	 */
	public void addRotations(T rotations);

	/**
	 *
	 * @return The number of rotations the motor has done
	 */
	public T getRotations();

	/**
	 * Sets the rotation reference for PID control
	 *
	 * @param rotationReference reference
	 */
	public void setRotations(Rotations rotationReference);

	/**
	 * Sets the rotation reference for PID control
	 *
	 * @param rotations reference
	 */
	public void setRotations(T rotations);

	/**
	 * Sets the speed of the motor, allowing for manual control
	 *
	 * @param speed speed
	 */
	public void setSpeed(double speed);

	/**
	 * Uses the PID output of the PID Controller, with a timestep of 5 milliseconds
	 *
	 * @return The value of the PID Output
	 */
	public double usePIDOutput();

	/**
	 * Uses the PID output of the PID Controller
	 *
	 * @return The value of the PID Output
	 */
	public double usePIDOutput(Time timestep);
}
