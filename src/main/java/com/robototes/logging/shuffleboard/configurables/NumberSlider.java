package com.robototes.logging.shuffleboard.configurables;

import java.util.function.Consumer;
import java.util.function.Supplier;

import com.robototes.logging.shuffleboard.configurables.abst.NumberConfig;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.WidgetType;

/**
 * A Slider Bar configuration class for shuffle board widgets
 *
 * @author Eli Orona
 *
 */
public class NumberSlider extends NumberConfig<NumberSlider> {

	/**
	 * Creates a new {@link NumberSlider}
	 *
	 * @param getter  The data supplier
	 * @param setter  The data user
	 * @param name    The name of the widget
	 * @param tabName The tab for the widget
	 */
	public NumberSlider(Supplier<Double> getter, Consumer<Double> setter, String name, String tabName) {
		super(getter, setter, name, tabName);
	}

	@Override
	public WidgetType getType() {
		return BuiltInWidgets.kNumberSlider;
	}

}