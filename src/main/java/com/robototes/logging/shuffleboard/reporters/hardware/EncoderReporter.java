package com.robototes.logging.shuffleboard.reporters.hardware;

import com.robototes.logging.shuffleboard.AbstractReporter;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.WidgetType;

public class EncoderReporter extends AbstractReporter<Encoder, EncoderReporter> {

	public EncoderReporter(Encoder encoder, String name, String tabName) {
		super(() -> encoder, name, tabName);
	}

	@Override
	public WidgetType getType() {
		return BuiltInWidgets.kEncoder;
	}

	@Override
	public void update() {
	}

}
