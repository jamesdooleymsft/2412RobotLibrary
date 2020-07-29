package com.robototes.control;

import com.robototes.units.IUnit;

import edu.wpi.first.wpilibj.command.CommandGroup;

@Deprecated
public class UsePIDSetCommand<T extends IUnit<T>> extends CommandGroup {

	public UsePIDSetCommand(PIDSubsystem<T> PIDSubsystem, T setPosition, double howCloseMustItBe) {
		addSequential(new PIDSetCommand<>(PIDSubsystem, setPosition));
		addSequential(new UsePIDCommand<>(PIDSubsystem, setPosition, howCloseMustItBe));
	}

	@Override
	public void execute() {
		super.execute();

	}
}
