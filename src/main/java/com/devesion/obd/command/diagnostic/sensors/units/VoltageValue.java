package com.devesion.obd.command.diagnostic.sensors.units;

import com.devesion.obd.command.invoker.CommandResult;

/**
 *
 */
public class VoltageValue extends AbstractSensorCommandValue {

	public VoltageValue(CommandResult commandResult) {
		super(commandResult);
	}

	@Override
	protected float calculateValue() {
		return 0;
	}
}
