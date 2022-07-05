package com.shashank.vrms.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shashank.vrms.daos.VehicleDAO;
import com.shashank.vrms.models.Vehicle;

@WebServlet("/vehicles")
public class ViewVehiclesController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			VehicleDAO vehicleDAO = new VehicleDAO();

			List<Vehicle> vehicleList = vehicleDAO.getAllVehicles();
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/vehicles.jsp");
			request.setAttribute("vehicleList", vehicleList);
			rd.forward(request, response);

		} catch (Exception e) {
			
			e.printStackTrace();
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/vehicles.jsp");
			request.setAttribute("msg", "Something went wrong, please try again...");
			rd.forward(request, response);

		}
	}

}
