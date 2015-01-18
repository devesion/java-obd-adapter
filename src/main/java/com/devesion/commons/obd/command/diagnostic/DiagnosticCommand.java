package com.devesion.commons.obd.command.diagnostic;

import com.devesion.commons.obd.command.ObdCommand;
import com.devesion.commons.obd.shared.ObdNumberedEnum;

public interface DiagnosticCommand extends ObdCommand {

	ObdNumberedEnum getMode();

	ObdNumberedEnum getPid();
}
