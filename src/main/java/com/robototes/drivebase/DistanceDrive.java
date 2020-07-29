package com.robototes.drivebase;

import com.robototes.drivebase.IDrivebase.ControlMode;
import com.robototes.units.Distance;

import edu.wpi.first.wpilibj.command.CommandGroup;

@Deprecated
public class DistanceDrive extends CommandGroup {
	public <T extends IDrivebase> DistanceDrive(T drivebase, Distance distance, double deadband) {
		drivebase.setControlMode(ControlMode.DISTANCE);
		addSequential(new AddDistanceDrive<>(drivebase, distance));
		addSequential(new UseDistanceDrive<>(drivebase, distance, deadband));
	}
}
