package com.robototes.math;

import static java.lang.Math.atan2;

/**
 * A vector for the program, can be a point or a heading and magnitude
 *
 * @author Eli Orona
 *
 */
public class Vector {

	/**
	 * x value of the Vector
	 */
	public double x;

	/**
	 * y value of the Vector
	 */
	public double y;

	/**
	 * length of the Vector
	 */
	public double length;

	/**
	 * angle of the Vector in radians, (1,0) is 0 radians
	 */
	public double angle;

	/**
	 * Constructs a vector with all values at 0
	 */
	public Vector() {
		x = 0;
		y = 0;
		length = 0;
		angle = 0;
	}

	/**
	 * Constructs a vector with length one and a given angle
	 *
	 * @param angle angle of the vector in radians
	 */
	public Vector(double angle) {
		this.angle = angle;
		length = 1;

		x = Math.cos(angle);
		y = Math.sin(angle);
	}

	/**
	 * Constructs a vector with x and y values
	 *
	 * @param x x value of the vector
	 * @param y y value of the vector
	 */
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;

		length = MathUtils.distance(x, y);
		angle = atan2(y, x);
	}

	/**
	 * Adds x and y to the vector, returning a new vector
	 *
	 * @param x x value to add
	 * @param y y value to add
	 * @return a new Vector added with the x and y values
	 */
	public Vector add(double x, double y) {
		return new Vector(this.x + x, this.y + y);
	}

	/**
	 * Adds two vectors
	 *
	 * @param other The vector to add
	 * @return The sum of the two vectors
	 */
	public Vector add(Vector other) {
		return add(other.x, other.y);
	}

	/**
	 * Finds the angle between two vectors
	 *
	 * @param other Vector to find the angle between
	 * @return A radian value for the angle between two vectors
	 */
	public double angleBetween(Vector other) {
		return atan2(other.y, other.x) - atan2(y, x);
	}

	/**
	 * Scales a vector through division
	 *
	 * @param scale The value to divide the vector by
	 * @return The vector after being divided
	 */
	public Vector divide(double scale) {
		x /= scale;
		y /= scale;
		length /= scale;
		return this;
	}

	/**
	 * The dot product of two vectors
	 *
	 * @param other The vector to calculated the dot product with
	 * @return A double representing the dot product
	 */
	public double dot(Vector other) {
		return x * other.x + y * other.y;
	}

	@Override
	public boolean equals(Object other) {

		if (!(other instanceof Vector)) {
			return false;
		}

		return equals((Vector) other, MathUtils.EPSILON);
	}

	public boolean equals(Vector other, double epsilon) {
		return MathUtils.epsilonEquals(x, other.x, epsilon) && MathUtils.epsilonEquals(y, other.y, epsilon);
	}

	/**
	 * Scales a vector through multiplication
	 *
	 * @param scale The value to multiply the vector by
	 * @return The vector after being multiplied
	 */
	public Vector multiply(double scale) {
		x *= scale;
		y *= scale;
		length *= scale;
		return this;
	}

	/**
	 * Subtracts x and y values
	 *
	 * @param x x value to subtract
	 * @param y y value to subtract
	 * @return a new Vector subtracted with the x and y values
	 */
	public Vector sub(double x, double y) {
		return new Vector(this.x - x, this.y - y);
	}

	/**
	 * Subtracts two vectors
	 *
	 * @param other The vector to subtract
	 * @return The difference of two vectors
	 */
	public Vector sub(Vector other) {
		return sub(other.x, other.y);
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

}
