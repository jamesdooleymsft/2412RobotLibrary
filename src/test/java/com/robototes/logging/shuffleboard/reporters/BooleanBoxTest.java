package com.robototes.logging.shuffleboard.reporters;

import static org.junit.Assert.assertFalse;

import com.robototes.logging.shuffleboard.ReporterTest;
import com.robototes.logging.shuffleboard.ShuffleBoardManager;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;

public class BooleanBoxTest extends ReporterTest<BooleanBox> {

	private static String NAME = "Test Boolean Box";
	private static String TAB_NAME = "Test Tab";

	public BooleanBoxTest() {
		super(NAME, TAB_NAME, BuiltInWidgets.kBooleanBox);
		ShuffleBoardManager.getInstance().reset();
		setReporter(new BooleanBox(this::getValue, name, tabName).build());
	}

	private boolean value = true;

	public boolean getValue() {
		return value;
	}

	@Override
	public void testUpdate() {
		value = false;
		reporter.update();
		assertFalse("Boolean Box set correct shuffleboard value", reporter.getEntry().getBoolean(true));
	}

}
