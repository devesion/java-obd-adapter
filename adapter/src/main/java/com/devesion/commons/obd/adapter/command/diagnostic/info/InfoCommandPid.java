package com.devesion.commons.obd.adapter.command.diagnostic.info;

import com.devesion.commons.obd.adapter.command.diagnostic.DiagnosticCommandPid;
import lombok.Getter;

// TODO:
public enum InfoCommandPid implements DiagnosticCommandPid {
	ONE(1);

	@Getter
	private int number;

	InfoCommandPid(int number) {
		this.number = number;
	}
}