package com.devesion.obd.command.invoker;

import com.devesion.obd.command.ObdCommand;

/**
 * Represents default OBD command marshaller implementation.
 */
public class DefaultCommandMarshaller implements CommandMarshaller {

	private static final String SPACE = " ";
	private static final String CR = "\r";

	@Override
	public String marshal(ObdCommand command) {
		String commandMnemonic = command.getMnemonic();
		String commandOperands = command.getOperands();
		return commandMnemonic + SPACE + commandOperands + CR;
	}
}
