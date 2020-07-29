package com.robototes.logging.shuffleboard.reporters.hardware;

import com.robototes.logging.shuffleboard.AbstractReporter;

import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.WidgetType;

public class GyroReporter extends AbstractReporter<Gyro, GyroReporter> {

	public GyroReporter(Gyro controller, String name, String tabName) {
		super(() -> controller, name, tabName);
	}

	@Override
	public WidgetType getType() {
		return BuiltInWidgets.kGyro;
	}

	@Override
	public void update() {
	}

}
