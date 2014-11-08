package com.devesion.obd.command.protocol;

import org.testng.annotations.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class SetEchoCommandTest {

	private SetEchoCommand sut;

	@Test
	public void offShouldSetEchoOff() throws Exception {
		// given
		String expectedOperands = "E0";

		// when
		sut = SetEchoCommand.off();

		// then
		String operands = sut.getOperands();
		assertThat(operands).isEqualTo(expectedOperands);
	}

	@Test
	public void onShouldSetEchoOn() throws Exception {
		// given
		String expectedOperands = "E1";

		// when
		sut = SetEchoCommand.on();

		// then
		String operands = sut.getOperands();
		assertThat(operands).isEqualTo(expectedOperands);
	}
}