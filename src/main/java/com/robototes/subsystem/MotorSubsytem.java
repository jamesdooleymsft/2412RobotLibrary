package com.robototes.subsystem;

import com.robototes.math.MathUtils;

import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 * A simple motor subsystem
 *
 * @author Eli Orona
 *
 *
 */
public abstract class MotorSubsytem implements InOutSubsystem {

	protected final SubsystemType m_type;
	protected final String m_name;

	protected boolean m_inverted = false;

	protected double m_maxSpeed = 1;
	protected double m_currentSpeed = 0;

	protected final SpeedControllerGroup m_motors;

	public MotorSubsytem(SubsystemType type, String name, boolean inverted, double maxSpeed,
			SpeedControllerGroup motors) {
		m_type = type;
		m_name = name;
		m_inverted = inverted;
		m_maxSpeed = maxSpeed;
		m_motors = motors;
	}

	public MotorSubsytem(SubsystemType m_type, String m_name, SpeedControllerGroup m_motors) {
		this.m_type = m_type;
		this.m_name = m_name;
		this.m_motors = m_motors;
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
	public void invert(boolean inverted) {
		m_inverted = inverted;
	}

	@Override
	public boolean isInverted() {
		return m_inverted;
	}

	@Override
	public void in() {
		m_motors.set(invertDouble(m_maxSpeed));
		m_currentSpeed = m_maxSpeed;
	}

	@Override
	public void out() {
		m_motors.set(invertDouble(-m_maxSpeed));
		m_currentSpeed = -m_maxSpeed;
	}

	@Override
	public void stop() {
		m_motors.set(0);
		m_currentSpeed = 0;
	}

	@Override
	public void set(double speed) {
		double correctedSpeed = MathUtils.constrain(speed, m_maxSpeed, -m_maxSpeed);
		m_motors.set(invertDouble(correctedSpeed));
		m_currentSpeed = correctedSpeed;
	}

	@Override
	public void setMaxSpeed(double maxSpeed) {
		m_maxSpeed = maxSpeed;
	}

	@Override
	public double getMaxSpeed() {
		return m_maxSpeed;
	}

	@Override
	public double getSpeed() {
		return m_currentSpeed;
	}

	/**
	 * Gets the motors of the subsytem
	 *
	 * @return The {@link SpeedControllerGroup} for the motors
	 */
	public SpeedControllerGroup getMotors() {
		return m_motors;
	}

}
