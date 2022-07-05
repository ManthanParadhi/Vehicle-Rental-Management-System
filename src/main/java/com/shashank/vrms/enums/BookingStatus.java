package com.shashank.vrms.enums;

public enum BookingStatus {
	
	APPROVED("Approved"),REJECTED("Rejected"),PENDING("Pending");
	
	String value;
	
	 BookingStatus(String value) {
		
		this.value = value;
		
	}
	
	public String getValue() {
		
		return value;
	}

}
