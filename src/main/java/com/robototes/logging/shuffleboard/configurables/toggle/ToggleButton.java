package com.robototes.logging.shuffleboard.configurables.toggle;

import java.util.function.Consumer;
import java.util.function.Supplier;

import com.robototes.logging.shuffleboard.configurables.abst.BooleanConfig;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.WidgetType;

public class ToggleButton extends BooleanConfig<ToggleButton> {

	public ToggleButton(Supplier<Boolean> getter, Consumer<Boolean> setter, String name, String tabName) {
		super(getter, setter, name, tabName);
	}

	@Override
	public WidgetType getType() {
		return BuiltInWidgets.kToggleButton;
	}

}
