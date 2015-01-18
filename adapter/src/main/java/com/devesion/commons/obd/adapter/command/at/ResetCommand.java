package com.devesion.commons.obd.adapter.command.at;

/**
 * Represents AT Reset Command.
 */
public class ResetCommand extends AbstractAtCommand {

	@Override
	public String getOperands() {
		return "Z";
	}

	@Override
	public boolean checkResponseEnabled() {
		return false;
	}
}
