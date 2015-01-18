package com.devesion.commons.obd.adapter.command.diagnostic.sensors;

import com.devesion.commons.obd.adapter.command.diagnostic.DiagnosticCommand;
import com.devesion.commons.obd.adapter.command.diagnostic.sensors.units.SensorCommandValue;

public interface SensorCommand extends DiagnosticCommand {

	SensorCommandValue getValue();
}
