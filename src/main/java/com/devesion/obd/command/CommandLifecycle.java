package com.devesion.obd.command;

/**
 * Command lifecycle interface.
 */
public interface CommandLifecycle {

	void beforeResultSet();

	void afterResultSet();
}
