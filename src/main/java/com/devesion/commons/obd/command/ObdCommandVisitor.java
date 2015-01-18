package com.devesion.commons.obd.command;

import com.devesion.commons.obd.command.at.AtCommand;
import com.devesion.commons.obd.command.diagnostic.DiagnosticCommand;

/**
 * OBD Command Visitor Interface.
 */
public interface ObdCommandVisitor {

	void visit(AtCommand command);

	void visit(DiagnosticCommand command);
}
