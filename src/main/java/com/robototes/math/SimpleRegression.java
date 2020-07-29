package com.robototes.math;

/**
 * This is a class that can do "simple" regression as in given n points, it
 * makes an n-1 degree polynomial
 *
 * @author Eli Orona
 *
 */
public class SimpleRegression {

	/**
	 *
	 * @param pointOne
	 * @param pointTwo
	 * @return An equation that goes through all points
	 */
	public static Equation linearRegression(Vector pointOne, Vector pointTwo) {

		double m = (pointTwo.y - pointOne.y) / (pointTwo.x - pointOne.x);

		double b = pointTwo.y - m * pointTwo.x;

		return new Equation(b, m);
	}

	/**
	 *
	 * @param pointOne
	 * @param pointTwo
	 * @param pointThree
	 * @return An quadratic equation that goes through the three points.
	 */
	public static Equation quadraticRegression(Vector pointOne, Vector pointTwo, Vector pointThree) {
		// Lagrange polynomial
		double bottom1 = pointOne.x * pointOne.x - (pointTwo.x + pointThree.x) * pointOne.x
				+ pointTwo.x * pointThree.x;
		double bottom2 = pointTwo.x * pointTwo.x - (pointOne.x + pointThree.x) * pointTwo.x
				+ pointOne.x * pointThree.x;
		double bottom3 = pointThree.x * pointThree.x - (pointOne.x + pointTwo.x) * pointThree.x
				+ pointOne.x * pointTwo.x;

		double coeff1 = pointOne.y / bottom1;
		double coeff2 = pointTwo.y / bottom2;
		double coeff3 = pointThree.y / bottom3;

		double a = +(coeff1 + coeff2 + coeff3);
		double b = -((pointTwo.x + pointThree.x) * coeff1 + (pointOne.x + pointThree.x) * coeff2
				+ (pointOne.x + pointTwo.x) * coeff3);
		double c = +(pointTwo.x * pointThree.x * coeff1 + pointOne.x * pointThree.x * coeff2
				+ pointOne.x * pointTwo.x * coeff3);

		return new Equation(c, b, a);
	}
}
