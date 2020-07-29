package com.robototes.logging.shuffleboard;

import java.util.Map;
import java.util.function.Supplier;

import edu.wpi.first.wpilibj.shuffleboard.WidgetType;

/**
 * This interface is used to easily show data in shuffle board
 *
 * @author Eli Orona
 *
 * @param <T> The type of data
 * @param <S> This type
 */
public interface IReporter<T, S extends IReporter<T, S>> {
	/**
	 *
	 * @return The type of shuffleboard widget
	 */
	public WidgetType getType();

	/**
	 *
	 * @return The supplier of the data for the widget
	 */
	public Supplier<T> getReporter();

	/**
	 * Update the widget
	 */
	public void update();

	/**
	 *
	 * @return The name of the widget
	 */
	public String getName();

	/**
	 *
	 * @return The tab name of the widget
	 */
	public String getTabName();

	/**
	 * Sets the size of the widget
	 *
	 * @param width
	 * @param height
	 * @return this
	 */
	public S withSize(int width, int height);

	/**
	 * Sets the position of the widget
	 *
	 * @param columnIndex
	 * @param rowIndex
	 * @return this
	 */
	public S withPosition(int columnIndex, int rowIndex);

	/**
	 * Adds to the properties of the widget
	 *
	 * @param properties
	 * @return this
	 */
	public S withProperties(Map<String, Object> properties);

	/**
	 * Builds and initializes the widget
	 *
	 * @return this
	 */
	public S build();

	/**
	 * Throws an exception if the widget is already built
	 */
	default void checkNotBuilt() {
		if (hasBeenBuilt()) {
			throw new UnsupportedOperationException("Object has been built already");
		}
	}

	public boolean hasBeenBuilt();

}
