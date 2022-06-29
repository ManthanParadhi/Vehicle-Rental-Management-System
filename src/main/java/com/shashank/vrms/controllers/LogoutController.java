package com.shashank.vrms.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/c/logout")
public class LogoutController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("logout controller");
		HttpSession session = request.getSession(false);
		session.removeAttribute("email");
		session.removeAttribute("id");
		session.removeAttribute("role");
		session.invalidate();
		response.sendRedirect(request.getContextPath() + "/");
	}

}
