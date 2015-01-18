package com.devesion.commons.obd.command.diagnostic.sensors;

import com.devesion.commons.obd.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.commons.obd.shared.ObdNumberedEnum;

/**
 * Reads current engine run time.
 */
public class EngineRuntimeCommand extends AbstractSensorCommand {

	@Override
	public ObdNumberedEnum getPid() {
		return SensorCommandPid.ENGINE_RUN_TIME;
	}

	@Override
	public SensorCommandValue getValue() {
		return getUnitFactory().createTimeValue(getResult());
	}
}
