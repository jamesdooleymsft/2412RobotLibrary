package com.robototes.drivebase;

import com.robototes.drivebase.IDrivebase.ControlMode;
import com.robototes.units.Rotations;

import edu.wpi.first.wpilibj.command.CommandGroup;

@Deprecated
public class RotateBy extends CommandGroup {
	public <T extends IDrivebase> RotateBy(T drivebase, Rotations rotations, double deadband) {
		drivebase.setControlMode(ControlMode.ROTATION);
		addSequential(new AddRotationDrive<>(drivebase, rotations));
		addSequential(new UseRotationDrive<>(drivebase, rotations.add(drivebase.getHeading()), deadband));
	}
}
