package com.devesion.obd.command.diagnostic.sensors.units;

import com.devesion.obd.command.invoker.CommandResult;

/**
 * Represents Fuel Level Value Object.
 */
public class FuelLevelValue extends SimpleValue {

	public FuelLevelValue(CommandResult commandResult) {
		super(commandResult, 100, 255);
	}
}
