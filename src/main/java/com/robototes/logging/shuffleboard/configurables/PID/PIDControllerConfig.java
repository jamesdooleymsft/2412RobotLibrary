package com.robototes.logging.shuffleboard.configurables.PID;

import com.robototes.logging.shuffleboard.AbstractReporter;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.WidgetType;

public class PIDControllerConfig extends AbstractReporter<PIDController, PIDControllerConfig> {

	public PIDControllerConfig(PIDController controller, String name, String tabName) {
		super(() -> controller, name, tabName);
	}

	@Override
	public WidgetType getType() {
		return BuiltInWidgets.kPIDController;
	}

	@Override
	public void update() {
	}

}
