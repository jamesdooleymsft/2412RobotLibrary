package com.robototes.logging.shuffleboard.configurables.chooser;

import java.util.function.Consumer;

import com.robototes.logging.shuffleboard.configurables.abst.ChooserConfig;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.WidgetType;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class ComboBoxChooser<T> extends ChooserConfig<T, ComboBoxChooser<T>> {

	public ComboBoxChooser(SendableChooser<T> sendableChooser, Consumer<T> setter, String name, String tabName) {
		super(sendableChooser, setter, name, tabName);
	}

	@Override
	public WidgetType getType() {
		return BuiltInWidgets.kComboBoxChooser;
	}

}
