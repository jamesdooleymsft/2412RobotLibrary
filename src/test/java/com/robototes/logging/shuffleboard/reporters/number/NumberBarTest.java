package com.robototes.logging.shuffleboard.reporters.number;

import com.robototes.logging.shuffleboard.ShuffleBoardManager;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;

public class NumberBarTest extends NumberTest<NumberBar> {

	private static final String TAB_NAME = "Test Tab";
	private static final String NAME = "Test Number Bar";

	public NumberBarTest() {
		super(NAME, TAB_NAME, BuiltInWidgets.kNumberBar);
		ShuffleBoardManager.getInstance().reset();
		setReporter(new NumberBar(field::getValue, name, tabName).build());
	}
}
