package com.robototes.math;

import com.robototes.utils.StringUtils;

/**
 *
 * @author Eli Orona
 *
 */
public class DoubleRatio implements Ratio<Double> {

	/**
	 * Ratio between the two sides
	 */
	public double ratio;

	/**
	 * label for the from type
	 */
	public String from;

	/**
	 * label for the to type
	 */
	public String to;

	/**
	 * Creates a double ratio from a conversion value
	 *
	 * @param ratio Value of the ratio
	 * @param from  From type
	 * @param to    To type
	 */
	public DoubleRatio(double ratio, String from, String to) {
		this.ratio = ratio;
		this.from = from;
		this.to = to;
	}

	/**
	 * Creates a double ratio based on two other ratios
	 *
	 * @param firstRatio  First ratio
	 * @param secondRatio Second Ratio
	 */
	public DoubleRatio(Ratio<?> firstRatio, Ratio<?> secondRatio) {
		ratio = firstRatio.getRatio() * secondRatio.getRatio();
		from = firstRatio.getFrom();
		to = secondRatio.getTo();
	}

	@Override
	public double calculateRatio(double from) {
		return from * ratio;
	}

	@Override
	public double calculateRatio(Double from) {
		return from * ratio;
	}

	@Override
	public double calculateReverseRatio(double to) {
		return 1d / ratio * to;
	}

	@Override
	public double calculateReverseRatio(Double to) {
		return 1d / ratio * to;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof DoubleRatio)) {
			return false;
		}

		DoubleRatio other = (DoubleRatio) obj;

		return MathUtils.epsilonEquals(ratio, other.ratio, MathUtils.EPSILON) && from.equals(other.getFrom())
				&& to.equals(other.getTo());
	}

	@Override
	public String getFrom() {
		return from;
	}

	@Override
	public Ratio<Double> getInverseRatio() {
		return new DoubleRatio(1d / ratio, to, from);
	}

	@Override
	public double getRatio() {
		return ratio;
	}

	@Override
	public String getTo() {
		return to;
	}

	@Override
	public String toString() {
		return StringUtils.getFormattedValue(getRatio(), 5) + getFrom() + ":" + getTo();
	}
}
