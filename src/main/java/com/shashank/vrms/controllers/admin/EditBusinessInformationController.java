package com.shashank.vrms.controllers.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shashank.vrms.daos.BusinessInformationDAO;
import com.shashank.vrms.models.BusinessInformation;
import com.shashank.vrms.utilities.Helper;

@WebServlet("/admin/businessInformation/edit/*")
public class EditBusinessInformationController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getPathInfo();
		System.out.println(path.substring(1));
		int id = Integer.parseInt(path.substring(1));
		
		
		
		try {
		BusinessInformationDAO informationDAO = new BusinessInformationDAO();
		
		BusinessInformation businessInformation = informationDAO.getBusinessInformation();
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/editBusinessInformation.jsp");
		request.setAttribute("businessInformation", businessInformation);
		rd.forward(request, response);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String buninessName = request.getParameter("businessName");
		String buninessAddress = request.getParameter("businessAddress");
		String buninessEmail = request.getParameter("businessEmail");
		String buninessContactNumber = request.getParameter("businessContactNumber");

		if (!Helper.areFieldsValid(buninessName, buninessAddress, buninessEmail, buninessContactNumber)) {
			RequestDispatcher rd = getServletContext()
					.getRequestDispatcher("/WEB-INF/admin/addBusinessInformation.jsp");
			request.setAttribute("msg", "Please fill required fields properly...");
			rd.forward(request, response);
			return;
		}
		
		HttpSession session = request.getSession(false);
		
		try {
			BusinessInformationDAO informationDAO = new BusinessInformationDAO();

			BusinessInformation businessInformation = new BusinessInformation();

			businessInformation.setId(id);
			businessInformation.setBusinessName(buninessName);
			businessInformation.setBusinessAddress(buninessAddress);
			businessInformation.setBusinessEmail(buninessEmail);
			businessInformation.setBusinessContactNumber(buninessContactNumber);

			informationDAO.updateBusinessInformation(businessInformation);

			
			session.setAttribute("msg", "BusinessInformation updated successfully...");
			response.sendRedirect(request.getContextPath() + "/admin/businessInformation");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("msg", "Something went wrong, Please try again...");
			response.sendRedirect(request.getContextPath() + "/admin/businessInformation");
				
		}
	}

}
