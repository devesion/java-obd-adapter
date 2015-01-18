package com.devesion.commons.obd.adapter.command.diagnostic.sensors.units;

import com.devesion.commons.obd.adapter.command.CommandResult;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.devesion.commons.obd.TestSupport.getRandomIntByte;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class SimpleValueTest {

	@Mock
	private CommandResult commandResultMock;

	private SimpleValue sut;

	@BeforeMethod
	private void beforeMethod() {
		initMocks(this);
		recordCommandResultMockBehavior();
	}

	@Test
	public void testCalculateValue() throws Exception {
		// given
		int randomMultiplier = getRandomIntByte();
		int randomDivisor = getRandomIntByte();
		float expectedCalculatedValue = getExpectedCalculatedValue(randomMultiplier, randomDivisor);

		sut = new SimpleValue(commandResultMock, randomMultiplier, randomDivisor);

		// when
		float calculatedValue = sut.calculateValue();

		// then
		assertThat(calculatedValue).isEqualTo(expectedCalculatedValue);
	}

	@Test
	public void calculateValueShouldUseDefaultMultiplier() throws Exception {
		// given
		int defaultMultiplier = 255;
		int randomDivisor = getRandomIntByte();
		float expectedCalculatedValue = getExpectedCalculatedValue(defaultMultiplier, randomDivisor);

		sut = new SimpleValue(commandResultMock, defaultMultiplier, randomDivisor);

		// when
		float calculatedValue = sut.calculateValue();

		// then
		assertThat(calculatedValue).isEqualTo(expectedCalculatedValue);
	}

	private float getExpectedCalculatedValue(int randomMultiplier, float randomDivisor) {
		return (commandResultMock.getByteNumber(0) * randomMultiplier + commandResultMock.getByteNumber(1)) / randomDivisor;
	}

	private void recordCommandResultMockBehavior() {
		int randomMajorByte = getRandomIntByte();
		int randomMinorByte = getRandomIntByte();
		when(commandResultMock.getByteNumber(0)).thenReturn(randomMajorByte);
		when(commandResultMock.getByteNumber(1)).thenReturn(randomMinorByte);
	}
}