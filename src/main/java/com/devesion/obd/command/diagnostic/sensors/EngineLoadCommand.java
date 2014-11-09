package com.devesion.obd.command.diagnostic.sensors;

import com.devesion.obd.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.obd.shared.ObdNumberedEnum;
import lombok.EqualsAndHashCode;

/**
 * Reads current engine load.
 */
@EqualsAndHashCode(callSuper = true)
public class EngineLoadCommand extends AbstractSensorCommand {

	@Override
	public ObdNumberedEnum getPid() {
		return SensorCommandPids.ENGINE_LOAD;
	}

	@Override
	public SensorCommandValue getValue() {
		return getUnitFactory().createPercentageValue(getResult());
	}
}
