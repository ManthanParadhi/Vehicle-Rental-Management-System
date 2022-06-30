package com.shashank.vrms.models;

import java.sql.Date;
import java.sql.Timestamp;

public class VehicleDocuments {
	private int id;
	private Timestamp regExpiresOn;
	private Timestamp pucExpiresOn;
	private Timestamp insuranceExpiresOn;
	private int vehicleId;
	private Timestamp createdOn;
	private Timestamp updatedOn;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getRegExpiresOn() {
		return regExpiresOn;
	}
	public void setRegExpiresOn(Timestamp regExpiresOn) {
		this.regExpiresOn = regExpiresOn;
	}
	public Timestamp getPucExpiresOn() {
		return pucExpiresOn;
	}
	public void setPucExpiresOn(Timestamp pucExpiresOn) {
		this.pucExpiresOn = pucExpiresOn;
	}
	public Timestamp getInsuranceExpiresOn() {
		return insuranceExpiresOn;
	}
	public void setInsuranceExpiresOn(Timestamp insuranceExpiresOn) {
		this.insuranceExpiresOn = insuranceExpiresOn;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
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
	public VehicleDocuments() {
		super();
		
	}
		
	
	
}
