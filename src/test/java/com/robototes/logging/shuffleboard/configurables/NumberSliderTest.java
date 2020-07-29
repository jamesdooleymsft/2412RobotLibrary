package com.robototes.logging.shuffleboard.configurables;

import static org.junit.Assert.assertEquals;

import com.robototes.logging.shuffleboard.ShuffleboardFieldTest;
import com.robototes.logging.shuffleboard.ReporterTest;
import com.robototes.logging.shuffleboard.ShuffleBoardManager;
import com.robototes.math.MathUtils;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;

public class NumberSliderTest extends ReporterTest<NumberSlider> {

	private static final String TAB_NAME = "Test Tab";
	private static final String NAME = "Test Slider";

	ShuffleboardFieldTest<Double> field = new ShuffleboardFieldTest<Double>(0d);

	public NumberSliderTest() {
		super(NAME, TAB_NAME, BuiltInWidgets.kNumberSlider);
		ShuffleBoardManager.getInstance().reset();
		setReporter(new NumberSlider(field::getValue, field::setValue, name, tabName).build());
	}

	@Override
	public void testUpdate() {
		double number = 1;
		reporter.getEntry().setNumber(number);
		reporter.update();
		assertEquals("Slider set correct robot value", number, field.getValue(), MathUtils.EPSILON);

		double number2 = -1;
		field.setValue(number2);
		reporter.update();
		assertEquals("Slider set correct shuffleboard value", number2,
				(Double) reporter.getEntry().getNumber(Double.NaN), MathUtils.EPSILON);
	}

}
