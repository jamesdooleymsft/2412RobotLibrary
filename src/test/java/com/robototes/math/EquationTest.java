package com.robototes.math;

import static org.junit.Assert.*;

import org.junit.Test;

import com.robototes.math.MathUtils.MathFunction;

public class EquationTest {

	@Test
	public void testCalculate() {
		Equation equation = new Equation(0, 0, 1); // y = x^2
		double x = 3;
		assertEquals("Simple equation has correct value", x * x, equation.calculate(x), MathUtils.EPSILON);
	}

	@Test
	public void testToFunction() {
		Equation equation = new Equation(0, 0, 1); // y = x^2
		MathFunction function = equation.toMathFunction();

		double x = 3;
		assertEquals("Function returns the same value as equation", equation.calculate(x), function.compute(x),
				MathUtils.EPSILON);
	}
}
