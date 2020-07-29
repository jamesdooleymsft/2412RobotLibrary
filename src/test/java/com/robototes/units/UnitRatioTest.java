package com.robototes.units;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.robototes.math.MathUtils;
import com.robototes.units.UnitTypes.DistanceUnits;

public class UnitRatioTest {

	UnitRatio<Distance> cmToMeter = new UnitRatio<>(1d / 100d, DistanceUnits.CENTIMETER, DistanceUnits.METER);

	@Test
	public void testCalculateRatio() {
		assertEquals("Double ratio calculation", cmToMeter.calculateRatio(5), 0.05, MathUtils.EPSILON);
		assertEquals("Unit ratio calculation", cmToMeter.calculateRatio(new Distance(5)), 0.05, MathUtils.EPSILON);
	}

	@Test
	public void testCalculateReverseRatio() {
		assertEquals("Double reverse ratio calculation", cmToMeter.calculateReverseRatio(5), 500, MathUtils.EPSILON);
		assertEquals("Unit reverse ratio calculation", cmToMeter.calculateReverseRatio(new Distance(5)), 500,
				MathUtils.EPSILON);
	}

	@Test
	public void testGetInverseRatio() {
		UnitRatio<Distance> meterToCm = new UnitRatio<>(100d, DistanceUnits.METER, DistanceUnits.CENTIMETER);
		assertEquals("Inverse Ratio", meterToCm, cmToMeter.getInverseRatio());
	}

	@Test
	public void testToString() {
		assertEquals("toString", cmToMeter.toString(), "100cm:1m");

	}

	@Test
	public void testUnitRatio() {
		assertEquals("Check ratio is correct", cmToMeter.getRatio(), 0.01, MathUtils.EPSILON);
		assertEquals("Check to is correct", cmToMeter.getTo(), DistanceUnits.METER.getUnit());
		assertEquals("Check from is correct", cmToMeter.getFrom(), DistanceUnits.CENTIMETER.getUnit());
	}

	@Test
	public void testUnitRatioFromTwoRatios() {
		UnitRatio<Distance> mmToCm = new UnitRatio<>(1d / 10d, DistanceUnits.MILLIMETER,
				DistanceUnits.CENTIMETER);
		UnitRatio<Distance> mmToMeter = new UnitRatio<>(1d / 1000d, DistanceUnits.MILLIMETER,
				DistanceUnits.METER);

		assertEquals("Combo ratio is correct", mmToMeter, new UnitRatio<Distance>(mmToCm, cmToMeter));

	}

}
