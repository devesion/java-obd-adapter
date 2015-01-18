package com.devesion.commons.obd.adapter.command.diagnostic.sensors;

import com.devesion.commons.obd.adapter.command.diagnostic.sensors.units.UnitFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.MockitoAnnotations.initMocks;

public class FuelConsumptionRateCommandTest extends BaseSensorCommandTest {

	private FuelConsumptionRateCommand sut;

	@BeforeMethod
	private void beforeMethod() {
		initMocks(this);

		sut = new FuelConsumptionRateCommand();
		UnitFactory unitFactoryMock = recordUnitFactoryCreatesFuelConsuption();
		sut.setUnitFactory(unitFactoryMock);
	}

	@Test
	public void getPidShouldReturnObdPidForSensor() throws Exception {
		testCommandReturnsProperPid(sut, SensorCommandPid.FUEL_CONSUMPTION_1);
	}

	@Test
	public void getValueShouldCreateFuelConsumptionValueObjectFromResultBuffer() throws Exception {
		testCommandGetValueCreateProperValueObject(sut);
	}
}