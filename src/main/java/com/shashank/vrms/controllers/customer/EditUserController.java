package com.shashank.vrms.controllers.customer;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shashank.vrms.daos.UserDAO;
import com.shashank.vrms.enums.IdProofType;
import com.shashank.vrms.enums.Role;
import com.shashank.vrms.models.User;
import com.shashank.vrms.models.UserDetails;
import com.shashank.vrms.utilities.BCrypt;
import com.shashank.vrms.utilities.Helper;

@WebServlet("/c/user/edit")
public class EditUserController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("email");

		UserDAO userDAO = new UserDAO();
		User user = userDAO.getUserByEmailId(email);

		try {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/customer/editUser.jsp");
			request.setAttribute("user", user);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		String email = request.getParameter("email");

		String addressLine = request.getParameter("addressLine");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		int pincode = Integer.parseInt(request.getParameter("pincode"));
		String contactNumber = request.getParameter("contactNumber");
		IdProofType idProofType = IdProofType.valueOf(request.getParameter("idProofType"));
		String idProofNumber = request.getParameter("idProofNumber");

		HttpSession session = request.getSession(false);

		if (!Helper.areFieldsValid(fname, lname, email, addressLine, state, city, idProofNumber)) {

			session.setAttribute("msg", "please filled all required fields properly...");
			response.sendRedirect(request.getContextPath() + "/c/user/edit");

			return;
		}

		if (!Helper.validateEmail(email)) {

			session.setAttribute("msg", "please enter valid email ");
			response.sendRedirect(request.getContextPath() + "/c/user/edit");
			return;
		}

		String oldEmail = (String) session.getAttribute("email");
		UserDAO userDAO = new UserDAO();
		User user = userDAO.getUserByEmailId(oldEmail);

		user.setFirstName(fname);
		user.setLastName(lname);
		user.setEmail(email);
		user.setUpdatedOn(new Timestamp(System.currentTimeMillis()));

		user.getDetails().setAddressLine(addressLine);
		user.getDetails().setState(state);
		user.getDetails().setCity(city);
		user.getDetails().setPincode(pincode);
		user.getDetails().setContactNumber(contactNumber);
		user.getDetails().setIdProofType(idProofType);
		user.getDetails().setIdProofNumber(idProofNumber);
		user.getDetails().setUpdatedOn(new Timestamp(System.currentTimeMillis()));
		user.getDetails().setUser(user);

		boolean hasUserEditedEmail = !oldEmail.equals(user.getEmail());
		boolean isEmailTaken = true;

		try {
			if (hasUserEditedEmail) {
				isEmailTaken = userDAO.isEmailAlreadyTaken(user);
			}
			else {
				isEmailTaken=false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("107 Execption");
			session.setAttribute("msg", "Something  went wrong, please try again");
			response.sendRedirect(request.getContextPath() + "/c/user/edit");
			return;

		}System.out.println(isEmailTaken);
		if (isEmailTaken) {
			System.out.println("in isEmailTaken");
			session.setAttribute("msg", "This email is already taken, please choose differnt one...");
			response.sendRedirect(request.getContextPath() + "/c/user/edit");
			return;
		}

		else {
			try {
				userDAO.updateUser(user);

				session.setAttribute("msg", "User updated successfully...");
				response.sendRedirect(request.getContextPath() + "/c/user");
			}

			catch (Exception e) {
				e.printStackTrace();
				System.out.println("130 Execption");
				session.setAttribute("msg", "Something  went wrong, please try again");
				response.sendRedirect(request.getContextPath() + "/c/user/edit");

			}
		}

	}

}
