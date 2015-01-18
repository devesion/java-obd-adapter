package com.devesion.commons.obd.link;

import com.devesion.commons.obd.command.CommandResult;
import com.devesion.commons.obd.command.ObdCommand;

/**
 * Represents OBD link between two nodes (ie. bluetooth device and PC).
 */
public interface ObdLink {

	CommandResult sendCommand(ObdCommand command);
}
