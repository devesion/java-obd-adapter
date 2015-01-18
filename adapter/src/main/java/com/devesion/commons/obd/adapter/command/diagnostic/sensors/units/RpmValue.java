package com.devesion.commons.obd.adapter.command.diagnostic.sensors.units;

import com.devesion.commons.obd.adapter.command.CommandResult;

/**
 * Represents RPM Value Object.
 */
class RpmValue extends SimpleValue {

	private static final float RPM_DIVISOR = 4.0f;

	RpmValue(CommandResult commandResult) {
		super(commandResult, RPM_DIVISOR);
	}
}
