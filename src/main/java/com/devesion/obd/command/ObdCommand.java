package com.devesion.obd.command;

import com.devesion.obd.command.invoker.CommandResult;

/**
 * Represents OBD command interface.
 */
public interface ObdCommand {

	CommandResult getResult();

	void setResult(CommandResult result);

	void accept(ObdCommandVisitor visitor);
}
