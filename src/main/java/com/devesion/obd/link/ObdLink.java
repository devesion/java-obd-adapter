package com.devesion.obd.link;

import com.devesion.obd.command.CommandResult;
import com.devesion.obd.command.ObdCommand;

/**
 * Represents OBD link between two nodes (ie. bluetooth device and PC).
 */
public interface ObdLink {

	CommandResult sendCommand(ObdCommand command);
}
