package com.devesion.commons.obd.adapter.command.diagnostic.sensors;

import com.devesion.commons.obd.adapter.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.commons.obd.adapter.shared.ObdNumberedEnum;

/**
 * Reads current engine load.
 */
public class EngineLoadCommand extends AbstractSensorCommand {

	@Override
	public ObdNumberedEnum getPid() {
		return SensorCommandPid.ENGINE_LOAD;
	}

	@Override
	public SensorCommandValue getValue() {
		return getUnitFactory().createPercentageValue(getResult());
	}
}
