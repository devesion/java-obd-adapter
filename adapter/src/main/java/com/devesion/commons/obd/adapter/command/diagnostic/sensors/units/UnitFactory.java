package com.devesion.commons.obd.adapter.command.diagnostic.sensors.units;

import com.devesion.commons.obd.adapter.command.CommandResult;

public class UnitFactory {

	public SensorCommandValue createAirFlowValue(CommandResult commandResult) {
		return new AirFlowValue(commandResult);
	}

	public SensorCommandValue createFuelConsumptionValue(CommandResult commandResult) {
		return new FuelConsumptionValue(commandResult);
	}

	public SensorCommandValue createFuelLevelValue(CommandResult commandResult) {
		return new PercentageValue(commandResult);
	}

	public SensorCommandValue createFuelTypeValue(CommandResult commandResult) {
		return new FuelTypeValue(commandResult);
	}

	public SensorCommandValue createPercentageValue(CommandResult commandResult) {
		return new PercentageValue(commandResult);
	}

	public SensorCommandValue createPressureValue(CommandResult commandResult) {
		return new PressureValue(commandResult);
	}

	public SensorCommandValue createFuelPressureValue(CommandResult commandResult) {
		return new FuelPressureValue(commandResult);
	}

	public SensorCommandValue createRpmValue(CommandResult commandResult) {
		return new RpmValue(commandResult);
	}

	public SensorCommandValue createSpeedValue(CommandResult commandResult) {
		return new SpeedValue(commandResult);
	}

	public SensorCommandValue createTemperatureValue(CommandResult commandResult) {
		return new TemperatureValue(commandResult);
	}

	public SensorCommandValue createTimeValue(CommandResult commandResult) {
		return new TimeValue(commandResult);
	}

	public SensorCommandValue createVoltageValue(CommandResult commandResult) {
		return new VoltageValue(commandResult);
	}
}
