package com.devesion.obd.command.diagnostic.sensors.units;

import com.devesion.obd.command.invoker.CommandResult;

/**
 * Represents Air Flow Value Object.
 */
public class AirFlowValue extends SimpleValue {

	private static final float AIR_FLOW_DIVISOR = 100.0f;

	public AirFlowValue(CommandResult commandResult) {
		super(commandResult, AIR_FLOW_DIVISOR);
	}
}
