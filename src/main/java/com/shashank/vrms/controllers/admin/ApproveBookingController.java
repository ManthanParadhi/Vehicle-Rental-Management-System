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
import com.shashank.vrms.utilities.Helper;

@WebServlet("/admin/booking/approve")
public class ApproveBookingController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		BookingDAO bookingDAO = new BookingDAO();
		Booking booking = bookingDAO.getBookingById(id);
		HttpSession session = request.getSession(false);
		
		if(booking.isNeedDriver()) {
			
			
			session.setAttribute("bookingId",id);
			response.sendRedirect(request.getContextPath()+ "/admin/allotDriver");
		}
		
		else {
			
			booking.setBookingStatus(BookingStatus.APPROVED);
			bookingDAO.updateBooking(booking);
			String receiversEmail = "shashankkhadilkar311@gmail.com";
			String subject = "VRMS Booking Confirmation";
			String body = "Dear Customer, Your booking approved successfully... enjoy your ride";
			//Helper.sendEmailNotification(receiversEmail, subject, body);
			
			
			session.setAttribute("msg","Booking approved successfully...");
			response.sendRedirect(request.getContextPath()+ "/admin/bookings");
		}
	}



}
