package com.devesion.obd.command.protocol;

import org.testng.annotations.Test;

public class SetMemoryCommandTest extends AbstractSetStateCommandTest {

	@Test
	public void constructorShouldSetMemoryOff() throws Exception {
		constructorShouldSetStateOff();
	}

	@Test
	public void constructorShouldSetMemoryOn() throws Exception {
		constructorShouldSetStateOn();
	}

	@Override
	protected String getOperandPrefix() {
		return "M";
	}

	@Override
	protected ProtocolCommand createCommand(boolean state) {
		return new SetMemoryCommand(state);
	}
}