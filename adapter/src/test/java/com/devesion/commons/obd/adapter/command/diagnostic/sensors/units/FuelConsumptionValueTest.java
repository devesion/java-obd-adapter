package com.devesion.commons.obd.adapter.command.diagnostic.sensors.units;

import com.devesion.commons.obd.adapter.command.CommandResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.MockitoAnnotations.initMocks;

public class FuelConsumptionValueTest extends BaseValueTest {

	@BeforeMethod
	private void beforeMethod() {
		initMocks(this);
	}

	@Test
	public void constructorShouldSetDefaultDivisorAndMultiplier() throws Exception {
		constructorShouldSetDefaultDivisorAndMultiplier(256, 20);
	}

	@Override
	protected AbstractSensorCommandValue createSut(CommandResult commandResultMock) {
		return new FuelConsumptionValue(commandResultMock);
	}
}