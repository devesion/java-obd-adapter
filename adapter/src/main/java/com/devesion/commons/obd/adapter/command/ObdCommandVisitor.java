package com.devesion.commons.obd.adapter.command;

import com.devesion.commons.obd.adapter.command.at.AtCommand;
import com.devesion.commons.obd.adapter.command.diagnostic.DiagnosticCommand;

/**
 * OBD Command Visitor Interface.
 */
public interface ObdCommandVisitor {

	void visit(AtCommand command);

	void visit(DiagnosticCommand command);
}
