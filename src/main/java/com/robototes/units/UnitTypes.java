package com.robototes.units;

import com.robototes.units.UsefulUnits.Voltage;

/**
 * All the unit types are housed within this class
 *
 * @author Eli Orona
 *
 */
public class UnitTypes {

	/**
	 * List of different distance units
	 *
	 * @author Eli Orona
	 *
	 */
	public static enum DistanceUnits implements IUnitType<DistanceUnits> {
		/**
		 * Meters
		 */
		METER(1, "m"),
		/**
		 * Centimeters, 100cm = 1m
		 */
		CENTIMETER(1d / 100d, METER, "cm"),
		/**
		 * Inch, 39.3700787in = 1m
		 */
		INCH(2.54d, CENTIMETER, "in"),
		/**
		 * Feet, 3.2808399ft = 1m
		 */
		FEET(12d, INCH, "ft"),
		/**
		 * Yard, 1.0936133yd = 1m
		 */
		YARD(3d, FEET, "yd"),
		/**
		 * Kilometer, 1km = 1000m
		 */
		KILOMETER(1000d, METER, "km"),
		/**
		 * Mile, 1mile = 1609.344m
		 */
		MILE(5280d, FEET, "mile"),
		/**
		 * Millimeter, 1000mm = 1m
		 */
		MILLIMETER(1d / 10d, CENTIMETER, "mm");

		private double conversionValue;
		private String unitName;

		DistanceUnits(double conversionValue, DistanceUnits extendRatio, String unitName) {
			this.conversionValue = conversionValue * extendRatio.conversionValue;
			this.unitName = unitName;
		}

		DistanceUnits(double conversionValue, String unitName) {
			this.conversionValue = conversionValue;
			this.unitName = unitName;
		}

		public double getConversionValue() {
			return conversionValue;
		}

		@Override
		public DistanceUnits getMainUnit() {
			return METER;
		}

		@Override
		public UnitRatio<Distance> getRatio() {
			return new UnitRatio<>(conversionValue, getUnit(), "m");
		}

		@Override
		public UnitRatio<Distance> getRatio(DistanceUnits other) {
			return new UnitRatio<>(getRatio(), (UnitRatio<?>) other.getRatio().getInverseRatio());
		}

		@Override
		public String getUnit() {
			return unitName;
		}

	}

	/**
	 *
	 * @author Eli Orona
	 *
	 * @param <T> The Unit type
	 */
	public interface IUnitType<T extends IUnitType<?>> {
		/**
		 *
		 * @return The main unit of the unit type
		 */
		T getMainUnit();

		/**
		 *
		 * @return the ratio from this unit to the main unit of the enum
		 */
		UnitRatio<?> getRatio();

		/**
		 *
		 * @param other The other unit
		 * @return Finds the ratio between two unitss
		 */
		UnitRatio<?> getRatio(T other);

		/**
		 *
		 * @return The label of the unit
		 */
		String getUnit();
	}

	/**
	 * List of different rotation/angle units
	 *
	 * @author Eli Orona
	 *
	 */
	public static enum RotationUnits implements IUnitType<RotationUnits> {
		/**
		 * Rotations
		 */
		ROTATION(1, "rot"),
		/**
		 * Degrees, 360deg = 1rot
		 */
		DEGREE(1d / 360d, ROTATION, "deg"),
		/**
		 * Radians, 2pi rad = 1 rot
		 */
		RADIAN(1d / (2d * Math.PI), ROTATION, "rad");

		private double conversionValue;
		private String unitName;

		RotationUnits(double conversionValue, RotationUnits extendRatio, String unitName) {
			this.conversionValue = conversionValue * extendRatio.conversionValue;
			this.unitName = unitName;
		}

		RotationUnits(double conversionValue, String unitName) {
			this.conversionValue = conversionValue;
			this.unitName = unitName;
		}

		public double getConversionValue() {
			return conversionValue;
		}

		@Override
		public RotationUnits getMainUnit() {
			return ROTATION;
		}

		@Override
		public UnitRatio<Rotations> getRatio() {
			return new UnitRatio<>(conversionValue, getUnit(), "rot");
		}

		@Override
		public UnitRatio<Rotations> getRatio(RotationUnits other) {
			return new UnitRatio<>(getRatio(), (UnitRatio<?>) other.getRatio().getInverseRatio());
		}

		@Override
		public String getUnit() {
			return unitName;
		}
	}

	/**
	 * List of different time units
	 *
	 * @author Eli Orona
	 *
	 */
	public static enum TimeUnits implements IUnitType<TimeUnits> {
		/**
		 * Seconds
		 */
		SECOND(1, "s"),
		/**
		 * Milliseconds, 1000ms = 1s
		 */
		MILLISECOND(1d / 1000d, SECOND, "ms"),
		/**
		 * Minutes, 1min = 60 sec
		 */
		MINUTE(60d, SECOND, "min"),
		/**
		 * Hours, 1hr = 3600 sec
		 */
		HOUR(60d, MINUTE, "hr"),
		/**
		 * Days, 1 day = 86400 sec
		 */
		DAY(24d, HOUR, "day");

		private double conversionValue;
		private String unitName;

		TimeUnits(double conversionValue, String unitName) {
			this.conversionValue = conversionValue;
			this.unitName = unitName;
		}

		TimeUnits(double conversionValue, TimeUnits extendRatio, String unitName) {
			this.conversionValue = conversionValue * extendRatio.conversionValue;
			this.unitName = unitName;
		}

		public double getConversionValue() {
			return conversionValue;
		}

		@Override
		public TimeUnits getMainUnit() {
			return SECOND;
		}

		@Override
		public UnitRatio<Time> getRatio() {
			return new UnitRatio<>(conversionValue, getUnit(), "s");
		}

		@Override
		public UnitRatio<Time> getRatio(TimeUnits other) {
			return new UnitRatio<>(getRatio(), (UnitRatio<?>) other.getRatio().getInverseRatio());
		}

		@Override
		public String getUnit() {
			return unitName;
		}

	}

	/**
	 * List of different voltage units
	 *
	 * @author Eli Orona
	 *
	 */
	public static enum VoltageUnits implements IUnitType<VoltageUnits> {
		/**
		 * Volts
		 */
		VOLTS(1, "V"),
		/**
		 * Millivolts, 1000mV = 1V
		 */
		MILLIVOLTS(1d / 1000d, VOLTS, "mV"),
		/**
		 * Kilovolts, 1000kV = 1V
		 */
		KILOVOLTS(1000d, VOLTS, "kV");

		private double conversionValue;
		private String unitName;

		VoltageUnits(double conversionValue, String unitName) {
			this.conversionValue = conversionValue;
			this.unitName = unitName;
		}

		VoltageUnits(double conversionValue, VoltageUnits extendRatio, String unitName) {
			this.conversionValue = conversionValue * extendRatio.conversionValue;
			this.unitName = unitName;
		}

		public double getConversionValue() {
			return conversionValue;
		}

		@Override
		public VoltageUnits getMainUnit() {
			return VOLTS;
		}

		@Override
		public UnitRatio<Voltage> getRatio() {
			return new UnitRatio<>(conversionValue, getUnit(), "V");
		}

		@Override
		public UnitRatio<Voltage> getRatio(VoltageUnits other) {
			return new UnitRatio<>(getRatio(), (UnitRatio<?>) other.getRatio().getInverseRatio());
		}

		@Override
		public String getUnit() {
			return unitName;
		}
	}

}
