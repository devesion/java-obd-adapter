package com.devesion.obd.command;

import com.devesion.obd.command.invoker.CommandResult;

/**
 * Skeletal implementation of {@link com.devesion.obd.command.ObdCommand} interface.
 */
public abstract class AbstractCommand implements ObdCommand, CommandLifecycle {

	private CommandResult result;

	public CommandResult getResult() {
		return result;
	}

	@Override
	public void setResult(CommandResult result) {
		beforeResultSet();
		this.result = result;
		afterResultSet();
	}

	@Override
	public void beforeResultSet() {
	}

	@Override
	public void afterResultSet() {
	}
}
