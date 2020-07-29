package com.robototes.logging.shuffleboard.configurables.abst;

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
public abstract class BooleanConfig<S extends BooleanConfig<S>> extends AbstractValueConfigurable<Boolean, S> {

	/**
	 * Creates a new {@link BooleanConfig}
	 *
	 * @param getter  The data supplier
	 * @param setter  The data user
	 * @param name    The name of the widget
	 * @param tabName The tab for the widget
	 */
	public BooleanConfig(Supplier<Boolean> getter, Consumer<Boolean> setter, String name, String tabName) {
		super(getter, setter, name, tabName);
	}

	@Override
	public void update() {
		boolean value = entry.getBoolean(oldValue);

		if (value == oldValue) { // If shuffleboard has not changed
			boolean newValue = getter.get();
			entry.setBoolean(newValue);
			oldValue = newValue;
		} else {
			setter.accept(value);
			oldValue = value;
		}
	}

}
