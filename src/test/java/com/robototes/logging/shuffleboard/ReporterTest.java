package com.robototes.logging.shuffleboard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Test;

import edu.wpi.first.wpilibj.shuffleboard.WidgetType;

public abstract class ReporterTest<T extends IReporter<?, T>> {

	private static HashMap<String, Integer> names;

	protected String name;
	protected String tabName;

	protected T reporter;

	protected WidgetType widgetType;

	public ReporterTest(String name, String tabName, WidgetType type) {
		if (names == null) {
			names = new HashMap<>();
		}

		this.name = name;

		if (names.containsKey(name)) {
			int nameIteration = names.get(name) + 1;
			names.replace(name, nameIteration);
			this.name += nameIteration;
		} else {
			names.put(name, 0);
		}

		this.tabName = tabName;
		this.widgetType = type;
	}

	public void setReporter(T reporter) {
		this.reporter = reporter;
	}

	@Test
	public void testGetName() {
		assertEquals("Reporter " + reporter.getType().getWidgetName() + " has correct name", name, reporter.getName());
	}

	@Test
	public void testGetTabName() {
		assertEquals("Reporter " + reporter.getType().getWidgetName() + " has correct tab name", tabName,
				reporter.getTabName());
	}

	@Test
	public void testHasBeenBuilt() {
		assertTrue("Reporter " + reporter.getType().getWidgetName() + " has been build", reporter.hasBeenBuilt());
	}

	@Test
	public void testCorrectType() {

		assertEquals("Reporter " + name + " is correct type", widgetType, reporter.getType());
	}

	@Test
	public abstract void testUpdate();

}
