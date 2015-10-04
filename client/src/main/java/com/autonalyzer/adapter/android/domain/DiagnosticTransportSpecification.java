package com.autonalyzer.adapter.android.domain;

public class DiagnosticTransportSpecification {

	private VehicleLinkType type;
	private String name;

	public DiagnosticTransportSpecification(String fqn) {

	}

	public DiagnosticTransportSpecification(String typeName, String deviceName) {

	}

	public DiagnosticTransportSpecification(VehicleLinkType type, String deviceName) {
		this.type = type;
		this.name = deviceName;
	}

	public enum VehicleLinkType {
		BLUETOOTH
	}
}
