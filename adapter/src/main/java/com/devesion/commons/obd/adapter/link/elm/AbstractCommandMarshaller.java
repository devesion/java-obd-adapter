package com.devesion.commons.obd.adapter.link.elm;

import com.devesion.commons.obd.adapter.link.CommandMarshaller;
import com.devesion.commons.obd.adapter.shared.HexTools;

abstract class AbstractCommandMarshaller implements CommandMarshaller {
	private static final String SPACE = " ";
	private static final String CR = "\r";

	protected String buildRequest(String mnemonic, String operands) {
		return mnemonic + SPACE + operands + CR;
	}

	protected String buildRequestWithCount(String mnemonic, String operands, int count) {
		return mnemonic + SPACE + operands + HexTools.toHexString(count) + CR;
	}
}
