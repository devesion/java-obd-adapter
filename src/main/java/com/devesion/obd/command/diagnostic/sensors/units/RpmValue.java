package com.devesion.obd.command.diagnostic.sensors.units;

import com.devesion.obd.command.invoker.CommandResult;

/**
 * Represents RPM Value Object.
 */
public class RpmValue extends SimpleValue {

	private static final float RPM_DIVISOR = 4.0f;

	public RpmValue(CommandResult commandResult) {
		super(commandResult, RPM_DIVISOR);
	}
}
