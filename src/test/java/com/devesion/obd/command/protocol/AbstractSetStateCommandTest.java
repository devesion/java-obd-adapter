package com.devesion.obd.command.protocol;

import org.testng.annotations.Test;

import static org.fest.assertions.api.Assertions.assertThat;

abstract class AbstractSetStateCommandTest {

	private ProtocolCommand sut;

	@Test
	protected void constructorShouldSetStateOff() throws Exception {
		// given
		String expectedOperands = getOperandPrefix() + "0";

		// when
		sut = createCommand(false);

		// then
		String operands = sut.getOperands();
		assertThat(operands).isEqualTo(expectedOperands);
	}

	@Test
	protected void constructorShouldSetStateOn() throws Exception {
		// given
		String expectedOperands = getOperandPrefix() + "1";

		// when
		sut = createCommand(true);

		// then
		String operands = sut.getOperands();
		assertThat(operands).isEqualTo(expectedOperands);
	}

	protected abstract String getOperandPrefix();

	protected abstract ProtocolCommand createCommand(boolean state);
}