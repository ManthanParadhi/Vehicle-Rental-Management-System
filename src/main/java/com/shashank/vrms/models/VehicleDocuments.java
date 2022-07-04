package com.shashank.vrms.models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "vehicle_documents")
public class VehicleDocuments {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name = "reg_expires_on", nullable = false)
	private Timestamp regExpiresOn;
	@Column(name = "puc_expires_on", nullable = false)
	private Timestamp pucExpiresOn;
	@Column(name = "insurance_expires_on", nullable = false)
	private Timestamp insuranceExpiresOn;
	
	@OneToOne
	@JoinColumn(name = "vehicle_id", nullable = false)
	private Vehicle vehicle;
	
	@Column(name ="created_on",nullable = false)
	private Timestamp createdOn;
	@Column(name ="updated_on")
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
	
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
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
