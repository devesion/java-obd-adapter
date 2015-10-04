package com.devesion.commons.obd.adapter.command.at;

/**
 * Represents AT Reset Command.
 */
public class SetBaudRateCommand extends AbstractAtCommand {

	@Override
	public String getOperands() {
		return "PP 0C SV 23";
	}

	@Override
	public boolean checkResponseEnabled() {
		return false;
	}
}
