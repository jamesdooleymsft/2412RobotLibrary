package com.robototes.logging.shuffleboard;

import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class AbstractValueConfigurable<T, S extends AbstractValueConfigurable<T, S>> extends AbstractReporter<T, S>
		implements IConfigurable<T, S> {

	protected Consumer<T> setter;

	public AbstractValueConfigurable(Supplier<T> getter, Consumer<T> setter, String name, String tabName) {
		super(getter, name, tabName);
		this.setter = setter;
	}

	@Override
	public Consumer<T> getSetter() {
		return setter;
	}

}
