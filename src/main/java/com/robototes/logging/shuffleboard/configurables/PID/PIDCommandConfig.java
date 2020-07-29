package com.robototes.logging.shuffleboard.configurables.PID;

import com.robototes.logging.shuffleboard.AbstractReporter;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.WidgetType;
import edu.wpi.first.wpilibj2.command.PIDCommand;

public class PIDCommandConfig extends AbstractReporter<PIDCommand, PIDCommandConfig> {

	public PIDCommandConfig(PIDCommand command, String name, String tabName) {
		super(() -> command, name, tabName);
	}

	@Override
	public WidgetType getType() {
		return BuiltInWidgets.kPIDCommand;
	}

	@Override
	public void update() {
	}

}
