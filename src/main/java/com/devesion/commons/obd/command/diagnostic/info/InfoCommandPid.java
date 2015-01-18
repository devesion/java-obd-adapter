package com.devesion.commons.obd.command.diagnostic.info;

import com.devesion.commons.obd.command.diagnostic.DiagnosticCommandPid;
import lombok.Getter;

public enum InfoCommandPid implements DiagnosticCommandPid {
	ONE(1);

	@Getter
	private int number;

	InfoCommandPid(int number) {
		this.number = number;
	}
}