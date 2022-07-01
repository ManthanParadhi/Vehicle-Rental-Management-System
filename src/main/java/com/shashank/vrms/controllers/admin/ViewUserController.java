package com.shashank.vrms.controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shashank.vrms.daos.UserDAO;
import com.shashank.vrms.models.User;

@WebServlet("/admin/users")
public class ViewUserController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		UserDAO userDAO = new UserDAO();
		List<User> userList  = userDAO.getAllUsers();
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/admin/users.jsp");
		request.setAttribute("userList", userList);
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
