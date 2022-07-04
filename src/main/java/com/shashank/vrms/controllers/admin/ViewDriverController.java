package com.shashank.vrms.controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shashank.vrms.daos.DriverDAO;
import com.shashank.vrms.models.Driver;

@WebServlet("/admin/drivers")
public class ViewDriverController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		DriverDAO driverDAO = new DriverDAO();
		List<Driver> driverList = driverDAO.getAllDrivers();
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/admin/drivers.jsp");
		request.setAttribute("driverList", driverList);
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
