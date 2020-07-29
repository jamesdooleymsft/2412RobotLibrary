package com.robototes.logging.shuffleboard;

import java.util.Map;
import java.util.function.Supplier;

import edu.wpi.cscore.VideoSource;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardComponent;
import edu.wpi.first.wpilibj.shuffleboard.SuppliedValueWidget;

@SuppressWarnings("unchecked")
public abstract class AbstractReporter<T, S extends IReporter<T, S>> implements IReporter<T, S> {

	protected final Supplier<T> getter;
	protected final String name;
	protected final String tabName;

	protected boolean built = false;
	protected Map<String, Object> allProperties;
	protected ShuffleboardComponent<?> widget;

	protected NetworkTableEntry entry;

	protected T oldValue;

	public AbstractReporter(Supplier<T> getter, String name, String tabName) {
		this.getter = getter;
		this.name = name;
		this.tabName = tabName;

		if (getter.get() instanceof String) {
			widget = Shuffleboard.getTab(tabName).addString(name, (Supplier<String>) getter).withWidget(getType());
		} else if (getter.get() instanceof Double) {
			widget = Shuffleboard.getTab(tabName).addNumber(name, () -> (double) getter.get()).withWidget(getType());
		} else if (getter.get() instanceof Boolean) {
			widget = Shuffleboard.getTab(tabName).addBoolean(name, () -> (boolean) getter.get()).withWidget(getType());
		} else if (getter.get() instanceof VideoSource) {
			widget = Shuffleboard.getTab(tabName).add(name, (VideoSource) getter.get()).withWidget(getType());
		} else if (getter.get() instanceof Sendable) {
			widget = Shuffleboard.getTab(tabName).add(name, (Sendable) getter.get()).withWidget(getType());
		} else {
			throw new IllegalArgumentException("Type " + getter.get().getClass().getSimpleName() + " is not supported");
		}
	}

	@Override
	public S build() {
		checkNotBuilt();
		initializeWidget();
		built = true;
		return (S) this;
	}

	public NetworkTableEntry getEntry() {
		return entry;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Supplier<T> getReporter() {
		return getter;
	}

	@Override
	public String getTabName() {
		return tabName;
	}

	@Override
	public boolean hasBeenBuilt() {
		return built;
	}

	protected void initializeWidget() {
		ShuffleBoardManager.getInstance().add(this);
		if (NetworkTableEntry.isValidDataType(getter.get())) {
			entry = NetworkTableInstance.getDefault().getTable(Shuffleboard.kBaseTableName).getSubTable(tabName)
					.getEntry(name);
			entry.forceSetValue(getter.get());
		}
		widget.withProperties(allProperties);
		oldValue = getter.get();
	}

	@Override
	public S withPosition(int columnIndex, int rowIndex) {
		checkNotBuilt();
		widget.withPosition(columnIndex, rowIndex);
		return (S) this;
	}

	@Override
	public S withProperties(Map<String, Object> properties) {
		checkNotBuilt();
		if (this.allProperties == null) {
			allProperties = properties;
		} else {
			allProperties.putAll(properties);
		}
		return (S) this;
	}

	@Override
	public S withSize(int width, int height) {
		checkNotBuilt();
		widget.withSize(width, height);
		return (S) this;
	}

}
