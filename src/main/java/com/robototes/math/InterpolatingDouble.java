package com.robototes.math;

/**
 *
 * @author Eli Orona
 *
 */
public class InterpolatingDouble implements Interpolable<InterpolatingDouble>, InverseInterpolable<InterpolatingDouble>,
		Comparable<InterpolatingDouble>, Operable<InterpolatingDouble> {
	/**
	 * Value of the InterpolatingDouble instance
	 */
	private Double value;

	/**
	 * Creates an InterpolatingDouble with a value
	 *
	 * @param value value for the InterpolatingDoubles
	 */
	public InterpolatingDouble(Double value) {
		this.value = value;
	}

	@Override
	public InterpolatingDouble add(InterpolatingDouble other) {
		return new InterpolatingDouble(value + other.value);
	}

	@Override
	public int compareTo(InterpolatingDouble other) {
		return Double.compare(value, other.value);
	}

	@Override
	public InterpolatingDouble divide(InterpolatingDouble other) {
		return new InterpolatingDouble(value / other.value);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof InterpolatingDouble)) {
			return false;
		}

		return MathUtils.epsilonEquals(value, ((InterpolatingDouble) obj).value, MathUtils.EPSILON);
	}

	@Override
	public InterpolatingDouble interpolate(InterpolatingDouble other, double percent) {
		double delta = other.value - value;
		return new InterpolatingDouble(value + delta * percent);
	}

	@Override
	public double inverseInterpolate(InterpolatingDouble upper, InterpolatingDouble query) {
		double delta = upper.value - value;
		double deltaQuery = query.value - value;

		return deltaQuery / delta;
	}

	@Override
	public InterpolatingDouble multiply(InterpolatingDouble other) {
		return new InterpolatingDouble(value * other.value);
	}

	@Override
	public InterpolatingDouble subtract(InterpolatingDouble other) {
		return new InterpolatingDouble(value - other.value);
	}

	public Double value() {
		return this.value;
	}
}
