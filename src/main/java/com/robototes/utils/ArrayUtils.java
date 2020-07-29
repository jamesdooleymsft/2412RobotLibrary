package com.robototes.utils;

import java.lang.reflect.Array;

public class ArrayUtils {
	@SuppressWarnings("unchecked")
	public static <T> T[] stackArrays(T[] array1, T... array2) {
		final Class<?> type1 = array1.getClass().getComponentType();
		T[] joinedArray = (T[]) Array.newInstance(type1, array1.length + array2.length);
		System.arraycopy(array1, 0, joinedArray, 0, array1.length);
		System.arraycopy(array2, 0, joinedArray, array1.length, array2.length);
		return joinedArray;
	}

	public static <T> String printArray(T[] array) {
		int counter = 0;
		String string = "";
		for (T value : array) {
			string += "[" + counter++ + "]: " + value;
			if (counter != array.length) {
				string += ", ";
			}
		}
		System.out.println(string);
		return string;
	}
}
