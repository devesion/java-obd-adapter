package com.devesion.commons.obd.adapter.command;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;

import java.nio.IntBuffer;

/**
 * Represents OBD command result.
 */
@ToString
public class CommandResult {

	@Getter(AccessLevel.PACKAGE)
	private IntBuffer responseBuffer;

	private CommandResult(IntBuffer responseBuffer) {
		this.responseBuffer = responseBuffer;
	}

	public static CommandResult empty() {
		return withBuffer(IntBuffer.allocate(10));
	}

	public static CommandResult withBuffer(IntBuffer responseBuffer) {
		return new CommandResult(responseBuffer);
	}

	public int getByteNumber(int byteNumber) {
		return responseBuffer.get(byteNumber);
	}
}
