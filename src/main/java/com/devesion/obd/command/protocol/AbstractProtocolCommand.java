package com.devesion.obd.command.protocol;

import com.devesion.obd.command.AbstractCommand;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Supertype for every Protocol Command.
 */
@ToString
@EqualsAndHashCode
abstract class AbstractProtocolCommand extends AbstractCommand implements ProtocolCommand {

	private static final String PROTOCOL_COMMAND_MNEMONIC = "AT";

	@Override
	public String getMnemonic() {
		return PROTOCOL_COMMAND_MNEMONIC;
	}
}
