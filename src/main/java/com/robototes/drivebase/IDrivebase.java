package com.robototes.drivebase;

import com.robototes.math.Vector;
import com.robototes.motors.PIDMotorController;
import com.robototes.units.Distance;
import com.robototes.units.Rotations;

import edu.wpi.first.wpilibj.Joystick;

@Deprecated
public interface IDrivebase {

	public enum ControlMode {
		VECTOR, NONE, MANUAL, ROTATION, DISTANCE
	}

	public void addAngle(Rotations rotation);

	public void addDistanceDrive(Distance distance);

	public void drive(double speed, double angle);

	public ControlMode getControlMode();

	public Rotations getHeading();

	public PIDMotorController<?>[] getMotors();

	public Distance getTotalDistance();

	public void joystickDrive(Joystick stick);

	public void setControlMode(ControlMode mode);

	public void setSnapToAngle(Rotations rotation);

	public void setVector(Vector path);

	public void stop();

	public void useAnglePID();

	public void useDistancePID();
}
