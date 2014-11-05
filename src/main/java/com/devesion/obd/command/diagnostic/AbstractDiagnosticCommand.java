package com.devesion.obd.command.diagnostic;

import com.devesion.obd.command.AbstractCommand;
import com.devesion.obd.shared.ObdNumberedEnum;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public abstract class AbstractDiagnosticCommand extends AbstractCommand implements DiagnosticCommand {

	@Override
	public String getMnemonic() {
		return toHexString(getMode());
	}

	@Override
	public String getOperands() {
		return toHexString(getPid());
	}

	private String toHexString(ObdNumberedEnum numberedEnum) {
		return Integer.toHexString(0xFF & numberedEnum.getNumber());
	}
}
