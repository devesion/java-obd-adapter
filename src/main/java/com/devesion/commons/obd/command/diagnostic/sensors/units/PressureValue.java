package com.devesion.commons.obd.command.diagnostic.sensors.units;

import com.devesion.commons.obd.command.CommandResult;

/**
 * Represents Pressure Value Object.
 */
class PressureValue extends AbstractSensorCommandValue {

	PressureValue(CommandResult commandResult) {
		super(commandResult);
	}

	@Override
	protected float calculateValue() {
		return 0;
	}
}
