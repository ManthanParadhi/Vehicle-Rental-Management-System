package com.shashank.vrms.controllers.admin;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shashank.vrms.daos.BookingDAO;
import com.shashank.vrms.daos.DriverDAO;
import com.shashank.vrms.enums.AvailabilityStatus;
import com.shashank.vrms.enums.BookingStatus;
import com.shashank.vrms.models.Booking;
import com.shashank.vrms.models.Driver;

@WebServlet("/admin/allotDriver/*")
public class AllotDriverController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		DriverDAO driverDAO = new DriverDAO();
		List<Driver> driverList = driverDAO.getAllDrivers();
		List<Driver> availableDriverList = new ArrayList<Driver>();
		
		for (Driver driver : driverList) {
			
			if(driver.getAvailabilityStatus()==AvailabilityStatus.Available) {
				
				availableDriverList.add(driver);
			}
			
		}
		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/admin/availableDrivers.jsp");
		request.setAttribute("driverList", availableDriverList);
		if(availableDriverList.isEmpty())
			request.setAttribute("msg", "Driver not available...");
		else 
			request.setAttribute("msg", "Available driver...");
		rd.forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int driverId = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession(false);
		int bookingId = (int)session.getAttribute("bookingId");
		session.removeAttribute("bookingId");
		
		DriverDAO driverDAO = new DriverDAO();
		BookingDAO bookingDAO = new BookingDAO();
		
		Driver driver = driverDAO.getDriverById(driverId);
		driver.setAvailabilityStatus(AvailabilityStatus.NOT_AVAILABLE);
		driver.setUpdatedOn(new Timestamp(System.currentTimeMillis()));
		driverDAO.updateDriver(driver);
		
		Booking booking = bookingDAO.getBookingById(bookingId);
		booking.setDriver(driver);
		booking.setUpdatedOn(new Timestamp(System.currentTimeMillis()));
		booking.setBookingStatus(BookingStatus.APPROVED);
		bookingDAO.updateBooking(booking);
		
		session.setAttribute("msg","Booking approved successfully...");
		response.sendRedirect(request.getContextPath()+ "/admin/bookings");
		
	}

}
