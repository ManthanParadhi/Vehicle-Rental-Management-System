package com.shashank.vrms.models;

import java.sql.Timestamp;

public class UserDetails {
	private int id;
	private String contactNumber;
	private String addressLine;
	private String city;
	private String state;
	private int pincode;
	private String idProofType;
	private String idProofNumber;
	private Timestamp createdOn;
	private Timestamp updatedOn;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getIdProofType() {
		return idProofType;
	}
	public void setIdProofType(String idProofType) {
		this.idProofType = idProofType;
	}
	public String getIdProofNumber() {
		return idProofNumber;
	}
	public void setIdProofNumber(String idProofNumber) {
		this.idProofNumber = idProofNumber;
	}
	public Timestamp getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	public Timestamp getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", contactNumber=" + contactNumber + ", addressLine=" + addressLine + ", city="
				+ city + ", state=" + state + ", pincode=" + pincode + ", idProofType=" + idProofType
				+ ", idProofNumber=" + idProofNumber + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
	}
	
	
	

	
	
	
	
}
