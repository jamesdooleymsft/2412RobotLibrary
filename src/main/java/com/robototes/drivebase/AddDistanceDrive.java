package com.robototes.drivebase;

import com.robototes.units.Distance;

import edu.wpi.first.wpilibj.command.Command;

@Deprecated
public class AddDistanceDrive<T extends IDrivebase> extends Command {

	T drivebase;
	Distance distance;

	public AddDistanceDrive(T drivebase, Distance addDistance) {
		this.drivebase = drivebase;
		this.distance = addDistance;
	}

	@Override
	public void execute() {
		drivebase.addDistanceDrive(distance);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
