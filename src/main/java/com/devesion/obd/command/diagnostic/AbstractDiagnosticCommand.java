package com.devesion.obd.command.diagnostic;

import com.devesion.obd.command.AbstractCommand;
import com.devesion.obd.command.ObdCommandVisitor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractDiagnosticCommand extends AbstractCommand implements DiagnosticCommand {

	@Override
	public void accept(ObdCommandVisitor visitor) {
		visitor.visit(this);
	}
}
