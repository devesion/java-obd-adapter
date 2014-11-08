package com.devesion.obd.command.invoker.marshaller;

import com.devesion.obd.command.ObdCommand;
import com.devesion.obd.command.invoker.CommandResult;
import com.devesion.obd.shared.ObdInvalidCommandResponseException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class ProtocolCommandUnmarshaller extends AbstractCommandUnmarshaller {

	private static final String ELM_PROTOCOL_ACK_OK = "OK";

	@Override
	public CommandResult unmarshal(ObdCommand command, String responseData) {
		log.info("unmarshaling response '{}", responseData);

		responseData = normalizeResponse(responseData);
		log.info("after normalization '{}", responseData);

		checkResponse(responseData);

		if (responseData.contains(ELM_PROTOCOL_ACK_OK)) {
			return new CommandResult();
		}

		throw new ObdInvalidCommandResponseException();
	}
}
