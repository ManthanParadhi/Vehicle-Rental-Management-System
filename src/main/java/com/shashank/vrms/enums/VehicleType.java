package com.shashank.vrms.enums;

public enum VehicleType {
	TWO_WHEELER("Two Wheeler"),FOUR_WHEELER("Four Wheeler");
	
	String value;
	
	 VehicleType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	
	
	
}
