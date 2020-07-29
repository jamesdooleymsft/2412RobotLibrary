package com.robototes.motors;

import com.revrobotics.AlternateEncoderType;
import com.revrobotics.CANAnalog;
import com.revrobotics.CANAnalog.AnalogMode;
import com.revrobotics.CANDigitalInput;
import com.revrobotics.CANDigitalInput.LimitSwitchPolarity;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANError;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.EncoderType;

/**
 * Note: This is to be used for testing only, and the class cannot be mocked
 *
 * @author Eli Orona
 *
 */
@SuppressWarnings("unused")
public class RobototesCANSparkMax extends CANSparkMax {

	private boolean isInSim = false;

	public RobototesCANSparkMax(int deviceID, MotorType type) {
		super(deviceID, type);
	}

	public RobototesCANSparkMax(int deviceID, MotorType type, boolean isInSim) {
		super(deviceID, type);
		this.isInSim = isInSim;
	}

	private double speed;

	@Override
	public void set(double speed) {
		if (isInSim) {
			this.speed = speed;
			return;
		}

		super.set(speed);
	}

	private double voltage;

	@Override
	public void setVoltage(double outputVolts) {
		if (isInSim) {
			voltage = outputVolts;
			return;
		}
		super.setVoltage(outputVolts);
	}

	@Override
	public double get() {
		if (isInSim) {
			return speed;
		}
		return super.get();
	}

	private boolean isInverted;

	@Override
	public void setInverted(boolean isInverted) {
		if (isInSim) {
			this.isInverted = isInverted;
			return;
		}
		super.setInverted(isInverted);
	}

	@Override
	public boolean getInverted() {
		if (isInSim) {
			return isInverted;
		}
		return super.getInverted();
	}

	@Override
	public CANEncoder getEncoder(EncoderType sensorType, int counts_per_rev) {
		if (isInSim) {
			return null;
		}

		return super.getEncoder(sensorType, counts_per_rev);
	}

	@Override
	public CANEncoder getAlternateEncoder(AlternateEncoderType sensorType, int counts_per_rev) {
		if (isInSim) {
			return null;
		}
		return super.getAlternateEncoder(sensorType, counts_per_rev);
	}

	@Override
	public CANAnalog getAnalog(AnalogMode mode) {
		if (isInSim) {
			return null;
		}
		return super.getAnalog(mode);
	}

	@Override
	public CANPIDController getPIDController() {
		if (isInSim) {
			return null;
		}
		return super.getPIDController();
	}

	@Override
	public CANDigitalInput getForwardLimitSwitch(LimitSwitchPolarity polarity) {
		if (isInSim) {
			return null;
		}
		return super.getForwardLimitSwitch(polarity);
	}

	@Override
	public CANDigitalInput getReverseLimitSwitch(LimitSwitchPolarity polarity) {
		if (isInSim) {
			return null;
		}
		return super.getReverseLimitSwitch(polarity);
	}

//	private int stallLimit;
//	private int freeLimit;
//	private int limitRPM;

	@Override
	public CANError setSmartCurrentLimit(int stallLimit, int freeLimit, int limitRPM) {
		if (isInSim) {
//			this.stallLimit = stallLimit;
//			this.freeLimit = freeLimit;
//			this.limitRPM = limitRPM;

			return CANError.kOk;
		}
		return super.setSmartCurrentLimit(stallLimit, freeLimit, limitRPM);
	}

	@Override
	public CANError setSecondaryCurrentLimit(double limit, int chopCycles) {
		if (isInSim) {
			return CANError.kOk;
		}
		return super.setSecondaryCurrentLimit(limit, chopCycles);
	}

	private IdleMode mode;

	@Override
	public CANError setIdleMode(IdleMode mode) {
		if (isInSim) {
			this.mode = mode;
			return CANError.kOk;
		}

		return super.setIdleMode(mode);
	}

	@Override
	public IdleMode getIdleMode() {
		if (isInSim) {
			return mode;
		}
		return super.getIdleMode();
	}

	@Override
	public CANError follow(CANSparkMax leader) {
		// TODO Auto-generated method stub
		return super.follow(leader);
	}

	@Override
	public CANError follow(CANSparkMax leader, boolean invert) {
		// TODO Auto-generated method stub
		return super.follow(leader, invert);
	}

	@Override
	public CANError follow(ExternalFollower leader, int deviceID) {
		// TODO Auto-generated method stub
		return super.follow(leader, deviceID);
	}

	@Override
	public CANError follow(ExternalFollower leader, int deviceID, boolean invert) {
		// TODO Auto-generated method stub
		return super.follow(leader, deviceID, invert);
	}

	@Override
	public boolean isFollower() {
		// TODO Auto-generated method stub
		return super.isFollower();
	}

}
