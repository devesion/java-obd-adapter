package com.devesion.commons.obd.adapter.command.at;

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
	protected AtCommand createCommand(boolean state) {
		return new SetEchoCommand(state);
	}
}