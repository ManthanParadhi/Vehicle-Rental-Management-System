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

@WebServlet("/admin/driver/add")
public class AddDriverController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/admin/addDriver.jsp");
		rd.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/admin/adminDashboard.jsp");
			request.setAttribute("msg","something went wrong, please try again");
			rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String contactNumber = request.getParameter("contactNumber");
		String address = request.getParameter("address");
		
		IdProofType idProofType = IdProofType.valueOf(request.getParameter("idProofType"));
		String idProofNumber = request.getParameter("idProofNumber");
		AvailabilityStatus availabilityStatus = AvailabilityStatus.valueOf(request.getParameter("availabilityStatus"));
		System.out.println(firstName + lastName + contactNumber +idProofNumber);
		
		if(!Helper.areFieldsValid(firstName,lastName,contactNumber,idProofNumber)) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/admin/addDriver.jsp");
			request.setAttribute("msg", "Please fill required fields properly...");
			rd.forward(request, response);
			return;
		}
		
		Driver driver = new Driver();
		
		driver.setFirstName(firstName);
		driver.setLastName(lastName);
		driver.setContactNumber(contactNumber);
		driver.setAddressLine(address);
		driver.setIdProofType(idProofType);
		driver.setIdProofNumber(idProofNumber);
		driver.setAvailabilityStatus(availabilityStatus);
		driver.setCreatedOn(new Timestamp(System.currentTimeMillis()));
		
		try{
			DriverDAO driverDAO = new DriverDAO();
			
			driverDAO.addDriver(driver);
			HttpSession session = request.getSession(false);
			session.setAttribute("msg", "Driver added successfully...");
			response.sendRedirect(request.getContextPath() + "/admin/drivers");
		}catch (Exception e) {
			e.printStackTrace();
			HttpSession session = request.getSession(false);
			session.setAttribute("msg", "Something went wrong...");
			response.sendRedirect(request.getContextPath() + "/admin/driver/add");		}
	}

}
