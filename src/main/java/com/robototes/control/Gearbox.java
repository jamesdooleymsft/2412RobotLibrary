package com.robototes.control;

import com.robototes.units.InterUnitRatio;
import com.robototes.units.Rotations;
import com.robototes.units.UnitTypes.RotationUnits;

/**
 * A gearbox representation in the program
 *
 * @author s-oronae
 *
 */
public class Gearbox {

	private InterUnitRatio<RotationUnits, RotationUnits> ratio;

	/**
	 * Creates a gearbox from two other gearboxes
	 *
	 * @param one first gearbox
	 * @param two second gearbox
	 */
	public Gearbox(Gearbox one, Gearbox two) {
		ratio = new InterUnitRatio<>(one.ratio, two.ratio);
	}

	/**
	 * Creates a gearbox based on two rotations
	 *
	 * @param inputRotations  Input rotations
	 * @param gearboxRatio    Ratio between rotations
	 * @param outputRotations Output rotations
	 */
	public Gearbox(Rotations inputRotations, double gearboxRatio, Rotations outputRotations) {
		ratio = new InterUnitRatio<>(Rotations.mainUnit, gearboxRatio, Rotations.mainUnit);
		ratio.from = inputRotations.getUnit();
		ratio.to = outputRotations.getUnit();
	}

	/**
	 * Gets the ratio of the gearbox
	 *
	 * @return the ratio
	 */
	public InterUnitRatio<RotationUnits, RotationUnits> getRatio() {
		return ratio;
	}

}
