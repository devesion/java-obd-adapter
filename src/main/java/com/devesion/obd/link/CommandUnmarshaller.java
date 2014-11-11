package com.devesion.obd.link;

import com.devesion.obd.command.ObdCommand;
import com.devesion.obd.command.CommandResult;

/**
 * Represents OBD command unmarshaller interface.
 */
public interface CommandUnmarshaller {

	CommandResult unmarshal(ObdCommand command, String data);
}
