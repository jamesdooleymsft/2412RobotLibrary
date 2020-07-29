package com.robototes.logging.shuffleboard.reporters;

import java.util.Map;

import com.robototes.logging.shuffleboard.AbstractReporter;

import edu.wpi.cscore.VideoSource;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.WidgetType;

public class CameraStreamView extends AbstractReporter<VideoSource, CameraStreamView> {

	public CameraStreamView(VideoSource video, String name, String tabName) {
		super(() -> video, name, tabName);
	}

	@Override
	public void update() {
	}

	public CameraStreamView withRotation(Rotation rotation) {
		return withProperties(Map.of("rotation", rotation.getValue()));
	}

	public CameraStreamView showControls(boolean show) {
		return withProperties(Map.of("showControls", show));
	}

	public CameraStreamView showCrosshair(Boolean show) {
		return withProperties(Map.of("showCrosshair", show));
	}

	public CameraStreamView crosshairColor(String color) {
		return withProperties(Map.of("crosshairColor", color));
	}

	@Override
	public WidgetType getType() {
		return BuiltInWidgets.kCameraStream;
	}

	public static enum Rotation {
		NONE("NONE"), QUARTER_CLOCK_WISE("QUARTER_CW"), QUARTER_COUNTER_CLOCK_WISE("QUARTER_CCW"), HALF("HALF");

		private final String value;

		private Rotation(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}
}
