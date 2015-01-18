package com.devesion.commons.obd.adapter.command.at;

/**
 * Represents AT Set Headers On/Off Command.
 */
public class SetHeadersCommand extends AbstractSetStateCommand {

	private static final String SET_HEADERS_PREFIX = "H";

	public SetHeadersCommand(boolean enabled) {
		super(SET_HEADERS_PREFIX, enabled);
	}
}
