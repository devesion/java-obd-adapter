package com.devesion.commons.obd.command.diagnostic.sensors.units;

import com.devesion.commons.obd.command.CommandResult;

/**
 * Represents Air Flow Value Object.
 */
class AirFlowValue extends SimpleValue {

	private static final float AIR_FLOW_DIVISOR = 100.0f;

	AirFlowValue(CommandResult commandResult) {
		super(commandResult, AIR_FLOW_DIVISOR);
	}
}