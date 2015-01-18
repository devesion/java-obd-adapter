package com.devesion.commons.obd.command;

/**
 * Skeletal implementation of {@link com.devesion.commons.obd.command.ObdCommand} interface.
 */
public abstract class AbstractCommand implements ObdCommand {

	private CommandResult result;

	public CommandResult getResult() {
		return result;
	}

	@Override
	public void setResult(CommandResult result) {
		this.result = result;
	}

	@Override
	public boolean checkResponseEnabled() {
		return true;
	}
}
