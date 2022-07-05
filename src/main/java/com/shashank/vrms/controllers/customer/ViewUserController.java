package com.shashank.vrms.controllers.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shashank.vrms.daos.UserDAO;
import com.shashank.vrms.models.User;
import com.shashank.vrms.models.UserDetails;

@WebServlet("/c/user")
public class ViewUserController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		String email = (String)session.getAttribute("email");
		
		UserDAO userDAO = new UserDAO();
		User user = userDAO.getUserByEmailId(email);
		try {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/customer/user.jsp");
		request.setAttribute("user", user);
		rd.forward(request, response);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
