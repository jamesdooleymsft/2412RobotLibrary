package com.robototes.logging.shuffleboard.reporters.hardware;

import com.robototes.logging.shuffleboard.AbstractReporter;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.WidgetType;

public class PDPReporter extends AbstractReporter<PowerDistributionPanel, PDPReporter> {

	public PDPReporter(PowerDistributionPanel panel, String name, String tabName) {
		super(() -> panel, name, tabName);
	}

	@Override
	public WidgetType getType() {
		return BuiltInWidgets.kPowerDistributionPanel;
	}

	@Override
	public void update() {
	}

}
