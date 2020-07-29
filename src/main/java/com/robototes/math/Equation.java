package com.robototes.math;

import com.robototes.math.MathUtils.MathFunction;

/**
 * This is a class that represents an <code>y =</code> equation with
 * <code>x</code>. This is useful for regression algorithms and functions.
 *
 * @author Eli Orona
 *
 */
public class Equation {
	private double[] terms;

	/**
	 *
	 * @param terms the terms for the equation, currently only doubles are
	 *              supported. terms go from x^0 to x^n.
	 */
	public Equation(double... terms) {
		this.terms = terms;
	}

	/**
	 *
	 * @param x The x value of the graph
	 * @return The y value of the function at point x
	 */
	public double calculate(double x) {

		double t = 1;
		double y = 0;

		for (double term : terms) {
			y += term * t;
			t *= x;
		}

		return y;
	}

	/**
	 *
	 * @return The terms of the equation going from x^0 to x^n
	 */
	public double[] getTerms() {
		return terms;
	}

	@Override
	public String toString() {
		String equation = "";
		int i = 0;
		for (double term : terms) {
			equation = term + (i++ != 0 ? "x^" + (i - 1) + " + " : "") + equation;
		}

		return "y = " + equation;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Equation)) {
			return false;
		}
		Equation other = (Equation) o;

		if (other.terms.length != terms.length) {
			return false;
		}

		for (int i = 0; i < terms.length; i++) {
			if (!MathUtils.epsilonEquals(terms[i], other.terms[i], MathUtils.EPSILON)) {
				return false;
			}
		}
		return true;
	}

	public MathFunction toMathFunction() {
		return x -> calculate(x);
	}
}
