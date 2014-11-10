package com.devesion.obd.command.protocol;

import org.testng.annotations.Test;

public class SetLineFeedCommandTest extends AbstractSetStateCommandTest {

	@Test
	public void constructorShouldSetStateOff() throws Exception {
		super.constructorShouldSetStateOff();
	}

	@Test
	public void constructorShouldSetStateOn() throws Exception {
		super.constructorShouldSetStateOn();
	}

	@Override
	protected String getOperandPrefix() {
		return "L";
	}

	@Override
	protected ProtocolCommand createCommand(boolean state) {
		return new SetLineFeedCommand(state);
	}
}