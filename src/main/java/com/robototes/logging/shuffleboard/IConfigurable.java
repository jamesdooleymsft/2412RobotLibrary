package com.robototes.logging.shuffleboard;

import java.util.function.Consumer;

/**
 * This interface is used to create shuffleboard widgets from which data can be
 * used
 *
 * @author Eli Orona
 *
 * @param <T> The type of the data that this widget controller uses
 * @param <S> This type
 */
public interface IConfigurable<T, S extends IConfigurable<T, S>> extends IReporter<T, S> {

	/**
	 *
	 * @return The setter used by the widget
	 */
	public Consumer<T> getSetter();
}
