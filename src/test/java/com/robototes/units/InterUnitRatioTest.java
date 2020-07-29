package com.robototes.units;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.robototes.math.MathUtils;
import com.robototes.units.UnitTypes.DistanceUnits;
import com.robototes.units.UnitTypes.RotationUnits;
import com.robototes.units.UnitTypes.TimeUnits;

public class InterUnitRatioTest {

	@Test
	public void testCalculateRatio() {
		InterUnitRatio<DistanceUnits, RotationUnits> inchToRotation = new InterUnitRatio<>(
				DistanceUnits.INCH, 10, RotationUnits.ROTATION);

		assertEquals("Double ratio calculation", inchToRotation.calculateRatio(5), 50, MathUtils.EPSILON);
		assertEquals("Unit ratio calculation", inchToRotation.calculateRatio(new Distance(5, DistanceUnits.INCH)), 50,
				MathUtils.EPSILON);
	}

	@Test
	public void testCalculateReverseRatio() {
		InterUnitRatio<DistanceUnits, RotationUnits> inchToRotation = new InterUnitRatio<>(
				DistanceUnits.INCH, 10, RotationUnits.ROTATION);

		assertEquals("Double reverse ratio calculation", inchToRotation.calculateReverseRatio(5), 0.5,
				MathUtils.EPSILON);
		assertEquals("Unit reverse ratio calculation",
				inchToRotation.calculateReverseRatio(new Rotations(5, RotationUnits.ROTATION)), 0.5, MathUtils.EPSILON);
	}

	@Test
	public void testGetInverseRatio() {
		InterUnitRatio<DistanceUnits, RotationUnits> inchToRotation = new InterUnitRatio<>(
				DistanceUnits.INCH, 10, RotationUnits.ROTATION);

		InterUnitRatio<RotationUnits, DistanceUnits> rotationToInch = new InterUnitRatio<>(
				RotationUnits.ROTATION, 0.1, DistanceUnits.INCH);

		assertEquals("Inverse ratio", inchToRotation.getInverseRatio(), rotationToInch);
	}

	@Test
	public void testInterUnitRatio() {
		InterUnitRatio<DistanceUnits, RotationUnits> ratio = new InterUnitRatio<>(
				DistanceUnits.INCH, 10, RotationUnits.ROTATION);
		assertEquals("Check ratio is correct", ratio.getRatio(), 10, MathUtils.EPSILON);
		assertEquals("Check to is correct", ratio.getTo(), RotationUnits.ROTATION.getUnit());
		assertEquals("Check from is correct", ratio.getFrom(), DistanceUnits.INCH.getUnit());
	}

	@Test
	public void testInterUnitRatioFromTwoRatios() {
		InterUnitRatio<DistanceUnits, RotationUnits> inchToRotation = new InterUnitRatio<>(
				DistanceUnits.INCH, 10, RotationUnits.ROTATION);

		InterUnitRatio<RotationUnits, TimeUnits> rotationToSeconds = new InterUnitRatio<>(
				RotationUnits.ROTATION, 0.5, TimeUnits.SECOND);

		InterUnitRatio<DistanceUnits, TimeUnits> inchToSeconds = new InterUnitRatio<>(
				inchToRotation, rotationToSeconds);

		InterUnitRatio<DistanceUnits, TimeUnits> inchToSecondsManual = new InterUnitRatio<>(
				DistanceUnits.INCH, 5, TimeUnits.SECOND);

		assertEquals("Ratios are the same", inchToSeconds, inchToSecondsManual);
	}

	@Test
	public void testToString() {
		InterUnitRatio<DistanceUnits, RotationUnits> inchToRotation = new InterUnitRatio<>(
				DistanceUnits.INCH, 10, RotationUnits.ROTATION);

		assertEquals("toString", inchToRotation.toString(), "10in:1rot");
	}

}
