package com.robototes.logging.shuffleboard.reporters.accelerometer;

import com.robototes.logging.shuffleboard.AbstractReporter;

import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.WidgetType;

public class AccelerometerReporter extends AbstractReporter<Accelerometer, AccelerometerReporter> {

	public AccelerometerReporter(Accelerometer accelerometer, String name, String tabName) {
		super(() -> accelerometer, name, tabName);
	}

	@Override
	public WidgetType getType() {
		return BuiltInWidgets.kAccelerometer;
	}

	@Override
	public void update() {
	}

}
