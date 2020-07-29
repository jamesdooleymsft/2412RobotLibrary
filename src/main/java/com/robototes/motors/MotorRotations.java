package com.robototes.motors;

import com.robototes.units.Rotations;

/**
 * An abstract class all types of motor rotations extend to allow for better
 * ratios
 *
 * @author Eli Orona
 *
 */
public abstract class MotorRotations extends Rotations {
	/**
	 * Rotations for CANSparkMax
	 *
	 * @author Eli Orona
	 *
	 */
	public static class SparkMaxRotations extends MotorRotations {

		public String mainUnit = "SProt";

		public SparkMaxRotations(double value) {
			super(value);
		}

		public SparkMaxRotations(Rotations rotations) {
			super(rotations);
		}

		@Override
		public String getUnit() {
			return "SparkMax_rot";
		}
	}

	public MotorRotations(double value) {
		super(value);
	}

	public MotorRotations(Rotations rotations) {
		super(rotations.getValue());
	}

	@Override
	public abstract String getUnit();
}
