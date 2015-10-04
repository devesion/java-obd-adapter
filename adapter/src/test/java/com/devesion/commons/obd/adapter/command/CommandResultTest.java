package com.devesion.commons.obd.adapter.command;

import com.devesion.commons.obd.TestSupport;
import org.testng.annotations.Test;

import java.nio.IntBuffer;

import static org.fest.assertions.api.Assertions.assertThat;

public class CommandResultTest {

	private CommandResult sut;

	@Test
	public void withBufferShouldCreateResultWithPassedBuffer() throws Exception {
		// given
		IntBuffer expectedResponseBuffer = IntBuffer.allocate(0);

		// when
        sut = CommandResult.withBuffer(expectedResponseBuffer);
		IntBuffer responseBuffer = sut.getResponseBuffer();

		// then
		assertThat(responseBuffer).isEqualTo(expectedResponseBuffer);
	}

	@Test
	public void emptyShouldCreateResultWithEmptyBuffer() throws Exception {
		// given

		// when
		sut = CommandResult.empty();
		IntBuffer responseBuffer = sut.getResponseBuffer();

		// then
		assertThat(responseBuffer.limit()).isEqualTo(10);
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