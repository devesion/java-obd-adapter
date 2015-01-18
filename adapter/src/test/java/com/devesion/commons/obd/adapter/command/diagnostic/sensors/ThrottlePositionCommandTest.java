package com.devesion.commons.obd.adapter.command.diagnostic.sensors;

import com.devesion.commons.obd.adapter.command.diagnostic.sensors.units.UnitFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.MockitoAnnotations.initMocks;

public class ThrottlePositionCommandTest extends BaseSensorCommandTest {

	private ThrottlePositionCommand sut;

	@BeforeMethod
	private void beforeMethod() {
		initMocks(this);

		sut = new ThrottlePositionCommand();
		UnitFactory unitFactoryMock = recordUnitFactoryCreatesPercentage();
		sut.setUnitFactory(unitFactoryMock);
	}

	@Test
	public void getPidShouldReturnObdPidForSensor() throws Exception {
		testCommandReturnsProperPid(sut, SensorCommandPid.THROTTLE_POSITION_PERCENTAGE);
	}

	@Test
	public void getValueShouldCreatePercentageValueObjectFromResultBuffer() throws Exception {
		testCommandGetValueCreateProperValueObject(sut);
	}
}