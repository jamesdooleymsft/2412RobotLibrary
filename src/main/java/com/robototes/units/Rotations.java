package com.robototes.units;

import com.robototes.math.MathUtils;
import com.robototes.units.UnitTypes.IUnitType;
import com.robototes.units.UnitTypes.RotationUnits;
import com.robototes.utils.StringUtils;

/**
 * A representation of rotations in the program
 *
 * @author Eli Orona
 *
 */
public class Rotations implements IUnit<Rotations> {

	/**
	 * The main rotation unit
	 */
	public static RotationUnits mainUnit = RotationUnits.ROTATION;

	/**
	 * The number of rotations
	 */
	public double rotations;

	/**
	 *
	 * @param value Creates a Rotation with a number of rotations
	 */
	public Rotations(double value) {
		rotations = value;
	}

	/**
	 * Creates a Rotation with a given type
	 *
	 * @param value    Value for the type
	 * @param unitType the type of rotation unit
	 */
	public Rotations(double value, RotationUnits unitType) {
		this(unitType.getRatio().calculateRatio(value));
	}

	@Override
	public Rotations add(Rotations other) {
		return new Rotations(rotations + other.rotations);
	}

	@Override
	public <K extends IUnitType<K>> double convertTo(K unitType) {
		return unitType.getRatio().calculateReverseRatio(rotations);
	}

	@Override
	public Rotations divide(Rotations other) {
		return new Rotations(rotations / other.rotations);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Rotations)) {
			return false;
		}
		return equals((Rotations) obj);
	}

	public boolean equals(Rotations other) {
		return MathUtils.epsilonEquals(getValue(), other.getValue(), 0.00001);
		// Epsilion is too big with conversion values
	}

	@Override
	public String getUnit() {
		return mainUnit.getUnit();
	}

	@Override
	public double getValue() {
		return rotations;
	}

	@Override
	public Rotations multiply(Rotations other) {
		return new Rotations(rotations * other.rotations);

	}

	@Override
	public Rotations subtract(Rotations other) {
		return new Rotations(rotations - other.rotations);
	}

	@Override
	public String toString() {
		return StringUtils.getFormattedValue(getValue(), 4) + getUnit();
	}
}
