package com.devesion.commons.obd.adapter.link;

import com.devesion.commons.obd.adapter.command.ObdCommand;

/**
 * Represents OBD command marshaller interface.
 */
public interface CommandMarshaller {

	String marshal(ObdCommand command);
}
