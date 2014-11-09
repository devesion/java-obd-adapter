package com.devesion.obd.command.invoker.marshaller;

import com.devesion.obd.command.ObdCommand;
import com.devesion.obd.command.diagnostic.DiagnosticCommand;
import com.devesion.obd.command.CommandResult;
import com.devesion.obd.shared.HexTools;
import com.devesion.obd.shared.ObdInvalidCommandResponseException;
import lombok.extern.slf4j.Slf4j;

import java.nio.IntBuffer;

@Slf4j
class DiagnosticCommandUnmarshaller extends AbstractCommandUnmarshaller {

	private static final String ELM_DIAGNOSTIC_ACK_OK = "41";
	private static final String ELM_DIAGNOSTIC_RESPONSE_REGEXP = "([0-9A-F]{2})+";
	private static final int ELM_MAX_COMMAND_RESPONSE_LENGTH = 256;

	@Override
	public CommandResult unmarshal(ObdCommand command, String responseData) {
		DiagnosticCommand diagnosticCommand = (DiagnosticCommand) command;
		log.info("unmarshaling response '{}", responseData);

		responseData = normalizeResponse(responseData);
		log.info("after normalization '{}", responseData);

		responseData = omitMagicSequence(diagnosticCommand, responseData);
		log.info("after omitting magic sequence '{}", responseData);

		checkResponse(responseData);
		checkDiagnosticResponse(responseData);

		IntBuffer responseBuffer = readByteBuffer(responseData);
		return CommandResult.withBuffer(responseBuffer);
	}

	private void checkDiagnosticResponse(String responseData) {
		if (!responseData.matches(ELM_DIAGNOSTIC_RESPONSE_REGEXP)) {
			throw new ObdInvalidCommandResponseException();
		}
	}

	private String omitMagicSequence(DiagnosticCommand command, String responseData) {
		String magicSequence = ELM_DIAGNOSTIC_ACK_OK + HexTools.toHexString(command.getPid());
		log.info("magic sequence {}", magicSequence);

		int magicSequenceIndex = responseData.indexOf(magicSequence);
		if (magicSequenceIndex < 0) {
			return responseData;
		}

		int magicSequenceLength = magicSequence.length();
		return responseData.substring(magicSequenceIndex + magicSequenceLength);
	}

	private IntBuffer readByteBuffer(String data) {
		IntBuffer buffer = IntBuffer.allocate(ELM_MAX_COMMAND_RESPONSE_LENGTH);
		int readByteIndex = 0;
		int readCharIndex = 0;
		while (readByteIndex < data.length()) {
			int readByte = HexTools.fromHexString(data, readByteIndex, readByteIndex + 2);
			buffer.put(readByte);
			readByteIndex += 2;
			readCharIndex += 1;

			if (readCharIndex >= ELM_MAX_COMMAND_RESPONSE_LENGTH) {
				break;
			}
		}

		buffer.flip();
		return buffer;
	}
}
