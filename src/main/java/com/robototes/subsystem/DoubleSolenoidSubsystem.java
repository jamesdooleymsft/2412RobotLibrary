package com.robototes.subsystem;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class DoubleSolenoidSubsystem extends SubsystemBase implements OnOffSubsystem {

	protected final DoubleSolenoid m_doubleSolenoid;

	protected final String m_name;
	protected final SubsystemType m_type;

	protected boolean m_inverted = false;

	public DoubleSolenoidSubsystem(DoubleSolenoid solenoid, String name, SubsystemType type) {
		m_name = name;
		m_type = type;
		m_doubleSolenoid = solenoid;
	}

	public DoubleSolenoidSubsystem(DoubleSolenoid solenoid, String name, SubsystemType type, boolean invertedOnStart) {
		this(solenoid, name, type);
		m_inverted = invertedOnStart;
	}

	@Override
	public SubsystemType getSubsystemType() {
		return m_type;
	}

	@Override
	public String getRobototesName() {
		return m_name;
	}

	@Override
	public void on() {
		m_doubleSolenoid.set(invertGeneric(Value.kForward, Value.kReverse));
	}

	@Override
	public void off() {
		m_doubleSolenoid.set(invertGeneric(Value.kReverse, Value.kForward));
	}

	@Override
	public void invert(boolean inverted) {
		m_inverted = inverted;
	}

	@Override
	public boolean isInverted() {
		return m_inverted;
	}

	/**
	 * Gets the double solenoid of the subsystem
	 *
	 * @return The double solenoid
	 */
	public DoubleSolenoid getDoubleSolenoid() {
		return m_doubleSolenoid;
	}

}
