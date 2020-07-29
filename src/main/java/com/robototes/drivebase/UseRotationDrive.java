package com.robototes.drivebase;

import com.robototes.units.Rotations;

import edu.wpi.first.wpilibj.command.Command;

@Deprecated
public class UseRotationDrive<T extends IDrivebase> extends Command {

	T drivebase;
	Rotations rotations;
	double howCloseToStop;

	public UseRotationDrive(T drivebase, Rotations setRotations, double howCloseToStop) {
		this.drivebase = drivebase;
		this.rotations = setRotations;
		this.howCloseToStop = howCloseToStop;
	}

	@Override
	public void execute() {
		drivebase.useDistancePID();
	}

	@Override
	protected boolean isFinished() {
		double error = rotations.subtract(drivebase.getHeading()).getValue();
		return Math.abs(error) < howCloseToStop;
	}

}
