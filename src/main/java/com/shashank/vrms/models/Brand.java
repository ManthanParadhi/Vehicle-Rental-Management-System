package com.shashank.vrms.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Brand {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name = "brand_name", nullable = false, unique = true)
	private String brandName;
	@Column(name = "created_on", nullable = false)
	private Timestamp createdOn;
	@Column(name = "updated_on")
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
	
	
	
	
	
}
