package com.shashank.vrms.controllers.admin;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
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
import com.shashank.vrms.enums.VehicleType;
import com.shashank.vrms.models.Brand;
import com.shashank.vrms.models.Vehicle;
import com.shashank.vrms.models.VehicleDocuments;
import com.shashank.vrms.utilities.Helper;

@WebServlet("/admin/vehicle/add")
public class AddVehiclecontroller extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
			BrandDAO brandDAO = new BrandDAO();
		
		List<Brand>brandList = brandDAO.getAllBrands();
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/admin/addVehicle.jsp");
		request.setAttribute("brandList",brandList);
		rd.forward(request, response);
	} catch (Exception e) {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/admin/adminDashboard.jsp");
		request.setAttribute("msg","something went wrong, please try again");
		rd.forward(request, response);}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String model = request.getParameter("model");
		String variant = request.getParameter("variant");
		String color = request.getParameter("color");
		String registrationNumber = request.getParameter("registrationNumber");
		String registrationYear = request.getParameter("registrationYear");
		String engineNumber = request.getParameter("engineNumber");
		String chasisNumber = request.getParameter("chasisNumber");
		int brandId = Integer.parseInt(request.getParameter("brandId"));
		int seatingCapacity = Integer.parseInt(request.getParameter("seatingCapacity"));
		String imageUrl = request.getParameter("imageUrl");
		double pricePerDay = Double.parseDouble(request.getParameter("pricePerDay"));
		boolean isAvailable = Boolean.parseBoolean(request.getParameter("isAvailable"));
		
		System.out.println(request.getParameter("registrationExpiryDate"));
		Timestamp registrationExpirydate = Timestamp.valueOf(request.getParameter("registrationExpiryDate").replace("T"," ")+":00");
		Timestamp pucExpirydate = Timestamp.valueOf(request.getParameter("pucExpiryDate").replace("T"," ")+":00");
		Timestamp insuranceExpirydate = Timestamp.valueOf(request.getParameter("insuranceExpirydate").replace("T"," ")+":00");
		VehicleType type = VehicleType.valueOf(request.getParameter("type")) ;
		
		if(!Helper.areFieldsValid(model,variant,color,registrationNumber,registrationYear,engineNumber,chasisNumber,imageUrl)) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/admin/addVehicle.jsp");
			request.setAttribute("msg", "Please fill required fields properly...");
			rd.forward(request, response);
			return;
		}
		
		BrandDAO brandDAO = new BrandDAO();
		Vehicle vehicle = new Vehicle();
		VehicleDocuments documents = new VehicleDocuments();
		
		documents.setRegExpiresOn(registrationExpirydate);
		documents.setPucExpiresOn(pucExpirydate);
		documents.setInsuranceExpiresOn(insuranceExpirydate);
		documents.setCreatedOn(new Timestamp(System.currentTimeMillis()));
		documents.setVehicle(vehicle);
		
		
		vehicle.setModel(model);
		vehicle.setVariant(variant);
		vehicle.setColor(color);
		vehicle.setRegistrationNumber(registrationNumber);
		vehicle.setRegistrationYear(registrationYear);
		vehicle.setEngineNumber(engineNumber);
		vehicle.setChasisNumber(chasisNumber);
		vehicle.setBrand(brandDAO.getBrandById(brandId));
		vehicle.setSeatingCapacity(seatingCapacity);
		vehicle.setAvailable(isAvailable);
		vehicle.setImageUrl(imageUrl);
		vehicle.setCreatedOn(new Timestamp(System.currentTimeMillis()));
		vehicle.setType(type);
		vehicle.setPricePerDay(pricePerDay);
		vehicle.setDocuments(documents);
		try {
		VehicleDAO vehicleDAO = new VehicleDAO();
		vehicleDAO.addVehicle(vehicle);
		
		
		HttpSession session = request.getSession(false);
		session.setAttribute("msg", "Vehicle added successfully...");
		response.sendRedirect(request.getContextPath() + "/admin/vehicles");
		}
		
		catch (Exception e) {
			e.printStackTrace();
			HttpSession session = request.getSession(false);
			session.setAttribute("msg", "Something went wrong...");
			response.sendRedirect(request.getContextPath() + "/admin/vehicle/add");
		}
		
		

	}

}
