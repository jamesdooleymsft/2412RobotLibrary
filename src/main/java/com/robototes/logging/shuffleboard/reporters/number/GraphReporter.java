package com.robototes.logging.shuffleboard.reporters.number;

import java.util.function.Supplier;

import com.robototes.logging.shuffleboard.AbstractReporter;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.WidgetType;

public class GraphReporter extends AbstractReporter<Number[], GraphReporter> {

	public GraphReporter(Supplier<Number[]> getter, String name, String tabName) {
		super(getter, name, tabName);
	}

	@Override
	public WidgetType getType() {
		return BuiltInWidgets.kGraph;
	}

	@Override
	public void update() {
		entry.forceSetNumberArray(getter.get());
	}

}
