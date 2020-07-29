package com.robototes.logging.shuffleboard.configurables.abst;

import java.util.function.Consumer;

import com.robototes.logging.shuffleboard.AbstractValueConfigurable;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public abstract class ChooserConfig<T, S extends ChooserConfig<T, S>>
		extends AbstractValueConfigurable<SendableChooser<T>, S> {

	protected T oldValue;
	protected SendableChooser<T> chooser;
	protected Consumer<T> setter;

	public ChooserConfig(SendableChooser<T> sendableChooser, Consumer<T> setter, String name, String tabName) {
		super(() -> sendableChooser, null, name, tabName);
		chooser = sendableChooser;
		this.setter = setter;
	}

	@Override
	public void update() {
		T value = chooser.getSelected();

		if (value != oldValue) {
			setter.accept(value);
			oldValue = value;
		}
	}
}
