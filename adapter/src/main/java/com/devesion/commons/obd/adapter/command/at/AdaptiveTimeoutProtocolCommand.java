package com.devesion.commons.obd.adapter.command.at;

/**
 * Represents AT Adaptive Timing Protocol Command.
 */
public class AdaptiveTimeoutProtocolCommand extends AbstractAtCommand {

	@Override
	public String getOperands() {
		return "AT 2";
	}
}
