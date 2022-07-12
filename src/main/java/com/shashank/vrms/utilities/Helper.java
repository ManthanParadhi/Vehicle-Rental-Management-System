package com.shashank.vrms.utilities;

import java.io.NotActiveException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import com.shashank.vrms.daos.BookingDAO;
import com.shashank.vrms.daos.VehicleDAO;
import com.shashank.vrms.models.Booking;
import com.shashank.vrms.models.Vehicle;

public class Helper {
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public static final Pattern VALID_PASSWORD_PATTERN = Pattern
			.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", Pattern.CASE_INSENSITIVE);

	public static boolean validateEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

	public static boolean validatePassword(String passwoString) {
		Matcher matcher = VALID_PASSWORD_PATTERN.matcher(passwoString);
		return matcher.find();
	}

	public static boolean areFieldsValid(String... fields) {

		for (String field : fields) {
			if (field == null || field.trim().length() == 0)
				return false;
		}
		return true;
	}

	public static <T> List<T> loadAllData(Class<T> type, Session session) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(type);
		criteria.from(type);
		List<T> data = session.createQuery(criteria).getResultList();
		return data;
	}

	public static int getYear(Timestamp timestamp) {

		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(timestamp.getTime());
		return cal.get(Calendar.YEAR);
	}

	public static int getMonth(Timestamp timestamp) {

		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(timestamp.getTime());
		return cal.get(Calendar.MONTH);
	}

	public static int getDay(Timestamp timestamp) {

		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(timestamp.getTime());
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	public static boolean checkIfBookingDatesValid(Timestamp fromDate, Timestamp tillDate, Vehicle vehicle) {

		List<Booking> bookings = vehicle.getBooking();
		
		  Calendar c = Calendar.getInstance();
		  
		  c.set(Calendar.HOUR_OF_DAY, 9);
		  c.set(Calendar.MINUTE, 0);
		  Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		  timestamp.setTime(c.getTimeInMillis());

		if (fromDate.before(timestamp)
				|| tillDate.before(timestamp)) {
			
			System.out.println("1.Selected date is not available");

			return false;
		}
		
		
		if(fromDate.after(tillDate)) {
			System.out.println("2.Selected date is not available");
			return false;
		}
		

		for (Booking booking : bookings) {

			if (!((fromDate.before(booking.getFromDate()) && tillDate.before(booking.getFromDate()))

					||

					(tillDate.after(booking.getTillDate()) && fromDate.after(booking.getTillDate()))

			)) {

				System.out.println("3.Selected date is not available");
				return false;

			}

		}
		
		return true;

	}

}
