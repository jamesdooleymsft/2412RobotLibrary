package com.robototes.drivebase;

import com.robototes.units.Rotations;

import edu.wpi.first.wpilibj.command.Command;

@Deprecated
public class AddRotationDrive<T extends IDrivebase> extends Command {

	T drivebase;
	Rotations rotations;

	public AddRotationDrive(T drivebase, Rotations addRotations) {
		this.drivebase = drivebase;
		this.rotations = addRotations;
	}

	@Override
	public void execute() {
		drivebase.addAngle(rotations);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
