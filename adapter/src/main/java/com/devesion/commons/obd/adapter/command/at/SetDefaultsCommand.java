package com.devesion.commons.obd.adapter.command.at;

/**
 * Represents AT Defaults Command.
 */
public class SetDefaultsCommand extends AbstractAtCommand {

	@Override
	public String getOperands() {
		return "D";
	}
}
