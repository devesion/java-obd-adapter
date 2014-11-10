package com.devesion.obd.command.invoker.marshaller;

import com.devesion.obd.shared.HexTools;

abstract class AbstractCommandMarshaller implements CommandMarshaller {
	private static final String SPACE = " ";
	private static final String CR = "\r";

	protected String buildRequest(String mnemonic, String operands) {
		return mnemonic + SPACE + operands + CR;
	}

	protected String buildRequestWithCound(String mnemonic, String operands, int count) {
		return mnemonic + SPACE + operands + HexTools.toHexString(count) + CR;
	}
}
