package com.devesion.obd.command.protocol;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public abstract class AbstractSetStateCommandTest {

	private ProtocolCommand sut;

	@Test
	public void constructorShouldSetSpacesOff() throws Exception {
		// given
		String expectedOperands = getOperandPrefix() + "0";

		// when
		sut = createCommand(false);

		// then
		String operands = sut.getOperands();
		assertThat(operands).isEqualTo(expectedOperands);
	}

	@Test
	public void constructorShouldSetEchoOn() throws Exception {
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