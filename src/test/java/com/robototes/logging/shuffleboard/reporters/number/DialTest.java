package com.robototes.logging.shuffleboard.reporters.number;

import com.robototes.logging.shuffleboard.ShuffleBoardManager;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;

public class DialTest extends NumberTest<Dial> {

	private static final String TAB_NAME = "Test Tab";
	private static final String NAME = "Test Dial";

	public DialTest() {
		super(NAME, TAB_NAME, BuiltInWidgets.kDial);
		ShuffleBoardManager.getInstance().reset();
		setReporter(new Dial(field::getValue, name, tabName).build());
	}

}
