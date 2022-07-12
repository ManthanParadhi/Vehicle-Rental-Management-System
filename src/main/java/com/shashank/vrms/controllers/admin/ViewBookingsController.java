package com.shashank.vrms.controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shashank.vrms.daos.BookingDAO;
import com.shashank.vrms.models.Booking;

@WebServlet("/admin/bookings")
public class ViewBookingsController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
			
			BookingDAO bookingDAO = new BookingDAO();
			List<Booking>bookingList = bookingDAO.getAllBookings();
			
			HttpSession session = request.getSession(false);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/admin/bookings.jsp");
			request.setAttribute("bookingList", bookingList);
			rd.forward(request, response);
			}
			catch (Exception e) {
				e.printStackTrace();
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/admin/adminDashboard.jsp");
				request.setAttribute("msg", "Something went wrong, please try again...");
				rd.forward(request, response);
			}
	}

	
}
