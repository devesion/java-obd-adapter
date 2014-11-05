package com.devesion.obd.command.protocol;

/**
 * Represents AT Echo Off Command.
 */
public class EchoOffCommand extends AbstractProtocolCommand {

	@Override
	public String getOperands() {
		return "E0";
	}
}
