package com.devesion.commons.obd.adapter.command.diagnostic.sensors.units;

import com.devesion.commons.obd.adapter.command.CommandResult;

/**
 * Represents Percentage Value Object.
 */
class PercentageValue extends AbstractSensorCommandValue {

	PercentageValue(CommandResult commandResult) {
		super(commandResult);
	}

	@Override
	protected float calculateValue() {
		int majorByte = getResultByteNumber(0);
		return (majorByte * 100.0f) / 255.0f;
	}
}
