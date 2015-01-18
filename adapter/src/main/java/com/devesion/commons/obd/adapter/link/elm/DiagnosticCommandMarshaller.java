package com.devesion.commons.obd.adapter.link.elm;

import com.devesion.commons.obd.adapter.command.ObdCommand;
import com.devesion.commons.obd.adapter.command.diagnostic.DiagnosticCommand;
import com.devesion.commons.obd.adapter.shared.HexTools;
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
