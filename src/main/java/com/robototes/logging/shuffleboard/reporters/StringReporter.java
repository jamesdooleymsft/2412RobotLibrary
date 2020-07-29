package com.robototes.logging.shuffleboard.reporters;

import com.robototes.logging.shuffleboard.AbstractReporter;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.WidgetType;

public class StringReporter extends AbstractReporter<String, StringReporter> {

	public StringReporter(Object object, String name, String tabName) {
		super(object::toString, name, tabName);
	}

	@Override
	public WidgetType getType() {
		return BuiltInWidgets.kTextView;
	}

	@Override
	public void update() {
		String value = getter.get();

		if (value != oldValue) {
			entry.setString(value);
			oldValue = value;
		}
	}
}
