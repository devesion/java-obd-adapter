package com.devesion.commons.obd.adapter.link.elm;

import com.devesion.commons.obd.adapter.command.ObdCommand;
import com.devesion.commons.obd.adapter.command.CommandResult;
import com.devesion.commons.obd.adapter.shared.ObdInvalidCommandResponseException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class AtCommandUnmarshaller extends AbstractCommandUnmarshaller {

	private static final String ELM_PROTOCOL_ACK_OK = "OK";

	@Override
	public CommandResult unmarshal(ObdCommand command, String responseData) {
		log.debug("unmarshaling response '{}", responseData);

		responseData = normalizeResponse(responseData);
		log.debug("after normalization '{}", responseData);

		if (command.checkResponseEnabled()) {
			checkResponse(command, responseData);
			if (responseData.contains(ELM_PROTOCOL_ACK_OK)) {
				return CommandResult.empty();
			}

			throw new ObdInvalidCommandResponseException(command, responseData);
		}

		return CommandResult.empty();
	}
}
