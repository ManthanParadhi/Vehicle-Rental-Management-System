package com.shashank.vrms.controllers.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shashank.vrms.daos.BookingDAO;
import com.shashank.vrms.models.Booking;

@WebServlet("/admin/booking/view/*")
public class ViewBookingController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getPathInfo();
		int id = Integer.parseInt(path.substring(1));
		
		BookingDAO bookingDAO = new BookingDAO();
		Booking booking = bookingDAO.getBookingById(id);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/admin/viewBooking.jsp");
		request.setAttribute("booking", booking);
		rd.forward(request, response);
		
	}

}
