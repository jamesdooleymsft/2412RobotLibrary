package com.robototes.control;

import com.robototes.units.IUnit;

import edu.wpi.first.wpilibj.command.Command;

/**
 * A Command Class that allows for easier use of PIDSubsystems, this command
 * uses the .addReference() method of PIDSubsystem
 *
 * @author Eli Orona
 *
 * @param <T> Unit of the Subsystem
 */
@Deprecated
public class PIDAddCommand<T extends IUnit<T>> extends Command {
	private PIDSubsystem<T> PIDSubsystem;
	private T addPositionUnit;

	public PIDAddCommand(PIDSubsystem<T> PIDSubsystem, T addPositionUnit) {
		this.PIDSubsystem = PIDSubsystem;
		this.addPositionUnit = addPositionUnit;
	}

	@Override
	protected void execute() {
		PIDSubsystem.addRefecence(addPositionUnit);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
