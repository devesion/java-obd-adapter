package com.devesion.obd.command.protocol;

/**
 * Represents AT Set Spacess On/Off Command.
 */
public class SetSpacesCommand extends AbstractProtocolCommand {

	private boolean enabled;

	private SetSpacesCommand(boolean enabled) {
		this.enabled = enabled;
	}

	public static SetSpacesCommand on() {
		return new SetSpacesCommand(true);
	}

	public static SetSpacesCommand off() {
		return new SetSpacesCommand(false);
	}

	@Override
	public String getOperands() {
		int enabledInt = enabled ? 1 : 0;
		return "S" + enabledInt;
	}
}
