package com.robototes.drivebase;

import com.robototes.units.Distance;

import edu.wpi.first.wpilibj.command.Command;

@Deprecated
public class UseDistanceDrive<T extends IDrivebase> extends Command {

	T drivebase;
	Distance distance;
	Distance originalDistance;
	double howCloseToStop;

	public UseDistanceDrive(T drivebase, Distance addDistance, double howCloseToStop) {
		this.drivebase = drivebase;
		this.distance = addDistance;
		this.originalDistance = drivebase.getTotalDistance();
		this.howCloseToStop = howCloseToStop;
	}

	@Override
	public void execute() {
		drivebase.useDistancePID();
	}

	@Override
	protected boolean isFinished() {
		double error = originalDistance.add(distance).subtract(drivebase.getTotalDistance()).getValue();
		return Math.abs(error) < howCloseToStop;
	}

}
