package com.devesion.obd.command;

import com.devesion.obd.command.invoker.CommandResult;

/**
 * Represents OBD command interface.
 */
public interface ObdCommand {

	String getMnemonic();

	String getOperands();

	void setResult(CommandResult result);
}
