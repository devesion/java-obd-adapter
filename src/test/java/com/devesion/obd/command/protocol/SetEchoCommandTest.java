package com.devesion.obd.command.protocol;

import com.devesion.obd.TestSupport;
import org.testng.annotations.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class SetEchoCommandTest {

	private SetEchoCommand sut;

	@Test
	public void getOperandsShouldReturnProperElmCommand() throws Exception {
		// given
		boolean echoStatus = TestSupport.getRandomBoolean();
		int echoStatusInt = echoStatus ? 1 : 0;
		String expectedOperands = "E" + echoStatusInt;

		// when
		sut = new SetEchoCommand(echoStatus);
		String operands = sut.getOperands();

		// then
		assertThat(operands).isEqualTo(expectedOperands);
	}
}