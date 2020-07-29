package com.robototes.sensors;

import edu.wpi.first.networktables.NetworkTable;

/**
 * A wrapper class for the limelight system. This will be updated as more
 * features are needed
 *
 * @author Eli Orona
 *
 */
public class Limelight {
	/**
	 * The different LED modes of the limelight
	 *
	 * @author Eli Orona
	 *
	 */
	public static enum LEDMode {
		DEFAULT(0), OFF(1), BLINK(2), ON(3);

		private int modeID;

		private LEDMode(int modeID) {
			this.modeID = modeID;
		}

		public int getModeID() {
			return modeID;
		}
	}

	/**
	 * The different camera modes of the limelight
	 *
	 * @author Eli Orona
	 *
	 */
	public static enum CamMode {
		VISION_PROCESSER(0), DRIVER_CAMERA(1);

		private int modeID;

		private CamMode(int modeID) {
			this.modeID = modeID;
		}

		public int getModeID() {
			return modeID;
		}
	}

	/**
	 * The different pipelines of the limelight
	 *
	 * @author Eli Orona
	 *
	 */
	public static enum Pipeline {
		ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9);

		private int modeID;

		private Pipeline(int modeID) {
			this.modeID = modeID;
		}

		public int getModeID() {
			return modeID;
		}
	}

	/**
	 * The different streaming modes of the limelight
	 *
	 * @author Eli Orona
	 *
	 */
	public static enum StreamMode {
		STANDARD(0), PIP_MAIN(1), PIP_SECONDARY(2);

		private int modeID;

		private StreamMode(int modeID) {
			this.modeID = modeID;
		}

		public int getModeID() {
			return modeID;
		}
	}

	/**
	 * The different snapshot modes of the limelight
	 *
	 * @author Eli Orona
	 *
	 */
	public static enum SnapshotMode {
		OFF(0), TWO_PER_SECOND(1);

		private int modeID;

		private SnapshotMode(int modeID) {
			this.modeID = modeID;
		}

		public int getModeID() {
			return modeID;
		}
	}

	NetworkTable networkTable;
	LEDMode ledMode;
	CamMode camMode;
	Pipeline pipeline;
	StreamMode streamMode;
	SnapshotMode snapshotMode;

	public Limelight(NetworkTable networkTable, LEDMode ledMode, CamMode camMode, Pipeline pipeline,
			StreamMode streamMode, SnapshotMode snapshotMode) {
		this.networkTable = networkTable;
		this.ledMode = ledMode;
		this.camMode = camMode;
		this.pipeline = pipeline;
		this.streamMode = streamMode;
		this.snapshotMode = snapshotMode;
	}

	public double getTY() {
		return networkTable.getEntry("ty").getDouble(Double.NaN);
	}

	public boolean hasValidTarget() {
		return networkTable.getEntry("tv").getDouble(0) == 1f;
	}

	public double getTX() {
		return networkTable.getEntry("tx").getDouble(Double.NaN);
	}

	public double getTS() {
		return networkTable.getEntry("ts").getDouble(Double.NaN);
	}

	public LEDMode getLedMode() {
		return ledMode;
	}

	public void setLedMode(LEDMode ledMode) {
		networkTable.getEntry("ledMode").setNumber(ledMode.getModeID());
		this.ledMode = ledMode;
	}

	public CamMode getCamMode() {
		return camMode;
	}

	public void setCamMode(CamMode camMode) {
		networkTable.getEntry("camMode").setNumber(camMode.getModeID());
		this.camMode = camMode;
	}

	public Pipeline getPipeline() {
		return pipeline;
	}

	public void setPipeline(Pipeline pipeline) {
		networkTable.getEntry("pipeline").setNumber(pipeline.getModeID());
		this.pipeline = pipeline;
	}

	public StreamMode getStreamMode() {
		return streamMode;
	}

	public void setStreamMode(StreamMode streamMode) {
		networkTable.getEntry("stream").setNumber(streamMode.getModeID());
		this.streamMode = streamMode;
	}

	public SnapshotMode getSnapshotMode() {
		return snapshotMode;
	}

	public void setSnapshotMode(SnapshotMode snapshotMode) {
		networkTable.getEntry("snapshot").setNumber(snapshotMode.getModeID());
		this.snapshotMode = snapshotMode;
	}

	public NetworkTable getNetworkTable() {
		return networkTable;
	}
}
