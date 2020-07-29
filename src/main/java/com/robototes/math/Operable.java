package com.robototes.math;

/**
 * An interface that allows for the implementer to have add, subtract, multiply,
 * and divide methods
 *
 * @author Eli Orona
 *
 * @param <T> The type to run operations on
 */
public interface Operable<T> {

	/**
	 * Adds two values
	 *
	 * @param other Other value
	 * @return Added value
	 */
	T add(T other);

	/**
	 * Divides two values
	 *
	 * @param other Other value
	 * @return Divided value
	 */
	T divide(T other);

	/**
	 * Multiplies two values
	 *
	 * @param other Other value
	 * @return Multiplied value
	 */
	T multiply(T other);

	/**
	 * Subtracts two values
	 *
	 * @param other Other value
	 * @return Subtracted value
	 */
	T subtract(T other);
}
