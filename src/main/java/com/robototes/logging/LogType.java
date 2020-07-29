package com.robototes.logging;

/**
 * A level identifier for logging, allows for different types of logs to be
 * recorded
 *
 * @author Eli Orona
 *
 */
public enum LogType {
	/**
	 * LEVEL: 4 <br>
	 * Saved for the most needed, most critical status updates, i.e. a crash or the
	 * robot doing something wrong
	 */
	CRITICAL(4),
	/**
	 * LEVEL: 3 <br>
	 * Saved for lower level warnings and updates, i.e. endgame activated, or auto
	 * ended. could also include scoring.
	 */
	WARNING(3),
	/**
	 * LEVEL: 2 <br>
	 * Saved for status updates of the robot, like commands being activated, and
	 * finished, but not more mundane things
	 */
	UPDATE(2),
	/**
	 * LEVEL: 1 <br>
	 * Saved for all motor updates, speed changes, button presses, and almost every
	 * single action taken by the robot and drivers
	 */
	DEFAULT(1);

	private int m_logLevel;

	private LogType(int logLevel) {
		m_logLevel = logLevel;
	}

	/**
	 * Gets the LogType from an integer
	 *
	 * @param logLevel The integer value of the LogType
	 * @return The LogType of the int, but if the int is {@code>4} or {@code<1} the
	 *         method returns DEFAULT
	 */
	public static LogType getLogTypeFromNumber(int logLevel) {
		switch (logLevel) {
			case 4:
				return CRITICAL;
			case 3:
				return WARNING;
			case 2:
				return UPDATE;
			default:
				return DEFAULT;
		}
	}

	/**
	 *
	 * @return The log level of the LogType
	 */
	public int getLogLevel() {
		return m_logLevel;
	}
}
