package com.devesion.commons.obd.adapter.link.elm;

import com.devesion.commons.obd.adapter.command.ObdCommand;
import com.devesion.commons.obd.adapter.link.CommandUnmarshaller;
import com.devesion.commons.obd.adapter.shared.ObdNoDataForCommandResponseException;
import com.devesion.commons.obd.adapter.shared.ObdNotProperlyInitializedException;

abstract class AbstractCommandUnmarshaller implements CommandUnmarshaller {

	private static final String ELM_WHITE = "[\\s]";
	private static final String ELM_CAN_BUS_SEPARATOR = "[0-9]:";
	private static final String ELM_NODATA_ERROR = "NODATA";
	private static final String ELM_SEARCHING_ERROR = "SEARCHING";
	private static final String ELM_BUS_ERROR = "BUS";

	protected String normalizeResponse(String responseData) {
		return responseData
				.replaceAll(ELM_WHITE, "")
				.replaceAll(ELM_CAN_BUS_SEPARATOR, "")
				.toUpperCase();
	}

	protected void checkResponse(ObdCommand command, String responseData) {
		if (responseData.contains(ELM_NODATA_ERROR)) {
			throw new ObdNoDataForCommandResponseException(command, responseData);
		}

		if (responseData.contains(ELM_SEARCHING_ERROR)) {
			throw new ObdNotProperlyInitializedException(command, responseData);
		}

		if (responseData.contains(ELM_BUS_ERROR)) {
			throw new ObdNotProperlyInitializedException(command, responseData);
		}
	}
}
