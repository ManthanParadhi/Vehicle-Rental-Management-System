package com.shashank.vrms.enums;

import java.awt.Panel;

public enum IdProofType {
	AADHAR_CARD("Aadhar Card"),PAN_CARD("Pan Card"),DRIVING_LICENCE("Driving Licence");

	String value;
	
	IdProofType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
