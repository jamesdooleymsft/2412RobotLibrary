package com.robototes.units;

import com.robototes.math.MathUtils;
import com.robototes.units.UnitTypes.DistanceUnits;
import com.robototes.units.UnitTypes.IUnitType;
import com.robototes.utils.StringUtils;

/**
 * A representation of distance in the program. Default unit is the meter.
 *
 * @author Eli Orona
 *
 */
public class Distance implements IUnit<Distance> {

	/**
	 * the main unit
	 */
	public static DistanceUnits mainUnit = DistanceUnits.METER;
	/**
	 * distance of the unit
	 */
	public double distance;

	/**
	 * Creates a distance with a meter value
	 *
	 * @param value the length of the meter distance
	 */
	public Distance(double value) {
		distance = value;
	}

	/**
	 * Creates a distance with any unit
	 *
	 * @param value    length of the unit
	 * @param unitType type of the unit
	 */
	public Distance(double value, DistanceUnits unitType) {
		this(unitType.getRatio().calculateRatio(value));
	}

	@Override
	public Distance add(Distance other) {
		return new Distance(distance + other.distance);
	}

	@Override
	public <K extends IUnitType<K>> double convertTo(K unitType) {
		return unitType.getRatio().calculateReverseRatio(distance);
	}

	@Override
	public Distance divide(Distance other) {
		return new Distance(distance / other.distance);
	}

	public boolean equals(Distance other) {
		return MathUtils.epsilonEquals(distance, other.distance, 0.00001); // Epsilion is too big with conversion values
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Distance)) {
			return false;
		}
		return equals((Distance) obj);
	}

	@Override
	public String getUnit() {
		return mainUnit.getUnit();
	}

	@Override
	public double getValue() {
		return distance;
	}

	@Override
	public Distance multiply(Distance other) {
		return new Distance(distance * other.distance);
	}

	@Override
	public Distance subtract(Distance other) {
		return new Distance(distance - other.distance);
	}

	@Override
	public String toString() {
		return StringUtils.getFormattedValue(getValue(), 4) + getUnit();
	}
}
