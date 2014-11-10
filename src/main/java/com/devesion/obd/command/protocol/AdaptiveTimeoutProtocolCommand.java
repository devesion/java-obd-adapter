package com.devesion.obd.command.protocol;

/**
 * Represents AT Adaptive Timing Protocol Command.
 */
public class AdaptiveTimeoutProtocolCommand extends AbstractProtocolCommand {

	@Override
	public String getOperands() {
		return "AT 2";
	}
}
