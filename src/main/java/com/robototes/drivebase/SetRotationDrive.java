package com.robototes.drivebase;

import com.robototes.units.Rotations;

import edu.wpi.first.wpilibj.command.Command;

@Deprecated
public class SetRotationDrive<T extends IDrivebase> extends Command {

	T drivebase;
	Rotations rotations;

	public SetRotationDrive(T drivebase, Rotations addRotations) {
		this.drivebase = drivebase;
		this.rotations = addRotations;
	}

	@Override
	public void execute() {
		drivebase.setSnapToAngle(rotations);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
