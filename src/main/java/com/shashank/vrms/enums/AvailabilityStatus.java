package com.shashank.vrms.enums;



public enum AvailabilityStatus {
	Available("Available"), NOT_AVAILABLE("Not Available");
	
	
	String value;
	
	AvailabilityStatus(String value) {
		
		this.value = value;
		
	}
	
	public String getValue() {
		
		return value;
	}
}
