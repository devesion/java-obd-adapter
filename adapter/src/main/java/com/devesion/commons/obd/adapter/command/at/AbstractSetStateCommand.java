package com.devesion.commons.obd.adapter.command.at;

/**
 * Represents AT set boolean state Command.
 */
public class AbstractSetStateCommand extends AbstractAtCommand {

	private final String operandPrefix;
	private final boolean enabled;

	public AbstractSetStateCommand(String operandPrefix, boolean enabled) {
		this.operandPrefix = operandPrefix;
		this.enabled = enabled;
	}

	@Override
	public String getOperands() {
		int enabledInt = enabled ? 1 : 0;
		return operandPrefix + enabledInt;
	}
}
