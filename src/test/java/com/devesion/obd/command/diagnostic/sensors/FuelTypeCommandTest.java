package com.devesion.obd.command.diagnostic.sensors;

import com.devesion.obd.command.diagnostic.sensors.units.UnitFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.MockitoAnnotations.initMocks;

public class FuelTypeCommandTest extends BaseSensorCommandTest {

	private FuelTypeCommand sut;

	@BeforeMethod
	private void beforeMethod() {
		initMocks(this);

		sut = new FuelTypeCommand();
		UnitFactory unitFactoryMock = recordUnitFactoryCreatesFuelType();
		sut.setUnitFactory(unitFactoryMock);
	}

	@Test
	public void getPidShouldReturnObdPidForSensor() throws Exception {
		testCommandReturnsProperPid(sut, SensorCommandPids.FUEL_TYPE);
	}

	@Test
	public void getValueShouldCreateFuelTypeValueObjectFromResultBuffer() throws Exception {
		testCommandGetValueCreateProperValueObject(sut);
	}
}