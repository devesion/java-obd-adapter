package com.devesion.obd.command.invoker;

import lombok.ToString;

import java.nio.IntBuffer;

/**
 * Represents OBD command result.
 */
@ToString
public class CommandResult {

	private IntBuffer responseBuffer;

	public CommandResult() {
		this.responseBuffer = IntBuffer.allocate(0);
	}

	public CommandResult(IntBuffer responseBuffer) {
		this.responseBuffer = responseBuffer;
	}

	public int getByteNumber(int byteNumber) {
		return responseBuffer.get(byteNumber);
	}
}
