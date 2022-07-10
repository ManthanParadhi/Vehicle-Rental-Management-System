package com.shashank.vrms.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.shashank.vrms.enums.BookingStatus;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_id", nullable = false)
	private Vehicle vehicle;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "driver_id")
	private Driver driver;
	
	@Column(name ="booked_on",nullable = false)
	private Timestamp bookedOn;
	
	@Column(name ="from_date",nullable = false)
	private Timestamp fromDate;
	
	@Column(name ="till_date",nullable = false)
	private Timestamp tillDate;
	
	@Column(name ="booking_price",nullable = false)
	private double bookingPrice;
	
	@Column(name ="updated_on",nullable = false)
	private Timestamp updateddOn;
	
	@Column(name ="booking_status",nullable = false)
	@Enumerated(EnumType.STRING)
	private BookingStatus bookingStatus;
	
	@Column(name ="need_driver",nullable = false)
	private boolean needDriver;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Timestamp getBookedOn() {
		return bookedOn;
	}

	public void setBookedOn(Timestamp bookedOn) {
		this.bookedOn = bookedOn;
	}

	public Timestamp getFromDate() {
		return fromDate;
	}

	public void setFromDate(Timestamp fromDate) {
		this.fromDate = fromDate;
	}

	public Timestamp getTillDate() {
		return tillDate;
	}

	public void setTillDate(Timestamp tillDate) {
		this.tillDate = tillDate;
	}

	public double getBookingPrice() {
		return bookingPrice;
	}

	public void setBookingPrice(double bookingPrice) {
		this.bookingPrice = bookingPrice;
	}

	public Timestamp getUpdateddOn() {
		return updateddOn;
	}

	public void setUpdateddOn(Timestamp updateddOn) {
		this.updateddOn = updateddOn;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	
	

	public boolean isNeedDriver() {
		return needDriver;
	}

	public void setNeedDriver(boolean needDriver) {
		this.needDriver = needDriver;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", vehicle=" + vehicle + ", bookedOn=" + bookedOn + ", fromDate=" + fromDate
				+ ", tillDate=" + tillDate + ", bookingPrice=" + bookingPrice + ", updateddOn=" + updateddOn
				+ ", bookingStatus=" + bookingStatus + "]";
	}

		
	
}
