package com.robototes.control;

import com.robototes.units.IUnit;

import edu.wpi.first.wpilibj.command.Command;

/**
 * A set command for PID subsytems
 *
 * @author Eli Orona
 *
 * @param <K> Unit type of the subsystem
 */
@Deprecated
public class PIDSetCommand<K extends IUnit<K>> extends Command {
	private PIDSubsystem<K> PIDSubsystem;
	private K setPositionUnit;

	public PIDSetCommand(PIDSubsystem<K> PIDSubsystem, K setPositionUnit) {
		this.PIDSubsystem = PIDSubsystem;
		this.setPositionUnit = setPositionUnit;
	}

	@Override
	protected void execute() {
		PIDSubsystem.setReference(setPositionUnit);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
