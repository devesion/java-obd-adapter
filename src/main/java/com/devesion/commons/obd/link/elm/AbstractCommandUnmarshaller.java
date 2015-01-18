package com.devesion.commons.obd.link.elm;

import com.devesion.commons.obd.command.ObdCommand;
import com.devesion.commons.obd.link.CommandUnmarshaller;
import com.devesion.commons.obd.shared.ObdNoDataForCommandResponseException;

abstract class AbstractCommandUnmarshaller implements CommandUnmarshaller {

	private static final String ELM_SPACE = "\\s";
	private static final String ELM_NODATA_ERROR = "NODATA";

	protected String normalizeResponse(String responseData) {
		return responseData.replaceAll(ELM_SPACE, "").toUpperCase();
	}

	protected void checkResponse(ObdCommand command, String responseData) {
		if (responseData.contains(ELM_NODATA_ERROR)) {
			throw new ObdNoDataForCommandResponseException(command);
		}
	}
}
