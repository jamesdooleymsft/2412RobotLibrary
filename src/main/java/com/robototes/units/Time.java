package com.robototes.units;

import com.robototes.math.MathUtils;
import com.robototes.units.UnitTypes.IUnitType;
import com.robototes.units.UnitTypes.TimeUnits;
import com.robototes.utils.StringUtils;

/**
 * A representation of time in the program
 *
 * @author Eli Orona
 *
 */
public class Time implements IUnit<Time> {

	/**
	 * The main unit for time
	 */
	public static TimeUnits mainUnit = TimeUnits.SECOND;

	/**
	 * The time unit
	 */
	public double time;

	/**
	 *
	 * @param value Creates a Time with a number of seconds
	 */
	public Time(double value) {
		time = value;
	}

	/**
	 * Creates time with a given unit
	 *
	 * @param value    The value of the time
	 * @param unitType the type of time
	 */
	public Time(double value, TimeUnits unitType) {
		this(unitType.getRatio().calculateRatio(value));
	}

	@Override
	public Time add(Time other) {
		return new Time(time + other.time);
	}

	@Override
	public <K extends IUnitType<K>> double convertTo(K unitType) {
		return unitType.getRatio().calculateReverseRatio(time);
	}

	@Override
	public Time divide(Time other) {
		return new Time(time / other.time);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Time)) {
			return false;
		}
		return equals((Time) obj);
	}

	public boolean equals(Time other) {
		return MathUtils.epsilonEquals(getValue(), other.getValue(), 0.00001);
		// Epsilion is too big with conversion values
	}

	@Override
	public String getUnit() {
		return mainUnit.getUnit();
	}

	@Override
	public double getValue() {
		return time;
	}

	@Override
	public Time multiply(Time other) {
		return new Time(time * other.time);

	}

	@Override
	public Time subtract(Time other) {
		return new Time(time - other.time);
	}

	@Override
	public String toString() {
		return StringUtils.getFormattedValue(getValue(), 4) + getUnit();
	}

}
