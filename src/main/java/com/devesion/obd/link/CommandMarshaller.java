package com.devesion.obd.link;

import com.devesion.obd.command.ObdCommand;

/**
 * Represents OBD command marshaller interface.
 */
public interface CommandMarshaller {

	String marshal(ObdCommand command);
}
