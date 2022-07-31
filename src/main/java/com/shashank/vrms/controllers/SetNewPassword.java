package com.shashank.vrms.controllers;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shashank.vrms.daos.UserDAO;
import com.shashank.vrms.models.User;
import com.shashank.vrms.utilities.BCrypt;
import com.shashank.vrms.utilities.Helper;

@WebServlet("/setNewPassword")
public class SetNewPassword extends HttpServlet {
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/setNewPassword.jsp");
	rd.forward(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String otp = request.getParameter("otp");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession(false);
		String otpFromDbString = (String)session.getAttribute("otp");
		String email = (String)session.getAttribute("recoveryEmail");
		
		if(otp.equals(otpFromDbString)) {
			
			
			if (!Helper.validatePassword(password)) {
				
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/setNewPassword.jsp");
				request.setAttribute("msg", "please enter valid password...");
				rd.forward(request, response);
				return;
			}
			
			String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
			
			UserDAO userDAO = new UserDAO();
			User user = userDAO.getUserByEmailId(email);
			user.setPassword(hashPassword);
			
			userDAO.updateUser(user);
			
			session.invalidate();
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/home.jsp");
			request.setAttribute("msg", "password changed successfully...");
			rd.forward(request, response);
		}
		else {
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/setNewPassword.jsp");
			request.setAttribute("msg", "please enter valid otp...");
			rd.forward(request, response);
		}
		
		
	}

}
