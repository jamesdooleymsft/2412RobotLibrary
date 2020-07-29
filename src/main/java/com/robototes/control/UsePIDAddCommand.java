package com.robototes.control;

import com.robototes.units.IUnit;

import edu.wpi.first.wpilibj.command.CommandGroup;

@Deprecated
public class UsePIDAddCommand<T extends IUnit<T>> extends CommandGroup {

	public UsePIDAddCommand(PIDSubsystem<T> PIDSubsystem, T addPosition, double howCloseMustItBe) {
		addSequential(new PIDAddCommand<>(PIDSubsystem, addPosition));
		addSequential(new UsePIDCommand<>(PIDSubsystem, addPosition.add(PIDSubsystem.getError()), howCloseMustItBe));
	}
}
