package com.devesion.obd.command.diagnostic.sensors.units;

import com.devesion.obd.command.CommandResult;

/**
 * Represents Fuel Level Value Object.
 */
class FuelLevelValue extends SimpleValue {

	FuelLevelValue(CommandResult commandResult) {
		super(commandResult, 100, 255);
	}
}
