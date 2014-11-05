package com.devesion.obd.command.invoker;

import com.devesion.obd.shared.ObdInvalidCommandResponseException;
import com.devesion.obd.shared.ObdNoDataForCommandResponseException;

import java.nio.IntBuffer;

/**
 * Represents default OBD command marshaller implementation.
 */
public class DefaultCommandUnmarshaller implements CommandUnmarshaller {

	private static final int ACK_OK = 0x41;
	private static final int ACK_OK_SEQUENCE_LENGTH = 2;

	@Override
	public CommandResult unmarshal(String responseData) {
		if (responseData.contains("OK")) {
			return new CommandResult();
		}

		System.out.println(responseData);

		if (responseData.contains("NODATA")) {
			throw new ObdNoDataForCommandResponseException();
		}

		// check for errors

		IntBuffer responseBuffer = readByteBuffer(responseData);
		checkCommandResponse(responseData, responseBuffer);

		responseBuffer.position(ACK_OK_SEQUENCE_LENGTH);
		responseBuffer.compact();

		return new CommandResult(responseBuffer);
	}

	private void checkCommandResponse(String responseData, IntBuffer responseBuffer) {
		if (!responseData.matches("([0-9A-F]{2})+")) {
			throw new ObdInvalidCommandResponseException();
		}

		int ackByte = responseBuffer.get();
		if (ackByte != ACK_OK) {
			throw new ObdInvalidCommandResponseException();
		}
	}

	private IntBuffer readByteBuffer(String data) {
		IntBuffer buffer = IntBuffer.allocate(10);
		int readByteIndex = 0;
		while (readByteIndex < data.length()) {
			int readByte = readByte(data, readByteIndex, readByteIndex + 2);
			buffer.put(readByte);
			readByteIndex += 2;
		}

		buffer.flip();
		return buffer;
	}

	private int readByte(String data, int begin, int end) {
		return Integer.decode("0x" + data.substring(begin, end));
	}
}
