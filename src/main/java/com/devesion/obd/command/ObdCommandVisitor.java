package com.devesion.obd.command;

import com.devesion.obd.command.diagnostic.DiagnosticCommand;
import com.devesion.obd.command.protocol.ProtocolCommand;

/**
 * OBD Command Visitor Interface.
 */
public interface ObdCommandVisitor {

	void visit(ProtocolCommand command);

	void visit(DiagnosticCommand command);
}
