package com.shashank.vrms.daos;

import java.util.List;

import org.hibernate.Session;

import com.shashank.vrms.models.Booking;
import com.shashank.vrms.models.Driver;
import com.shashank.vrms.utilities.Helper;
import com.shashank.vrms.utilities.HibernateUtil;

public class BookingDAO {

	public List<Booking> getAllBookings() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Booking> bookingList = Helper.loadAllData(Booking.class, session);
		session.getTransaction().commit();
		session.close();

		return bookingList;
	}

	
	public void addBooking(Booking booking) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(booking);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public Booking getBookingById(int id) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Booking booking = session.get(Booking.class, id);
		session.getTransaction().commit();
		session.close();
		
		return booking;
		
	}
	
	
	public void updateBooking(Booking booking) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(booking);
		session.getTransaction().commit();
		session.close();
		
	}
}
