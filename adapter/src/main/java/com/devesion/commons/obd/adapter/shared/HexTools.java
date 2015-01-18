package com.devesion.commons.obd.adapter.shared;

public final class HexTools {

	private HexTools() {
		throw new AssertionError();
	}

	public static int fromHexString(String data, int begin, int end) {
		return Integer.decode("0x" + data.substring(begin, end));
	}

	public static String toHexString(ObdNumberedEnum numberedEnum) {
		return toHexString(numberedEnum.getNumber());
	}

    public static String toHexString(int value) {
		return Integer.toHexString(0x100 | (0xFF & value)).substring(1).toUpperCase();
	}
}
