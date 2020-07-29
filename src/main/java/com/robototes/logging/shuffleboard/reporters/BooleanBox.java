package com.robototes.logging.shuffleboard.reporters;

import java.util.Map;
import java.util.function.Supplier;

import com.robototes.logging.shuffleboard.reporters.abst.BooleanReporter;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.WidgetType;

public class BooleanBox extends BooleanReporter<BooleanBox> {

	public BooleanBox(Supplier<Boolean> getter, String name, String tabName) {
		super(getter, name, tabName);
	}

	@Override
	public WidgetType getType() {
		return BuiltInWidgets.kBooleanBox;
	}

	public BooleanBox withColors(String falseColor, String trueColor) {
		return withProperties(Map.of("colorWhenFalse", falseColor, "colorWhenTrue", trueColor));
	}

}
