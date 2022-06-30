package com.shashank.vrms.controllers.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shashank.vrms.daos.VehicleDAO;

@WebServlet("/admin/vehicle/delete/*")
public class DeleteVehicleController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		int id = Integer.parseInt(path.substring(1));
		
		try {
		VehicleDAO vehicleDAO = new VehicleDAO();
		vehicleDAO.deleteVehicle(id);
		HttpSession session = request.getSession();
		session.setAttribute("msg","Vehicle deleted successfully...");
		response.sendRedirect(request.getContextPath() +"/admin/vehicles");
		}
		catch (Exception e) {
			HttpSession session = request.getSession();
			session.setAttribute("msg","Something went wrong, Please try again");
			response.sendRedirect(request.getContextPath() +"/admin/vehicles");
		}
	}

	

}
