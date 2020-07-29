package com.robototes.logging.shuffleboard.reporters.hardware;

import com.robototes.logging.shuffleboard.AbstractReporter;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.WidgetType;

public class SpeedControllerReporter extends AbstractReporter<SpeedController, SpeedControllerReporter> {

	public SpeedControllerReporter(SpeedController controller, String name, String tabName) {
		super(() -> controller, name, tabName);
	}

	@Override
	public WidgetType getType() {
		return BuiltInWidgets.kSpeedController;
	}

	@Override
	public void update() {
	}

}
