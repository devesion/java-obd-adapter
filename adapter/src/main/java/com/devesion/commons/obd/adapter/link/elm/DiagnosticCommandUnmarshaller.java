package com.devesion.commons.obd.adapter.link.elm;

import com.devesion.commons.obd.adapter.command.ObdCommand;
import com.devesion.commons.obd.adapter.command.diagnostic.DiagnosticCommand;
import com.devesion.commons.obd.adapter.command.CommandResult;
import com.devesion.commons.obd.adapter.shared.HexTools;
import com.devesion.commons.obd.adapter.shared.ObdInvalidCommandResponseException;
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
		log.debug("unmarshaling response");
		log.debug(responseData);

		responseData = normalizeResponse(responseData);
		log.debug("after normalization '{}'", responseData);

		responseData = omitMagicSequence(diagnosticCommand, responseData);
		log.debug("after omitting magic sequence '{}'", responseData);

		checkResponse(command, responseData);
		checkDiagnosticResponse(command, responseData);

		IntBuffer responseBuffer = readByteBuffer(responseData);
		return CommandResult.withBuffer(responseBuffer);
	}

	private void checkDiagnosticResponse(ObdCommand command, String responseData) {
		if (!responseData.matches(ELM_DIAGNOSTIC_RESPONSE_REGEXP)) {
			throw new ObdInvalidCommandResponseException(command, responseData);
		}
	}

	private String omitMagicSequence(DiagnosticCommand command, String responseData) {
		String magicSequence = ELM_DIAGNOSTIC_ACK_OK + HexTools.toHexString(command.getPid());
		log.debug("magic sequence {}", magicSequence);

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
