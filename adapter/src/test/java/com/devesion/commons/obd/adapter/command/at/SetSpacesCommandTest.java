package com.devesion.commons.obd.adapter.command.at;

import org.testng.annotations.Test;

public class SetSpacesCommandTest extends AbstractSetStateCommandTest {

	@Test
	public void constructorShouldSetSpacesOff() throws Exception {
		constructorShouldSetStateOff();
	}

	@Test
	public void constructorShouldSetSpacesOn() throws Exception {
		constructorShouldSetStateOn();
	}

	@Override
	protected String getOperandPrefix() {
		return "S";
	}

	@Override
	protected AtCommand createCommand(boolean state) {
		return new SetSpacesCommand(state);
	}
}