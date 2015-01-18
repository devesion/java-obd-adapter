package com.devesion.commons.obd.link;

import com.devesion.commons.obd.command.ObdCommand;
import com.devesion.commons.obd.command.CommandResult;

/**
 * Represents OBD command unmarshaller interface.
 */
public interface CommandUnmarshaller {

	CommandResult unmarshal(ObdCommand command, String data);
}
