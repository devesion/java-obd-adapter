package com.devesion.commons.obd.link.elm;

import com.devesion.commons.obd.command.ObdCommand;
import com.devesion.commons.obd.command.diagnostic.DiagnosticCommand;
import com.devesion.commons.obd.shared.HexTools;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class DiagnosticCommandMarshaller extends AbstractCommandMarshaller {

	@Override
	public String marshal(ObdCommand command) {
		DiagnosticCommand diagnosticCommand = (DiagnosticCommand) command;
		String commandMnemonic = HexTools.toHexString(diagnosticCommand.getMode());
		String commandOperands = HexTools.toHexString(diagnosticCommand.getPid());
		return buildRequestWithCount(commandMnemonic, commandOperands, 1);
	}
}
