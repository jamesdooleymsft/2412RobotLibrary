package com.robototes.logging.shuffleboard.reporters.number;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.WidgetType;

public class VoltageView extends NumberBar {

	public VoltageView(Supplier<Double> getter, String name, String tabName) {
		super(getter, name, tabName);
	}

	@Override
	public WidgetType getType() {
		return BuiltInWidgets.kVoltageView;
	}

}
