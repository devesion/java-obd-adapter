package com.devesion.commons.obd.adapter.command.at;

import org.testng.annotations.Test;

public class SetHeadersCommandTest extends AbstractSetStateCommandTest {

	@Test
	public void constructorShouldSetHeadersOff() throws Exception {
		constructorShouldSetStateOff();
	}

	@Test
	public void constructorShouldSetHeadersOn() throws Exception {
		constructorShouldSetStateOn();
	}

	@Override
	protected String getOperandPrefix() {
		return "H";
	}

	@Override
	protected AtCommand createCommand(boolean state) {
		return new SetHeadersCommand(state);
	}
}