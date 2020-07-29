package com.robototes.subsystem;

/**
 * A simple subsytem interface that can be run in, out, stopped, and at certain
 * speeds
 *
 * @author Eli Orona
 *
 */
public interface InOutSubsystem extends RobototesSubsystem, Invertable {
	/**
	 * Runs the subsystem in at full speed
	 */
	public void in();

	/**
	 * Runs the subsystem out at full speed
	 */
	public void out();

	/**
	 * Stops the subsytem
	 */
	public void stop();

	/**
	 * Sets the speed of the subsystem
	 *
	 * @param speed The speed to set
	 */
	public void set(double speed);

	/**
	 * Sets the max speed of the subsytem
	 *
	 * @param maxSpeed The max speed to set
	 */
	public void setMaxSpeed(double maxSpeed);

	/**
	 * Gets the max speed of the subsystem
	 *
	 * @return The max speed
	 */
	public double getMaxSpeed();

	/**
	 * Gets the current (last set) speed of the subsystem
	 *
	 * @return The current speed
	 */
	public double getSpeed();
}
