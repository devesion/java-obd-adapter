package com.devesion.obd.command.invoker;

import com.devesion.obd.TestSupport;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.IntBuffer;

import static org.fest.assertions.api.Assertions.assertThat;

public class CommandResultTest {

	private CommandResult sut;

	@BeforeMethod
	private void beforeMethod() {
	}

	@Test
	public void constructorShouldSetPassedBuffer() throws Exception {
		// given
		IntBuffer expectedResponseBuffer = IntBuffer.allocate(0);

		// when
        sut = CommandResult.withBuffer(expectedResponseBuffer);
		IntBuffer responseBuffer = sut.getResponseBuffer();

		// then
		assertThat(responseBuffer).isEqualTo(expectedResponseBuffer);
	}

	@Test
	public void getByteNumberShouldReturnProperByteFromBuffer() throws Exception {
		// given
		int responseBufferLength = 100;
		IntBuffer expectedResponseBuffer = IntBuffer.allocate(responseBufferLength);
		for (int i = 0; i < responseBufferLength; i++) {
			int randomValue = TestSupport.getRandomInt();
			expectedResponseBuffer.put(randomValue);
		}

		// when
		sut = CommandResult.withBuffer(expectedResponseBuffer);

		boolean valuesAreNotEqual = false;
		for (int i = 0; i < responseBufferLength; i++) {
			int readValue = sut.getByteNumber(i);
			int expectedValue = expectedResponseBuffer.get(i);
			valuesAreNotEqual |= (readValue != expectedValue);
		}

		// then
		assertThat(valuesAreNotEqual).isFalse();
	}
}