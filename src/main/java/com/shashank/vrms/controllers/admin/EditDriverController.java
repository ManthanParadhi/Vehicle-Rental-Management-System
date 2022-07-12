package com.shashank.vrms.controllers.admin;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shashank.vrms.daos.DriverDAO;
import com.shashank.vrms.enums.AvailabilityStatus;
import com.shashank.vrms.enums.IdProofType;
import com.shashank.vrms.models.Driver;
import com.shashank.vrms.utilities.Helper;

@WebServlet("/admin/driver/edit/*")
public class EditDriverController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getPathInfo();
		int id = Integer.parseInt(path.substring(1));
		
		try {
		DriverDAO driverDAO = new DriverDAO();
		Driver driver = driverDAO.getDriverById(id);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/editDriver.jsp");
		request.setAttribute("driver", driver);
		rd.forward(request, response);
		}
		catch (Exception e) {
			e.printStackTrace();
			HttpSession session = request.getSession();
			session.setAttribute("msg","Something went wrong, Please try again");
			response.sendRedirect(request.getContextPath() +"/admin/drivers");		
			}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String contactNumber = request.getParameter("contactNumber");
		String address = request.getParameter("address");
		
		IdProofType idProofType = IdProofType.valueOf(request.getParameter("idProofType"));
		String idProofNumber = request.getParameter("idProofNumber");
		AvailabilityStatus availabilityStatus = AvailabilityStatus.valueOf(request.getParameter("availabilityStatus"));
		
		if(!Helper.areFieldsValid(firstName,lastName,contactNumber,idProofNumber)) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/admin/editDriver.jsp");
			request.setAttribute("msg", "Please fill required fields properly...");
			rd.forward(request, response);
			return;
		}
		
		try {
		DriverDAO driverDAO = new DriverDAO();
		Driver driver = driverDAO.getDriverById(id);
		
		driver.setFirstName(firstName);
		driver.setLastName(lastName);
		driver.setContactNumber(contactNumber);
		driver.setAddressLine(address);
		driver.setIdProofType(idProofType);
		driver.setIdProofNumber(idProofNumber);
		driver.setAvailabilityStatus(availabilityStatus);
		driver.setUpdatedOn(new Timestamp(System.currentTimeMillis()));
		
		driverDAO.updateDriver(driver);
		
		HttpSession session = request.getSession(false);
		session.setAttribute("msg", "Driver updated successfully...");
		response.sendRedirect(request.getContextPath() + "/admin/drivers");
		
		}catch (Exception e) {
			e.printStackTrace();
			HttpSession session = request.getSession(false);
			session.setAttribute("msg", "Something went wrong...");
			response.sendRedirect(request.getContextPath() + "/admin/drivers");		}
	}

}
