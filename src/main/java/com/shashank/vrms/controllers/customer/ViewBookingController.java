package com.shashank.vrms.controllers.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shashank.vrms.daos.UserDAO;
import com.shashank.vrms.models.User;

@WebServlet("/c/bookings")
public class ViewBookingController extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			HttpSession session = request.getSession(false);
			
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/customer/bookings.jsp");
			//request.setAttribute("userList", userList);
			rd.forward(request, response);
			}
			catch (Exception e) {
				e.printStackTrace();
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/home.jsp");
				request.setAttribute("msg", "Something went wrong, please try again...");
				rd.forward(request, response);
			}
	}

	

}
