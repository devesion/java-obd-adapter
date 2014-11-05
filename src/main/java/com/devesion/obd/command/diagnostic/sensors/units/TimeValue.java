package com.devesion.obd.command.diagnostic.sensors.units;

import com.devesion.obd.command.invoker.CommandResult;

/**
 * Represents Time Value Object.
 */
public class TimeValue extends SimpleValue {

	private static final float RPM_DIVISOR = 1.0f;

	public TimeValue(CommandResult commandResult) {
		super(commandResult, RPM_DIVISOR);
	}
}
