package com.shashank.vrms.models;

public class BusinessInformation {
	private int id;
	private String businessName;
	private String businessAddress;
	private String businessEmail;
	private String businessContactNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getBusinessAddress() {
		return businessAddress;
	}
	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}
	public String getBusinessEmail() {
		return businessEmail;
	}
	public void setBusinessEmail(String businessEmail) {
		this.businessEmail = businessEmail;
	}
	public String getBusinessContactNumber() {
		return businessContactNumber;
	}
	public void setBusinessContactNumber(String businessContactNumber) {
		this.businessContactNumber = businessContactNumber;
	}
	public BusinessInformation() {
		super();
	}
	
	
}
