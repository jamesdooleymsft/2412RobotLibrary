package com.robototes.logging.shuffleboard;

import java.util.ArrayList;
import java.util.List;

/**
 * The controller for all the Shuffle board widgets
 *
 * @author Eli Orona
 *
 */
public class ShuffleBoardManager {
	private static ShuffleBoardManager instance;

	/**
	 *
	 * @return The instance of the Manager
	 */
	public static ShuffleBoardManager getInstance() {
		if (instance == null) {
			instance = new ShuffleBoardManager();
		}

		return instance;
	}

	private List<IReporter<?, ?>> reporters;

	private int loopIteration;

	private ShuffleBoardManager() {
		reporters = new ArrayList<>();
	}

	/**
	 * Updates all widgets
	 *
	 * @see {@link #update(int) update}
	 */
	public void update() {
		reporters.forEach(IReporter::update);
	}

	/**
	 * Updates all widgets every {@code loop} times
	 *
	 * @param loop How many iterations to skip when updating
	 */
	public void update(int loop) {
		if (loopIteration++ % loop == 0) {
			update();
		}
	}

	/**
	 * Adds a widget
	 *
	 * @param iReporter
	 */
	public void add(IReporter<?, ?> iReporter) {
		reporters.add(iReporter);
	}

	public void reset() {
		reporters.clear();
	}
}
