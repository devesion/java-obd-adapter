package com.devesion.obd.command.protocol;

import org.testng.annotations.Test;

public class SetLineFeedCommandTest extends AbstractSetStateCommandTest {

	@Test
	public void constructorShouldSetLineFeedOff() throws Exception {
		constructorShouldSetStateOff();
	}

	@Test
	public void constructorShouldSetLineFeedOn() throws Exception {
		constructorShouldSetStateOn();
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