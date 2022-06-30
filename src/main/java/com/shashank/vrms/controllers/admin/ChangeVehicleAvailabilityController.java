package com.shashank.vrms.controllers.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.parser.RecoveredRequiresStatement;

import com.shashank.vrms.daos.VehicleDAO;

@WebServlet("/admin/vehicle/changeVehicleAvailability/*")
public class ChangeVehicleAvailabilityController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		int id = Integer.parseInt(path.substring(1));
		try {
		VehicleDAO vehicleDAO = new VehicleDAO();
		vehicleDAO.switchVehicleAvalability(id);
		
		HttpSession session = request.getSession(false);
		session.setAttribute("msg", "Availability updated successfully...");
		response.sendRedirect(request.getContextPath()+"/admin/vehicles");
		}
		catch (Exception e) {
			HttpSession session = request.getSession(false);
			session.setAttribute("msg", "Something went wrong...");
			response.sendRedirect(request.getContextPath() + "/admin/vehicles");
		}
	}
		
	
}
