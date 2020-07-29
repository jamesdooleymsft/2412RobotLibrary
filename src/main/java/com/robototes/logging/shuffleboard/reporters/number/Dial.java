package com.robototes.logging.shuffleboard.reporters.number;

import java.util.Map;
import java.util.function.Supplier;

import com.robototes.logging.shuffleboard.reporters.abst.NumberReporter;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.WidgetType;

public class Dial extends NumberReporter<Dial> {

	public Dial(Supplier<Double> getter, String name, String tabName) {
		super(getter, name, tabName);
	}

	public Dial showValue(boolean show) {
		return withProperties(Map.of("showValue", show));
	}

	@Override
	public WidgetType getType() {
		return BuiltInWidgets.kDial;
	}

}
