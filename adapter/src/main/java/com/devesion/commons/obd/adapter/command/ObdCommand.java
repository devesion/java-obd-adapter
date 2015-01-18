package com.devesion.commons.obd.adapter.command;

/**
 * Represents OBD command interface.
 */
public interface ObdCommand {

	CommandResult getResult();

	void setResult(CommandResult result);

	boolean checkResponseEnabled();

	void accept(ObdCommandVisitor visitor);
}
