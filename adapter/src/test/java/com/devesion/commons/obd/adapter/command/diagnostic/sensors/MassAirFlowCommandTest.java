package com.devesion.commons.obd.adapter.command.diagnostic.sensors;

import com.devesion.commons.obd.adapter.command.diagnostic.sensors.units.UnitFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.MockitoAnnotations.initMocks;

public class MassAirFlowCommandTest extends BaseSensorCommandTest {

	private MassAirFlowCommand sut;

	@BeforeMethod
	private void beforeMethod() {
		initMocks(this);

		sut = new MassAirFlowCommand();
		UnitFactory unitFactoryMock = recordUnitFactoryCreatesAirFlow();
		sut.setUnitFactory(unitFactoryMock);
	}

	@Test
	public void getPidShouldReturnObdPidForSensor() throws Exception {
		testCommandReturnsProperPid(sut, SensorCommandPid.MASS_AIR_FLOW);
	}

	@Test
	public void getValueShouldCreateAirFlowValueObjectFromResultBuffer() throws Exception {
		testCommandGetValueCreateProperValueObject(sut);
	}
}