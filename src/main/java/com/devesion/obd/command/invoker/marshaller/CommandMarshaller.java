package com.devesion.obd.command.invoker.marshaller;

import com.devesion.obd.command.ObdCommand;

/**
 * Represents OBD command marshaller interface.
 */
public interface CommandMarshaller {

	String marshal(ObdCommand command);
}
