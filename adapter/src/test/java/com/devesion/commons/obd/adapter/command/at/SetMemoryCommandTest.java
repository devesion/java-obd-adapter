package com.devesion.commons.obd.adapter.command.at;

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
	protected AtCommand createCommand(boolean state) {
		return new SetMemoryCommand(state);
	}
}