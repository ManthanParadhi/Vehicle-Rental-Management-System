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
import com.shashank.vrms.models.Booking;

@WebServlet("/admin/booking/approve")
public class ApproveBookingController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		BookingDAO bookingDAO = new BookingDAO();
		Booking booking = bookingDAO.getBookingById(id);
		
		if(booking.isNeedDriver()) {
			
			HttpSession session = request.getSession(false);
			session.setAttribute("bookingId",id);
			response.sendRedirect(request.getContextPath()+ "/admin/allotDriver");
		}
		
		else {
			
			booking.setBookingStatus(BookingStatus.APPROVED);
			bookingDAO.updateBooking(booking);
			
			HttpSession session = request.getSession(false);
			session.setAttribute("msg","Booking approved successfully...");
			response.sendRedirect(request.getContextPath()+ "/admin/bookings");
		}
	}



}
