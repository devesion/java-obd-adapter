package com.devesion.commons.obd.adapter.link.elm;

import com.devesion.commons.obd.adapter.command.ObdCommand;
import com.devesion.commons.obd.adapter.command.at.AtCommand;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class AtCommandMarshaller extends AbstractCommandMarshaller {

	private static final String PROTOCOL_COMMAND_MNEMONIC = "AT";

	@Override
	public String marshal(ObdCommand command) {
		AtCommand protocolCommand = (AtCommand) command;
		String commandMnemonic = PROTOCOL_COMMAND_MNEMONIC;
		String commandOperands = protocolCommand.getOperands();
		return buildRequest(commandMnemonic, commandOperands);
	}
}
