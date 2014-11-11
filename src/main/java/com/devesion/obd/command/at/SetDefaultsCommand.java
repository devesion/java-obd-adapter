package com.devesion.obd.command.at;

/**
 * Represents AT Defaults Command.
 */
public class SetDefaultsCommand extends AbstractAtCommand {

	@Override
	public String getOperands() {
		return "D";
	}
}
