package com.shashank.vrms.controllers;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shashank.vrms.daos.UserDAO;
import com.shashank.vrms.enums.IdProofType;
import com.shashank.vrms.enums.Role;
import com.shashank.vrms.models.User;
import com.shashank.vrms.models.UserDetails;
import com.shashank.vrms.utilities.BCrypt;
import com.shashank.vrms.utilities.Helper;

@WebServlet("/register")
public class RegisterController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/register.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String addressLine = request.getParameter("addressLine");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		int pincode = Integer.parseInt(request.getParameter("pincode"));
		String contactNumber = request.getParameter("contactNumber");
		IdProofType idProofType = IdProofType.valueOf(request.getParameter("idProofType"));
		String idProofNumber = request.getParameter("idProofNumber");
		

		if (!Helper.areFieldsValid(fname, lname, email, password)) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/register.jsp");
			request.setAttribute("msg", "please try again");
			rd.forward(request, response);
			return;
		}

		if (!Helper.validateEmail(email) || (!Helper.validatePassword(password))) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/register.jsp");
			request.setAttribute("msg", "please enter valid email and password... ");
			rd.forward(request, response);
			return;
		}

		String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
		User user = new User(fname, lname, email, hashPassword);
		UserDetails details = new UserDetails();
		user.setRole(Role.CUSTOMER);
		user.setCreatedOn(new Timestamp(System.currentTimeMillis()));
		user.setDetails(details);
		user.getDetails().setAddressLine(addressLine);
		user.getDetails().setState(state);
		user.getDetails().setCity(city);
		user.getDetails().setPincode(pincode);
		user.getDetails().setContactNumber(contactNumber);
		user.getDetails().setIdProofType(idProofType);
		user.getDetails().setIdProofNumber(idProofNumber);
		user.getDetails().setCreatedOn(new Timestamp(System.currentTimeMillis()));
		user.getDetails().setUser(user);

		boolean isEmailTaken = true;
		UserDAO userDao = null;
		try {
			userDao = new UserDAO();

			isEmailTaken = userDao.isEmailAlreadyTaken(user);
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/register.jsp");
			request.setAttribute("msg", "Something  went wrong, please try again");
			rd.forward(request, response);
			return;

		}
		if (isEmailTaken) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/register.jsp");
			request.setAttribute("msg", "This email is already taken, please choose differnt one...");
			rd.forward(request, response);
			return;
		}

		else {
			try {
				userDao.registerUser(user);

				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
				request.setAttribute("msg", "User registered successfully");
				rd.forward(request, response);
			}

			catch (Exception e) {

				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/register.jsp");
				request.setAttribute("msg", "Something  went wrong, please try again");
				rd.forward(request, response);

			}
		}

	}
}
