package com.devesion.obd.command.invoker.marshaller;

abstract class AbstractCommandMarshaller implements CommandMarshaller {
	private static final String SPACE = " ";
	private static final String CR = "\r";

	protected String buildResponse(String mnemonic, String operands) {
		return mnemonic + SPACE + operands + CR;
	}
}
