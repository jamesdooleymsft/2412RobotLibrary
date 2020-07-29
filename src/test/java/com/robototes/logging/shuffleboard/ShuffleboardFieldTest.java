package com.robototes.logging.shuffleboard;

public class ShuffleboardFieldTest<T> {
	private T value;

	public ShuffleboardFieldTest(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}