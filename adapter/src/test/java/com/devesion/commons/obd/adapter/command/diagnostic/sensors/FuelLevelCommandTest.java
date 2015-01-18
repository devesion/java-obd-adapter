package com.devesion.commons.obd.adapter.command.diagnostic.sensors;

import com.devesion.commons.obd.adapter.command.diagnostic.sensors.units.UnitFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.MockitoAnnotations.initMocks;

public class FuelLevelCommandTest extends BaseSensorCommandTest {

	private FuelLevelCommand sut;

	@BeforeMethod
	private void beforeMethod() {
		initMocks(this);

		sut = new FuelLevelCommand();
		UnitFactory unitFactoryMock = recordUnitFactoryCreatesFuelLevel();
		sut.setUnitFactory(unitFactoryMock);
	}

	@Test
	public void getPidShouldReturnObdPidForSensor() throws Exception {
		testCommandReturnsProperPid(sut, SensorCommandPid.FUEL_LEVEL);
	}

	@Test
	public void getValueShouldCreateFuelLevelValueObjectFromResultBuffer() throws Exception {
		testCommandGetValueCreateProperValueObject(sut);
	}
}