package com.robototes.logging.shuffleboard.reporters.number;

import java.util.Map;
import java.util.function.Supplier;

import com.robototes.logging.shuffleboard.reporters.abst.NumberReporter;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.WidgetType;

public class NumberBar extends NumberReporter<NumberBar> {

	public NumberBar(Supplier<Double> getter, String name, String tabName) {
		super(getter, name, tabName);
	}

	public NumberBar withCenter(double center) {
		return withProperties(Map.of("center", center));
	}

	@Override
	public WidgetType getType() {
		return BuiltInWidgets.kNumberBar;
	}

}
