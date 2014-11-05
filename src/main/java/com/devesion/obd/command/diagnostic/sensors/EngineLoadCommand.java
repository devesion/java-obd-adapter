package com.devesion.obd.command.diagnostic.sensors;

import com.devesion.obd.command.diagnostic.sensors.units.PercentageValue;
import com.devesion.obd.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.obd.shared.ObdNumberedEnum;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Reads current engine load.
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class EngineLoadCommand extends AbstractSensorCommand {

	@Override
	public ObdNumberedEnum getPid() {
		return SensorCommandPids.ENGINE_LOAD;
	}

	@Override
	public SensorCommandValue getValue() {
		return new PercentageValue(getResult());
	}
}
