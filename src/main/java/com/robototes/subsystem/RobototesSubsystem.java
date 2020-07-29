package com.robototes.subsystem;

/**
 *
 * @author Eli Orona
 *
 */
public interface RobototesSubsystem {
	/**
	 *
	 * @author Eli Orona
	 *
	 */
	public enum SubsystemType {
		VISION, DRIVEBASE, INTAKE, LIFT, SHOOTER, TURRET, SHIFTER, CLIMB, ARM, OTHER;
	}

	/**
	 *
	 * @return The type of subsystem
	 */
	public SubsystemType getSubsystemType();

	/**
	 *
	 * @return The name of the subsystem
	 */
	public String getRobototesName();
}
