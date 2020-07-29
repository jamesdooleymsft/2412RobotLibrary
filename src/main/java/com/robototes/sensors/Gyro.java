package com.robototes.sensors;

import com.robototes.units.Rotations;
import com.robototes.units.UnitTypes.RotationUnits;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI.Port;

/**
 * An extension of ADXRS450_Gyro so that new programmers can do it easier.
 *
 * @author Eli Orona
 *
 */
@Deprecated
public class Gyro extends ADXRS450_Gyro {

	public Gyro() {
		super();
	}

	public Gyro(Port port) {
		super(port);
	}

	/**
	 * Converts the angle to a rotation, constrained between 0 and 1
	 *
	 * @return The rotations of the gryo
	 */
	public Rotations getRotations() {
		return new Rotations(getAngle() % 360, RotationUnits.DEGREE);
	}
}
