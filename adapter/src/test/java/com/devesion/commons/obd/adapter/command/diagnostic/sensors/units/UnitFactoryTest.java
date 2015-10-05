package com.devesion.commons.obd.adapter.command.diagnostic.sensors.units;

import com.devesion.commons.obd.adapter.command.CommandResult;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

public class UnitFactoryTest {

	@Mock
	private CommandResult commandResultMock;

	private UnitFactory sut;

	@BeforeMethod
	private void beforeMethod() {
		initMocks(this);
		sut = new UnitFactory();
	}

	@Test
	public void testCreateAirFlowValue() throws Exception {
		// given

		// when
		SensorCommandValue valueObject = sut.createAirFlowValue(commandResultMock);

		// then
		assertValueObjectHasProperTypeAndResult(valueObject, AirFlowValue.class);
	}

	@Test
	public void testCreateFuelConsumptionValue() throws Exception {
		// given

		// when
		SensorCommandValue valueObject = sut.createFuelConsumptionValue(commandResultMock);

		// then
		assertValueObjectHasProperTypeAndResult(valueObject, FuelConsumptionValue.class);
	}

	@Test
	public void testCreateFuelLevelValue() throws Exception {
		// given

		// when
		SensorCommandValue valueObject = sut.createFuelLevelValue(commandResultMock);

		// then
		assertValueObjectHasProperTypeAndResult(valueObject, PercentageValue.class);
	}

	@Test
	public void testCreateFuelTypeValue() throws Exception {
		// given

		// when
		SensorCommandValue valueObject = sut.createFuelTypeValue(commandResultMock);

		// then
		assertValueObjectHasProperTypeAndResult(valueObject, FuelTypeValue.class);
	}

	@Test
	public void testCreatePercentageValue() throws Exception {
		// given

		// when
		SensorCommandValue valueObject = sut.createPercentageValue(commandResultMock);

		// then
		assertValueObjectHasProperTypeAndResult(valueObject, PercentageValue.class);
	}

	@Test
	public void testCreatePressureValue() throws Exception {
		// given

		// when
		SensorCommandValue valueObject = sut.createPressureValue(commandResultMock);

		// then
		assertValueObjectHasProperTypeAndResult(valueObject, PressureValue.class);
	}

	@Test
	public void testCreateRpmValue() throws Exception {
		// given

		// when
		SensorCommandValue valueObject = sut.createRpmValue(commandResultMock);

		// then
		assertValueObjectHasProperTypeAndResult(valueObject, RpmValue.class);
	}

	@Test
	public void testCreateTemperatureValue() throws Exception {
		// given

		// when
		SensorCommandValue valueObject = sut.createTemperatureValue(commandResultMock);

		// then
		assertValueObjectHasProperTypeAndResult(valueObject, TemperatureValue.class);
	}

	@Test
	public void testCreateTimeValue() throws Exception {
		// given

		// when
		SensorCommandValue valueObject = sut.createTimeValue(commandResultMock);

		// then
		assertValueObjectHasProperTypeAndResult(valueObject, TimeValue.class);
	}

	@Test
	public void testCreateVoltageValue() throws Exception {
		// given

		// when
		SensorCommandValue valueObject = sut.createVoltageValue(commandResultMock);

		// then
		assertValueObjectHasProperTypeAndResult(valueObject, VoltageValue.class);
	}

	@SuppressWarnings("unchecked")
	private <T extends AbstractSensorCommandValue> void assertValueObjectHasProperTypeAndResult(SensorCommandValue valueObject, Class<T> instanceClass) {
		assertThat(valueObject).isInstanceOf(instanceClass);
		assertThat(((T) valueObject).getCommandResult()).isEqualTo(commandResultMock);
	}
}