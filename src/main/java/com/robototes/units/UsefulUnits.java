package com.robototes.units;

import com.robototes.math.MathUtils;
import com.robototes.units.UnitTypes.IUnitType;
import com.robototes.units.UnitTypes.VoltageUnits;
import com.robototes.utils.StringUtils;

public class UsefulUnits {
	/**
	 * Representation of volts in the program
	 *
	 * @author Eli Orona
	 *
	 */
	public static class Voltage implements IUnit<Voltage> {

		/**
		 * the main unit
		 */
		public static VoltageUnits mainUnit = VoltageUnits.VOLTS;
		/**
		 * voltage of the unit
		 */
		public double voltage;

		/**
		 * Creates a voltage with a volt value
		 *
		 * @param value the voltage
		 */
		public Voltage(double value) {
			voltage = value;
		}

		/**
		 * Creates a voltage with any unit
		 *
		 * @param value    volts of the unit
		 * @param unitType type of the unit
		 */
		public Voltage(double value, VoltageUnits unitType) {
			this(unitType.getRatio().calculateRatio(value));
		}

		@Override
		public Voltage add(Voltage other) {
			return new Voltage(voltage + other.voltage);
		}

		@Override
		public <K extends IUnitType<K>> double convertTo(K unitType) {
			return unitType.getRatio().calculateReverseRatio(this);
		}

		@Override
		public Voltage divide(Voltage other) {
			return new Voltage(voltage / other.voltage);
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Voltage)) {
				return false;
			}
			return equals((Voltage) obj);
		}

		public boolean equals(Voltage other) {
			return MathUtils.epsilonEquals(getValue(), other.getValue(), 0.00001);
			// Epsilion is too big with conversion values
		}

		@Override
		public String getUnit() {
			return mainUnit.getUnit();
		}

		@Override
		public double getValue() {
			return voltage;
		}

		@Override
		public Voltage multiply(Voltage other) {
			return new Voltage(voltage * other.voltage);
		}

		@Override
		public Voltage subtract(Voltage other) {
			return new Voltage(voltage - other.voltage);
		}

		@Override
		public String toString() {
			return StringUtils.getFormattedValue(getValue(), 4) + getUnit();
		}
	}
}
