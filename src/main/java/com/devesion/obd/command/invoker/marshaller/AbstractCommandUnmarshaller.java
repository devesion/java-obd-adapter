package com.devesion.obd.command.invoker.marshaller;

import com.devesion.obd.shared.ObdNoDataForCommandResponseException;

abstract class AbstractCommandUnmarshaller implements CommandUnmarshaller {

	private static final String ELM_SPACE = "\\s";
	private static final String ELM_NODATA_ERROR = "NODATA";

	protected String normalizeResponse(String responseData) {
		return responseData.replaceAll(ELM_SPACE, "").toUpperCase();
	}

	protected void checkResponse(String responseData) {
		if (responseData.contains(ELM_NODATA_ERROR)) {
			throw new ObdNoDataForCommandResponseException();
		}
	}
}
