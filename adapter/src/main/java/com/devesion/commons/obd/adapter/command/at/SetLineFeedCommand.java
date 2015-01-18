package com.devesion.commons.obd.adapter.command.at;

/**
 * Represents AT Set Linefeed On/Off Command.
 */
public class SetLineFeedCommand extends AbstractSetStateCommand {

	private static final String SET_LINE_FEED_PREFIX = "L";

	public SetLineFeedCommand(boolean enabled) {
		super(SET_LINE_FEED_PREFIX, enabled);
	}
}
