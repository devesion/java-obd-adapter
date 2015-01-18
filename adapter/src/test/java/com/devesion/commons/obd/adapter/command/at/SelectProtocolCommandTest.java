package com.devesion.commons.obd.adapter.command.at;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class SelectProtocolCommandTest {

	private SelectProtocolCommand sut;

	@BeforeMethod
	private void beforeMethod() {
		sut = new SelectProtocolCommand();
	}

	@Test
	public void getOperandsShouldReturnProperElmCommand() throws Exception {
		// given
		String expectedOperands = "SP 0";

		// when
		String operands = sut.getOperands();

		// then
		assertThat(operands).isEqualTo(expectedOperands);
	}
}