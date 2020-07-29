package com.robototes.control;

import com.robototes.units.IUnit;

import edu.wpi.first.wpilibj.command.Command;

@Deprecated
public class UsePIDCommand<T extends IUnit<T>> extends Command {

	private PIDSubsystem<T> PIDSubsystem;
	private T finalPosition;
	private double howCloseMustItBe;

	public UsePIDCommand(PIDSubsystem<T> PIDSubsystem, T finalPosition, double howCloseMustItBe) {
		this.PIDSubsystem = PIDSubsystem;
		this.finalPosition = finalPosition;
		this.howCloseMustItBe = howCloseMustItBe;
	}

	@Override
	public void execute() {
		PIDSubsystem.usePID();
	}

	@Override
	protected boolean isFinished() {
		boolean done = false;
		if (PIDSubsystem.getError() != null) {
			done = Math.abs(PIDSubsystem.getError().subtract(finalPosition).getValue()) < howCloseMustItBe;
		}

		return done;
	}

}
