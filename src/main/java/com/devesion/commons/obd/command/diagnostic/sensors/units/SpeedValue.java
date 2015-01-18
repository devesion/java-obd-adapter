package com.devesion.commons.obd.command.diagnostic.sensors.units;

import com.devesion.commons.obd.command.CommandResult;

/**
 * Represents Speeds Value Object.
 */
class SpeedValue extends AbstractSensorCommandValue {

	SpeedValue(CommandResult commandResult) {
		super(commandResult);
	}

	@Override
	protected float calculateValue() {
		return getResultByteNumber(0);
	}
}
