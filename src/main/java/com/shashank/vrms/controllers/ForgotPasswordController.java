package com.shashank.vrms.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shashank.vrms.daos.UserDAO;
import com.shashank.vrms.utilities.Helper;

@WebServlet("/forgotPassword")
public class ForgotPasswordController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/forgotPassword.jsp");
		rd.forward(request, response);
		
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String otp = Helper.generateOTP();
		
		UserDAO userDAO = new UserDAO();
		
		if(userDAO.getUserByEmailId(email) != null) {
		
		String receiversEmail = email;
		String subject = "VRMS Account recovery";
		String body = "Dear Customer, Your one time password(OTP) is : "+ otp;
		Helper.sendEmailNotification(receiversEmail, subject, body);
		
		HttpSession session = request.getSession();
		session.setAttribute("otp", otp);
		session.setAttribute("recoveryEmail", email);
		response.sendRedirect(request.getContextPath()+ "/setNewPassword");
		}
		
		else {
			
			System.out.println("else block");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/forgotPassword.jsp");
			request.setAttribute("msg", "No user resgistered with this email, please enter registered email...");
			rd.forward(request, response);
			
		}
		
		
	}

}
