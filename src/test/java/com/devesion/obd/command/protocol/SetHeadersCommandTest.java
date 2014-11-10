package com.devesion.obd.command.protocol;

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
	protected ProtocolCommand createCommand(boolean state) {
		return new SetHeadersCommand(state);
	}
}