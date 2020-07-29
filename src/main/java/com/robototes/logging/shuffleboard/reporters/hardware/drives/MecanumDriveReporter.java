package com.robototes.logging.shuffleboard.reporters.hardware.drives;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.WidgetType;

public class MecanumDriveReporter extends RobotDriveReporter<MecanumDrive, MecanumDriveReporter> {

	public MecanumDriveReporter(MecanumDrive drive, String name, String tabName) {
		super(() -> drive, name, tabName);
	}

	@Override
	public WidgetType getType() {
		return BuiltInWidgets.kMecanumDrive;
	}

}
