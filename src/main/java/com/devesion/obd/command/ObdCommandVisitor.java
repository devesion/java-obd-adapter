package com.devesion.obd.command;

import com.devesion.obd.command.at.AtCommand;
import com.devesion.obd.command.diagnostic.DiagnosticCommand;

/**
 * OBD Command Visitor Interface.
 */
public interface ObdCommandVisitor {

	void visit(AtCommand command);

	void visit(DiagnosticCommand command);
}
