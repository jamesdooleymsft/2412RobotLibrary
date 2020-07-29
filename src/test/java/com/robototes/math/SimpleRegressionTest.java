package com.robototes.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleRegressionTest {

	@Test
	public void testLinearRegression() {
		Vector a = new Vector(0, 0);
		Vector b = new Vector(1, 1);

		assertEquals("Linear Regression", new Equation(0, 1), SimpleRegression.linearRegression(a, b));
	}

	@Test
	public void testQuadraticRegression() {
		Vector a = new Vector(0, 0);
		Vector b = new Vector(1, 1);
		Vector c = new Vector(2, 4);

		assertEquals("Quadratic Regression", new Equation(0, 0, 1), SimpleRegression.quadraticRegression(a, b, c));
	}

}
