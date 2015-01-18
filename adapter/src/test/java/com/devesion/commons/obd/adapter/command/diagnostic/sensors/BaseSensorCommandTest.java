package com.devesion.commons.obd.adapter.command.diagnostic.sensors;

import com.devesion.commons.obd.adapter.command.CommandResult;
import com.devesion.commons.obd.adapter.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.commons.obd.adapter.command.diagnostic.sensors.units.UnitFactory;
import com.devesion.commons.obd.adapter.shared.ObdNumberedEnum;
import org.mockito.Mock;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

abstract class BaseSensorCommandTest {

	@Mock
	private UnitFactory unitFactoryMock;

	@Mock
	private CommandResult commandResultMock;

	@Mock
	private SensorCommandValue sensorCommandValueMock;

	protected void testCommandReturnsProperPid(SensorCommand sut, SensorCommandPid pid) {
		// given

		// when
		ObdNumberedEnum mode = sut.getPid();

		// then
		assertThat(mode).isEqualTo(pid);
	}

	protected void testCommandGetValueCreateProperValueObject(SensorCommand sut) {
		// given
		sut.setResult(commandResultMock);

		// when
		SensorCommandValue value = sut.getValue();

		// then
		assertThat(value).isEqualTo(sensorCommandValueMock);
	}

	protected UnitFactory recordUnitFactoryCreatesTemperature() {
		when(unitFactoryMock.createTemperatureValue(commandResultMock)).thenReturn(sensorCommandValueMock);
		return unitFactoryMock;
	}

	protected UnitFactory recordUnitFactoryCreatesPercentage() {
		when(unitFactoryMock.createPercentageValue(commandResultMock)).thenReturn(sensorCommandValueMock);
		return unitFactoryMock;
	}

	protected UnitFactory recordUnitFactoryCreatesRpm() {
		when(unitFactoryMock.createRpmValue(commandResultMock)).thenReturn(sensorCommandValueMock);
		return unitFactoryMock;
	}

	protected UnitFactory recordUnitFactoryCreatesTime() {
		when(unitFactoryMock.createTimeValue(commandResultMock)).thenReturn(sensorCommandValueMock);
		return unitFactoryMock;
	}

	protected UnitFactory recordUnitFactoryCreatesFuelConsuption() {
		when(unitFactoryMock.createFuelConsumptionValue(commandResultMock)).thenReturn(sensorCommandValueMock);
		return unitFactoryMock;
	}

	protected UnitFactory recordUnitFactoryCreatesFuelLevel() {
		when(unitFactoryMock.createFuelLevelValue(commandResultMock)).thenReturn(sensorCommandValueMock);
		return unitFactoryMock;
	}

	protected UnitFactory recordUnitFactoryCreatesFuelType() {
		when(unitFactoryMock.createFuelTypeValue(commandResultMock)).thenReturn(sensorCommandValueMock);
		return unitFactoryMock;
	}

	protected UnitFactory recordUnitFactoryCreatesAirFlow() {
		when(unitFactoryMock.createAirFlowValue(commandResultMock)).thenReturn(sensorCommandValueMock);
		return unitFactoryMock;
	}
}
