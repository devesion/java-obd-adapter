package com.devesion.obd.command.protocol;

/**
 * Represents AT Set Linefeed On/Off Command.
 */
public class SetLineFeedCommand extends AbstractProtocolCommand {

	private boolean enabled;

	private SetLineFeedCommand(boolean enabled) {
		this.enabled = enabled;
	}

	public static SetLineFeedCommand on() {
		return new SetLineFeedCommand(true);
	}

	public static SetLineFeedCommand off() {
		return new SetLineFeedCommand(false);
	}

	@Override
	public String getOperands() {
		int enabledInt = enabled ? 1 : 0;
		return "L" + enabledInt;
	}
}
