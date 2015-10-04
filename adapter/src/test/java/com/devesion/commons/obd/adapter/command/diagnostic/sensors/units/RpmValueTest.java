package com.devesion.commons.obd.adapter.command.diagnostic.sensors.units;

import com.devesion.commons.obd.adapter.command.CommandResult;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.IntBuffer;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

@Slf4j
public class RpmValueTest extends BaseValueTest {

	@BeforeMethod
	private void beforeMethod() {
		initMocks(this);
	}

	@Test
	public void constructorShouldSetDefaultDivisorAndMultiplier() throws Exception {
		constructorShouldSetDefaultDivisorAndMultiplier(256, 4);
	}

	@Override
	protected AbstractSensorCommandValue createSut(CommandResult commandResultMock) {
		return new RpmValue(commandResultMock);
	}

	@DataProvider(name = "rpmValues")
	public Object[][] createData1() {
		return new Object[][] {
				{ IntBuffer.wrap(new int[]{0x0C, 0x99}), 806},
				{ IntBuffer.wrap(new int[]{0x0A, 0x96}), 677},
				{ IntBuffer.wrap(new int[]{0x0A, 0x7A}), 670},
				{ IntBuffer.wrap(new int[]{0x0A, 0x5A}), 662},
		};
	}

	@Test(dataProvider = "rpmValues")
	public void getIntValueShouldReturnProperValue(IntBuffer resultBuffer, float expectedValue) {
		// given
		CommandResult commandResult = CommandResult.withBuffer(resultBuffer);

		// when
		AbstractSensorCommandValue sut = new RpmValue(commandResult);
		sut.calculateValue();
        float value = sut.getIntValue();

		// then
		assertThat(value).isEqualTo(expectedValue);
	}
}