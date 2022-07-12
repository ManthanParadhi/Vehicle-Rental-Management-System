package com.shashank.vrms.controllers.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shashank.vrms.daos.BookingDAO;
import com.shashank.vrms.enums.BookingStatus;
import com.shashank.vrms.enums.Role;
import com.shashank.vrms.models.Booking;

@WebServlet("/admin/booking/decline")
public class DeclineBookingController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		BookingDAO bookingDAO = new BookingDAO();
		Booking booking = bookingDAO.getBookingById(id);
		
		booking.setBookingStatus(BookingStatus.REJECTED);
		bookingDAO.updateBooking(booking);
		
		HttpSession session = request.getSession(false);
		session.setAttribute("msg","Booking declined successfully...");
		response.sendRedirect(request.getContextPath()+ "/admin/bookings");
		
	}

	
}
