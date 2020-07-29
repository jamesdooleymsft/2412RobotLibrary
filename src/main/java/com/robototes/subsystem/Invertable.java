package com.robototes.subsystem;

/**
 * An interface for all types that want to be inverted
 *
 * @author Eli Orona
 *
 */
public interface Invertable {
	/**
	 * Inverts the subsystem if true
	 *
	 * @param inverted The inversion to set
	 */
	public void invert(boolean inverted);

	/**
	 * Gets the current inversion state of the type
	 *
	 * @return True if inverted, false if not
	 */
	public boolean isInverted();

	/**
	 * Inverts a boolean based on the current inversion of the type
	 *
	 * @param input The boolean to invert
	 * @return The inversion of the boolean if needed
	 */
	public default boolean invertBoolean(boolean input) {
		if (isInverted()) {
			return !input;
		}
		return input;
	}

	/**
	 * Inverts a double based on the current inversion of the type
	 *
	 * @param input The double to invert
	 * @return The inversion of the double if needed
	 */
	public default double invertDouble(double input) {
		if (isInverted()) {
			return -input;
		}
		return input;
	}

	/**
	 * Inverts a generic type based on the current inversion of the class
	 *
	 * @param primary  The primary, uninverted state
	 * @param inverted The inverted state
	 * @return The generic type inverted if needed
	 */
	public default <T> T invertGeneric(T primary, T inverted) {
		if (isInverted()) {
			return inverted;
		}
		return primary;
	}
}
