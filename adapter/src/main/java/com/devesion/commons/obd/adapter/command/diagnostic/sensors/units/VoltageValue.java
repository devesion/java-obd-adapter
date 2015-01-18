package com.devesion.commons.obd.adapter.command.diagnostic.sensors.units;

import com.devesion.commons.obd.adapter.command.CommandResult;

/**
 * Represents Voltage Value Object.
 */
class VoltageValue extends AbstractSensorCommandValue {

	VoltageValue(CommandResult commandResult) {
		super(commandResult);
	}

	@Override
	protected float calculateValue() {
		return 0;
	}
}
