package com.shashank.vrms.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shashank.vrms.daos.UserDAO;
import com.shashank.vrms.enums.Role;
import com.shashank.vrms.models.User;
import com.shashank.vrms.utilities.Helper;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (!Helper.areFieldsValid(email,password)) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			request.setAttribute("msg", "Please fill required fields...");
			rd.forward(request, response);
			return;
		}

//		if (!Helper.validateEmail(email) || (!Helper.validatePassword(password))) {
//			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
//			request.setAttribute("msg", "please enter valid email and password...\n " + "Password must contain->\n"
//					+ " a digit must occur at least once\r\n" + " a lower case letter must occur at least once\r\n"
//					+ "an upper case letter must occur at least once\r\n"
//					+ " a special character must occur at least once\r\n"
//					+ " no whitespace allowed in the entire string\r\n"
//					+ "      anything, at least eight places though");
//			rd.forward(request, response);
//			return;
//		}

		try {

			UserDAO userDao = new UserDAO();

			if (userDao.checkCredentials(email, password)) {

				User user = userDao.getUserByEmailId(email);

				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				session.setAttribute("userId", user.getId());
				session.setAttribute("role", user.getRole());
				session.setAttribute("name", user.getFirstName());

				if (user.getRole() == Role.CUSTOMER) {
					response.sendRedirect(request.getContextPath()+"/");
				} else if (user.getRole() == Role.ADMIN) {
					response.sendRedirect(request.getContextPath()+"/admin/");
				}

			} else {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
				request.setAttribute("msg", "Invalid credentials...");
				rd.forward(request, response);
			}

		} catch (Exception e) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
			request.setAttribute("msg", "Something went wrong, please try again...");
			rd.forward(request, response);
			e.printStackTrace();
		}

	}
}
