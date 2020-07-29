package com.robototes.logging.shuffleboard.reporters.abst;

import java.util.Map;
import java.util.function.Supplier;

import com.robototes.logging.shuffleboard.AbstractReporter;

/**
 * This is a template class for all the number widgets
 *
 * @author Eli Orona
 *
 * @param <S> The type of the widget
 */
public abstract class NumberReporter<S extends NumberReporter<S>> extends AbstractReporter<Double, S> {

	public NumberReporter(Supplier<Double> getter, String name, String tabName) {
		super(getter, name, tabName);
	}

	/**
	 * Sets the min and max of the widget
	 *
	 * @param min min
	 * @param max max
	 * @return this
	 */
	public S withMinMax(int min, int max) {
		if (min > max) {
			throw new IllegalArgumentException("min, " + min + ", is greater than max, " + max + "!");
		}

		return withProperties(Map.of("min", min, "max", max));
	}

	@Override
	public void update() {
		double value = entry.getDouble(Double.NaN);

		if (value == oldValue) {
			double newValue = getter.get();
			entry.setDouble(newValue);
			oldValue = newValue;
		}
	}

}
