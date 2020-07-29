package com.robototes.units;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.robototes.math.MathUtils;
import com.robototes.units.UnitTypes.TimeUnits;

public class TimeTest {

	@Test
	public void testAdd() {
		Time one = new Time(5);
		Time two = new Time(6);
		assertEquals("Add whole Time", one.add(two), new Time(11));

		Time three = new Time(3.5);
		Time four = new Time(10, TimeUnits.MILLISECOND);
		assertEquals("Add two different Times", three.add(four), new Time(3.51));
	}

	@Test
	public void testConvertTo() {
		Time oneMeter = new Time(1);

		double epsilon = 0.00001; // MathUtils.Epsilon is too small for the inaccuracies in conversion

		assertEquals("sec to millis", oneMeter.convertTo(TimeUnits.MILLISECOND), 1000, epsilon);
		assertEquals("sec to day", oneMeter.convertTo(TimeUnits.DAY), 1d / (60 * 60 * 24), epsilon);
		assertEquals("sec to hour", oneMeter.convertTo(TimeUnits.HOUR), 1d / 3600d, epsilon);
		assertEquals("sec to minute", oneMeter.convertTo(TimeUnits.MINUTE), 1d / 60d, epsilon);

	}

	@Test
	public void testDivide() {
		Time one = new Time(5);
		Time scalar = new Time(2);
		assertEquals("Scale a Time down", one.divide(scalar), new Time(2.5));
	}

	@Test
	public void testGetValue() {
		Time one = new Time(5);
		assertEquals("Get a Time value", one.getValue(), 5, MathUtils.EPSILON);
	}

	@Test
	public void testMultiply() {
		Time one = new Time(5);
		Time scalar = new Time(2);
		assertEquals("Scale a Time up", one.multiply(scalar), new Time(10));
	}

	@Test
	public void testSubtract() {
		Time one = new Time(6);
		Time two = new Time(5);
		assertEquals("Subtract whole Time", one.subtract(two), new Time(1));

		Time three = new Time(3.5);
		Time four = new Time(10, TimeUnits.MILLISECOND);
		assertEquals("Subtract two different Times", three.subtract(four), new Time(3.49));
	}

	@Test
	public void testTime() {
		Time d = new Time(1);
		assertEquals("Time from time", d.time, 1, MathUtils.EPSILON);

		Time fromMillis = new Time(1000, TimeUnits.MILLISECOND);
		assertEquals("millis to sec", fromMillis, new Time(1));
		Time fromDay = new Time(1d / (60 * 60 * 24), TimeUnits.DAY);
		assertEquals("day to sec", fromDay, new Time(1));
		Time fromHour = new Time(1d / 3600d, TimeUnits.HOUR);
		assertEquals("hour to sec", fromHour, new Time(1));
		Time fromMin = new Time(1d / 60d, TimeUnits.MINUTE);
		assertEquals("min to sec", fromMin, new Time(1));
	}

	@Test
	public void testToString() {
		Time one = new Time(1);
		assertEquals("Simple toString()", one.toString(), "1s");

		Time two = new Time(1, TimeUnits.MILLISECOND);
		assertEquals("Complex toString()", two.toString(), "0.001s");
	}

}
