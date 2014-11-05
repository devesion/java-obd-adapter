package com.devesion.obd.command.diagnostic.sensors.units;

import com.devesion.obd.command.invoker.CommandResult;

/**
 *
 */
public class PressureValue extends AbstractSensorCommandValue {

	public PressureValue(CommandResult commandResult) {
		super(commandResult);
	}

	@Override
	protected float calculateValue() {
		return 0;
	}
}
