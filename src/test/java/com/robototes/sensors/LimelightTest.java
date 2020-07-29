package com.robototes.sensors;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.robototes.helpers.MockHardwareExtension;
import com.robototes.helpers.TestWithScheduler;
import com.robototes.math.MathUtils;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class LimelightTest {

	NetworkTable limelightNetworkTable;
	Limelight limelight;

	@Before
	public void before() {
		TestWithScheduler.schedulerStart();
		TestWithScheduler.schedulerClear();
		MockHardwareExtension.beforeAll();

		limelightNetworkTable = NetworkTableInstance.create().getTable("limelight");
		limelight = new Limelight(limelightNetworkTable, null, null, null, null, null);
	}

	@Test
	public void testGetTY() {
		double valueToRecieve = 25.4;

		limelight.getNetworkTable().getEntry("ty").setNumber(valueToRecieve);

		assertEquals("Limelight has correct path to ty", valueToRecieve, limelight.getTY(), MathUtils.EPSILON);
	}

	@Test
	public void testHasValidTarget() {
		double valueToRecieve = 1;

		limelight.getNetworkTable().getEntry("tv").setNumber(valueToRecieve);

		assertTrue("Limelight has correct path to tv", limelight.hasValidTarget());
	}

	@Test
	public void testGetTX() {
		double valueToRecieve = 25.4;

		limelight.getNetworkTable().getEntry("tx").setNumber(valueToRecieve);

		assertEquals("Limelight has correct path to tx", valueToRecieve, limelight.getTX(), MathUtils.EPSILON);
	}

	@After
	public void after() {
		TestWithScheduler.schedulerDestroy();
		MockHardwareExtension.afterAll();
	}

}
