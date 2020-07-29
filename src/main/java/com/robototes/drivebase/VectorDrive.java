package com.robototes.drivebase;

import com.robototes.math.Vector;
import com.robototes.units.Distance;
import com.robototes.units.Rotations;
import com.robototes.units.UnitTypes.RotationUnits;

import edu.wpi.first.wpilibj.command.CommandGroup;

@Deprecated
public class VectorDrive extends CommandGroup {
	public <T extends IDrivebase> VectorDrive(T drivebase, Vector vect, double deadband) {
		addSequential(new RotateBy(drivebase, new Rotations(vect.angle, RotationUnits.RADIAN), deadband));
		addSequential(new DistanceDrive(drivebase, new Distance(vect.length), deadband));
	}
}
