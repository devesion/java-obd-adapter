package com.devesion.obd.command.invoker.marshaller;

import com.devesion.obd.command.ObdCommand;
import com.devesion.obd.command.diagnostic.DiagnosticCommand;
import com.devesion.obd.command.invoker.CommandResult;
import com.devesion.obd.shared.HexTools;
import com.devesion.obd.shared.ObdInvalidCommandResponseException;
import lombok.extern.slf4j.Slf4j;

import java.nio.IntBuffer;

@Slf4j
class DiagnosticCommandUnmarshaller extends AbstractCommandUnmarshaller {

	private static final String ELM_DIAGNOSTIC_ACK_OK = "41";
	private static final String ELM_DIAGNOSTIC_RESPONSE_REGEXP = "([0-9A-F]{2})+";

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
		return new CommandResult(responseBuffer);
	}

	private void checkDiagnosticResponse(String responseData) {
		if (!responseData.matches(ELM_DIAGNOSTIC_RESPONSE_REGEXP)) {
			throw new ObdInvalidCommandResponseException();
		}
	}

	private String omitMagicSequence(DiagnosticCommand command, String responseData) {
		String magicSequence = ELM_DIAGNOSTIC_ACK_OK + HexTools.toHexString(command.getPid());
		log.info("magic sequence {}", magicSequence);
		int magicSequenceLength = magicSequence.length();

		int magicSequenceIndex = responseData.indexOf(magicSequence);
		if (magicSequenceIndex < 0) {
			return responseData;
		}

		return responseData.substring(magicSequenceIndex + magicSequenceLength);
	}

	private IntBuffer readByteBuffer(String data) {
		IntBuffer buffer = IntBuffer.allocate(10);
		int readByteIndex = 0;
		while (readByteIndex < data.length()) {
			int readByte = HexTools.fromHexString(data, readByteIndex, readByteIndex + 2);
			buffer.put(readByte);
			readByteIndex += 2;
		}

		buffer.flip();
		return buffer;
	}
}
