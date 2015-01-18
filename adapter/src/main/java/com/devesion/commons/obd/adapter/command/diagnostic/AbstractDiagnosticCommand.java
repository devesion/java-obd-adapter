package com.devesion.commons.obd.adapter.command.diagnostic;

import com.devesion.commons.obd.adapter.command.AbstractCommand;
import com.devesion.commons.obd.adapter.command.ObdCommandVisitor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public abstract class AbstractDiagnosticCommand extends AbstractCommand implements DiagnosticCommand {

	@Override
	public void accept(ObdCommandVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("AbstractDiagnosticCommand{");
		sb.append("mode='").append(getMode()).append("', pid='").append(getPid()).append("'}");
		return sb.toString();
	}
}
