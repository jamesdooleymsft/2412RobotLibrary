package com.robototes.logging.shuffleboard.reporters.hardware.drives;

import java.util.Map;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.WidgetType;

public class DifferentialDriveReporter extends RobotDriveReporter<DifferentialDrive, DifferentialDriveReporter> {

	public DifferentialDriveReporter(DifferentialDrive drive, String name, String tabName) {
		super(() -> drive, name, tabName);
	}

	public DifferentialDriveReporter withWheels(int wheels) {
		if (wheels < 0) {
			throw new IllegalArgumentException("Wheels cannot be negative");
		}
		return withProperties(Map.of("numberOfWheels", wheels));
	}

	public DifferentialDriveReporter withWheelDiameter(int wheels) {
		return withProperties(Map.of("wheelDiameter", wheels));
	}

	@Override
	public WidgetType getType() {
		return BuiltInWidgets.kDifferentialDrive;
	}

}
