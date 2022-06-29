package com.shashank.vrms.models;

import java.sql.Timestamp;

public class Brand {
	private int id;
	private String brandName;
	private Timestamp createdOn;
	private Timestamp updatedOn;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brandName;
	}
	public void setBrand(String brand) {
		this.brandName = brand;
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
		return "Brand [id=" + id + ", brand=" + brandName + "]";
	}
	public Brand(int id, String brand) {
		super();
		this.id = id;
		this.brandName = brand;
	}
	public Brand(int id, String brand, Timestamp createdOn, Timestamp updatedOn) {
		super();
		this.id = id;
		this.brandName = brand;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}
	
	
	
	
}
