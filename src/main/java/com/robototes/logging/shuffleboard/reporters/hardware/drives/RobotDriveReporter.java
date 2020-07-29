package com.robototes.logging.shuffleboard.reporters.hardware.drives;

import java.util.Map;
import java.util.function.Supplier;

import com.robototes.logging.shuffleboard.AbstractReporter;

import edu.wpi.first.wpilibj.drive.RobotDriveBase;

public abstract class RobotDriveReporter<T extends RobotDriveBase, S extends RobotDriveReporter<T, S>>
		extends AbstractReporter<T, S> {

	public RobotDriveReporter(Supplier<T> getter, String name, String tabName) {
		super(getter, name, tabName);
	}

	public S showVectors(boolean show) {
		return withProperties(Map.of("showVectors", show));
	}

	@Override
	public void update() {

	}

}
