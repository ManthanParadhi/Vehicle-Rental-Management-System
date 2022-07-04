package com.shashank.vrms.controllers.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shashank.vrms.daos.BrandDAO;
import com.shashank.vrms.daos.DriverDAO;

@WebServlet("/admin/driver/delete/*")
public class DeleteDriverController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getPathInfo();
		int id = Integer.parseInt(path.substring(1));
		
		
		try {
			
			DriverDAO driverDAO = new DriverDAO();
			driverDAO.deleteDriver(id);
			HttpSession session = request.getSession();
			session.setAttribute("msg","Driver deleted successfully...");
			response.sendRedirect(request.getContextPath() +"/admin/drivers");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	

}
