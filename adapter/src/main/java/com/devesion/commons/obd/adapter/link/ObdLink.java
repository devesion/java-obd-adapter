package com.devesion.commons.obd.adapter.link;

import com.devesion.commons.obd.adapter.command.CommandResult;
import com.devesion.commons.obd.adapter.command.ObdCommand;

/**
 * Represents OBD link between two nodes (ie. bluetooth device and PC).
 */
public interface ObdLink {

	CommandResult sendCommand(ObdCommand command);
}
