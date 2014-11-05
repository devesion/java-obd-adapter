package com.devesion.obd.command.diagnostic;

import com.devesion.obd.command.ObdCommand;
import com.devesion.obd.shared.ObdNumberedEnum;

public interface DiagnosticCommand extends ObdCommand {

	ObdNumberedEnum getMode();

	ObdNumberedEnum getPid();
}
