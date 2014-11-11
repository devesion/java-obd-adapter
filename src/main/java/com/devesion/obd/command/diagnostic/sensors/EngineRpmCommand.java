package com.devesion.obd.command.diagnostic.sensors;

import com.devesion.obd.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.obd.shared.ObdNumberedEnum;

/**
 * Reads current engine RPM.
 */
public class EngineRpmCommand extends AbstractSensorCommand {

	@Override
	public ObdNumberedEnum getPid() {
		return SensorCommandPid.ENGINE_RPM;
	}

	@Override
	public SensorCommandValue getValue() {
		return getUnitFactory().createRpmValue(getResult());
	}
}
