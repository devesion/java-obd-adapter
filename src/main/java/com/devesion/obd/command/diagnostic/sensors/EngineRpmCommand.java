package com.devesion.obd.command.diagnostic.sensors;

import com.devesion.obd.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.obd.shared.ObdNumberedEnum;
import lombok.EqualsAndHashCode;

/**
 * Reads current engine RPM.
 */
@EqualsAndHashCode(callSuper = true)
public class EngineRpmCommand extends AbstractSensorCommand {

	@Override
	public ObdNumberedEnum getPid() {
		return SensorCommandPids.ENGINE_RPM;
	}

	@Override
	public SensorCommandValue getValue() {
		return getUnitFactory().createRpmValue(getResult());
	}
}
