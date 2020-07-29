package com.robototes.logging.shuffleboard.reporters.accelerometer;

import com.robototes.logging.shuffleboard.AbstractReporter;

import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.WidgetType;

/**
 * Supported types:
 * <ul>
 * <li>{@link edu.wpi.first.wpilibj.ADXL345_I2C}</li>
 * <li>{@link edu.wpi.first.wpilibj.ADXL345_SPI}</li>
 * <li>{@link edu.wpi.first.wpilibj.ADXL362}</li>
 * </ul>
 * 
 * 
 * @author Eli Orona
 *
 */
public class ThreeAxisAccelerometerReporter extends AbstractReporter<Accelerometer, ThreeAxisAccelerometerReporter> {

	public ThreeAxisAccelerometerReporter(Accelerometer accelerometer, String name, String tabName) {
		super(() -> accelerometer, name, tabName);
	}

	@Override
	public WidgetType getType() {
		return BuiltInWidgets.k3AxisAccelerometer;
	}

	@Override
	public void update() {
	}

}
