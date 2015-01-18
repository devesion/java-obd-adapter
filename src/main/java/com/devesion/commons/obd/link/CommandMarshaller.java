package com.devesion.commons.obd.link;

import com.devesion.commons.obd.command.ObdCommand;

/**
 * Represents OBD command marshaller interface.
 */
public interface CommandMarshaller {

	String marshal(ObdCommand command);
}
