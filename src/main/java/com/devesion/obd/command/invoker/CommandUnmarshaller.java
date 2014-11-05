package com.devesion.obd.command.invoker;

/**
 * Represents OBD command unmarshaller interface.
 */
public interface CommandUnmarshaller {

	CommandResult unmarshal(String data);
}
