package com.robototes.math;

/**
 * An interface for ratios, allowing for implementing classes to have more
 * control on the implementation of the ratio
 *
 * @author Eli Orona
 *
 * @param <T> The type of the ratio
 */
public interface Ratio<T> {

	/**
	 * With the ratio from:to, it calculates the to
	 *
	 * @param from left side of the ratio as a pure double value
	 * @return right side of the ratio
	 */
	public double calculateRatio(double from);

	/**
	 * With the ratio from:to, it calculates the to
	 *
	 * @param from Left side of the ratio
	 * @return The right side of the ratio
	 */
	public double calculateRatio(T from);

	/**
	 * With the ratio from:to, it calculates the from
	 *
	 * @param to right side of the ratio as a pure double value
	 * @return left side of the ratio
	 */
	public double calculateReverseRatio(double to);

	/**
	 * With the ratio from:to, it calculates the from
	 *
	 * @param to right side of the ratio
	 * @return left side of the ratio
	 */
	public double calculateReverseRatio(T to);

	/**
	 *
	 * @return The label of the from
	 */
	public String getFrom();

	/**
	 *
	 * @return The inverse of the ratio
	 */
	public Ratio<T> getInverseRatio();

	/**
	 *
	 * @return The double value of the ratio
	 */
	public double getRatio();

	/**
	 *
	 * @return label of the to
	 */
	public String getTo();
}
