package com.devesion.obd.command.diagnostic.sensors;

import com.devesion.obd.command.diagnostic.DiagnosticCommand;
import com.devesion.obd.command.diagnostic.sensors.units.SensorCommandValue;

/**
 *
 */
public interface SensorCommand extends DiagnosticCommand {

	SensorCommandValue getValue();
}
