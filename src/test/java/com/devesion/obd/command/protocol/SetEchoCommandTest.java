package com.devesion.obd.command.protocol;

import org.testng.annotations.Test;

public class SetEchoCommandTest extends AbstractSetStateCommandTest {

	@Test
	public void constructorShouldSetEchoOff() throws Exception {
		constructorShouldSetStateOff();
	}

	@Test
	public void constructorShouldSetEchoOn() throws Exception {
		constructorShouldSetStateOn();
	}

	@Override
	protected String getOperandPrefix() {
		return "E";
	}

	@Override
	protected ProtocolCommand createCommand(boolean state) {
		return new SetEchoCommand(state);
	}
}