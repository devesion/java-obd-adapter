package com.devesion.commons.obd.adapter.command.diagnostic.sensors;

import com.devesion.commons.obd.adapter.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.commons.obd.adapter.shared.ObdNumberedEnum;

/**
 * Reads current MAF value.
 */
public class MassAirFlowCommand extends AbstractSensorCommand {

	@Override
	public ObdNumberedEnum getPid() {
		return SensorCommandPid.MASS_AIR_FLOW;
	}

	@Override
	public SensorCommandValue getValue() {
		return getUnitFactory().createAirFlowValue(getResult());
	}
}
