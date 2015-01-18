package com.devesion.commons.obd.adapter.link;

import com.devesion.commons.obd.adapter.command.ObdCommand;
import com.devesion.commons.obd.adapter.command.CommandResult;

/**
 * Represents OBD command unmarshaller interface.
 */
public interface CommandUnmarshaller {

	CommandResult unmarshal(ObdCommand command, String data);
}
