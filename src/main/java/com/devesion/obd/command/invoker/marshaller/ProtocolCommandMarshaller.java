package com.devesion.obd.command.invoker.marshaller;

import com.devesion.obd.command.ObdCommand;
import com.devesion.obd.command.protocol.ProtocolCommand;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class ProtocolCommandMarshaller extends AbstractCommandMarshaller {

	private static final String PROTOCOL_COMMAND_MNEMONIC = "AT";

	@Override
	public String marshal(ObdCommand command) {
		ProtocolCommand protocolCommand = (ProtocolCommand) command;
		String commandMnemonic = PROTOCOL_COMMAND_MNEMONIC;
		String commandOperands = protocolCommand.getOperands();
		return buildResponse(commandMnemonic, commandOperands);
	}
}
