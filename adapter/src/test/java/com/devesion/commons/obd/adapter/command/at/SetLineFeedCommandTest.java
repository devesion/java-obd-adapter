package com.devesion.commons.obd.adapter.command.at;

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
	protected AtCommand createCommand(boolean state) {
		return new SetLineFeedCommand(state);
	}
}