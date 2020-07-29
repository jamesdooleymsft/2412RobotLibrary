package com.robototes.logging.shuffleboard.configurables.abst;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.robototes.logging.shuffleboard.AbstractValueConfigurable;

/**
 * This is a template class for all the number widgets
 *
 * @author Eli Orona
 *
 * @param <S> The type of the widget
 */
public abstract class NumberConfig<S extends NumberConfig<S>> extends AbstractValueConfigurable<Double, S> {

	/**
	 * Creates a new {@link NumberConfig}
	 *
	 * @param getter  The data supplier
	 * @param setter  The data user
	 * @param name    The name of the widget
	 * @param tabName The tab for the widget
	 */
	public NumberConfig(Supplier<Double> getter, Consumer<Double> setter, String name, String tabName) {
		super(getter, setter, name, tabName);
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

		if (value == oldValue) { // If shuffleboard has not changed
			if (value == oldValue) { // If value is the old set value
				double newValue = getter.get();
				entry.setDouble(newValue);
				oldValue = newValue;
			}
		} else if (value != Double.NaN) { // Shuffleboard has changed
			setter.accept(value);
			oldValue = value;
		}
	}

}
