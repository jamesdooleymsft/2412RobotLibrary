package com.robototes.units;

import com.robototes.math.Operable;
import com.robototes.units.UnitTypes.IUnitType;

/**
 * An interface to make all units have stuff in common
 *
 * @author Eli Orona
 *
 * @param <T> The class of the unit
 */
public interface IUnit<T extends IUnit<?>> extends Operable<T> {
	/**
	 *
	 * @param          <K> UnitType of the unit
	 * @param unitType New unit type
	 * @return value of the unit converted to the new unit.
	 */
	<K extends IUnitType<K>> double convertTo(K unitType);

	/**
	 * @apiNote NOTE: WILL RETURN A UNIT EVEN THOUGH IT SHOULD BE A SCALAR. TREAT AS
	 *          DIVIDING BY A SCALAR.
	 */
	@Override
	T divide(T other);

	/**
	 *
	 * @return The label of the unit
	 */
	public String getUnit();

	/**
	 *
	 * @return the value of the unit
	 */
	public double getValue();

	/**
	 * @apiNote NOTE: WILL NOT RETURN A SQUARE UNIT EVEN THOUGH IT SHOULD. TREAT AS
	 *          MULTIPLYING BY SCALAR.
	 */
	@Override
	T multiply(T other);
}
