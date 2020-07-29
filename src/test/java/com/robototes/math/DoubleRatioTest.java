package com.robototes.math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DoubleRatioTest {

	@Test
	public void testCalculateRatio() {
		DoubleRatio one = new DoubleRatio(10, "a", "b");

		assertEquals("Calculate double ratio", one.calculateRatio(10), 100, MathUtils.EPSILON);
		assertEquals("Calculate Double ratio", one.calculateRatio(0.1), 1, MathUtils.EPSILON);
	}

	@Test
	public void testCalculateReverseRatio() {
		DoubleRatio one = new DoubleRatio(10, "a", "b");

		assertEquals("Calculate reverse double ratio", one.calculateReverseRatio(10), 1, MathUtils.EPSILON);
		assertEquals("Calculate reverse Double ratio", one.calculateReverseRatio(1), 0.1, MathUtils.EPSILON);
	}

	@Test
	public void testCombiningRatios() {
		DoubleRatio a = new DoubleRatio(5, "a", "b");
		DoubleRatio b = new DoubleRatio(3, "b", "c");

		DoubleRatio c = new DoubleRatio(15, "a", "c");

		assertEquals("Combination Ratio", new DoubleRatio(a, b), c);
	}

	@Test
	public void testGetInverseRatio() {
		DoubleRatio one = new DoubleRatio(10, "a", "b");
		DoubleRatio oneInverse = new DoubleRatio(0.1, "b", "a");

		assertEquals("Test inverse is equal", one.getInverseRatio(), oneInverse);
	}

	@Test
	public void testToString() {
		DoubleRatio one = new DoubleRatio(10, "a", "b");

		assertEquals("Test toString()", one.toString(), "10a:b");
	}

}
