package com.devesion.obd.command.invoker;

import com.google.common.base.Optional;

class CommandExceptionFactory {

	Optional<RuntimeException> buildExceptionFromResult(String rawResponseData) {
//		rawResponseData = rawResponseData.replaceAll("\\s", "");
//		if (!rawResponseData.matches("([0-9A-F]{2})+")) {
//			throw new ObdCommunicationException("invalid response");
//		}

		return Optional.absent();
	}
}
