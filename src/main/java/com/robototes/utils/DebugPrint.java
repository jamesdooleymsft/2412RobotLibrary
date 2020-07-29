package com.robototes.utils;

public class DebugPrint {
	public static boolean DEBUG_MODE = false;

	public static void setDebugMode(boolean newMode) {
		DEBUG_MODE = newMode;
	}

	public static <T> void debugPrint(T print) {
		if (DEBUG_MODE) {
			System.out.println(print);
		}
	}

	public static void debugPrintf(String print, Object... objects) {
		if (DEBUG_MODE) {
			System.out.printf(print, objects);
		}
	}
}
