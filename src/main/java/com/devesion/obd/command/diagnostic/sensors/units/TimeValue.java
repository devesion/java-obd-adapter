package com.devesion.obd.command.diagnostic.sensors.units;

import com.devesion.obd.command.CommandResult;

/**
 * Represents Time Value Object.
 */
class TimeValue extends SimpleValue {

	private static final float RPM_DIVISOR = 1.0f;

	TimeValue(CommandResult commandResult) {
		super(commandResult, RPM_DIVISOR);
	}
}
