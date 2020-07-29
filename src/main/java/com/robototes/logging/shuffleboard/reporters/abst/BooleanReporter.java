package com.robototes.logging.shuffleboard.reporters.abst;

import java.util.function.Supplier;

import com.robototes.logging.shuffleboard.AbstractReporter;

public abstract class BooleanReporter<S extends BooleanReporter<S>> extends AbstractReporter<Boolean, S> {

	public BooleanReporter(Supplier<Boolean> getter, String name, String tabName) {
		super(getter, name, tabName);
	}

	@Override
	public void update() {
		Boolean value = entry.getBoolean(false); // Get the value of the shuffleboard widget

		if (value == oldValue) { // if it's the same to what it was last update
			boolean newValue = getter.get(); // get the object's value (object == whatever you have the thing set to)
			entry.setBoolean(newValue); // Set the widgets value to the object's value i.e. update the widget
			oldValue = newValue;
		}
	}

}
