package com.devesion.commons.obd.adapter.command.at;

/**
 * Represents AT Reset Command.
 */
public class EnableBaudRateCommand extends AbstractAtCommand {

	@Override
	public String getOperands() {
		return "PP 0C ON";
	}

	@Override
	public boolean checkResponseEnabled() {
		return false;
	}
}
