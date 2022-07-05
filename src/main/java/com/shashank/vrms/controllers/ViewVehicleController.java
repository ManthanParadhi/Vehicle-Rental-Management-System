package com.shashank.vrms.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shashank.vrms.daos.BrandDAO;
import com.shashank.vrms.daos.VehicleDAO;
import com.shashank.vrms.models.Brand;
import com.shashank.vrms.models.Vehicle;

@WebServlet("/vehicle/*")
public class ViewVehicleController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getPathInfo();
		int id = Integer.parseInt(path.substring(1));
		
		try {
			VehicleDAO vehicleDAO = new VehicleDAO();
			Vehicle vehicle = vehicleDAO.getVehicleById(id);
					
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/vehicle.jsp");
			request.setAttribute("vehicle", vehicle);
			rd.forward(request, response);
			}
			catch (Exception e) {
				e.printStackTrace();
				HttpSession session = request.getSession();
				session.setAttribute("msg","Something went wrong, Please try again");
				response.sendRedirect(request.getContextPath() +"/vehicles");
			}
		
	}

	
}
