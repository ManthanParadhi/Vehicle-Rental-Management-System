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

@WebServlet("/admin/businessInformation/add")
public class AddBusinessInformationController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
		BusinessInformationDAO informationDAO = new BusinessInformationDAO();
		
		if(informationDAO.isBusinessInformationPresent()) {
			HttpSession session = request.getSession(false);
			session.setAttribute("msg", "BusinessInformation already present..");
			response.sendRedirect(request.getContextPath() + "/admin/");
			return;
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/admin/addBusinessInformation.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String buninessName = request.getParameter("businessName");
		String buninessAddress = request.getParameter("businessAddress");
		String buninessEmail = request.getParameter("businessEmail");
		String buninessContactNumber = request.getParameter("businessContactNumber");
		
		System.out.println(buninessName+" "+buninessAddress+" "+buninessEmail+" "+buninessContactNumber);

		if (!Helper.areFieldsValid(buninessName, buninessAddress, buninessEmail, buninessContactNumber)) {
			RequestDispatcher rd = getServletContext()
					.getRequestDispatcher("/WEB-INF/admin/addBusinessInformation.jsp");
			request.setAttribute("msg", "Please fill required fields properly...");
			rd.forward(request, response);
			return;
		}

		try {
			BusinessInformationDAO informationDAO = new BusinessInformationDAO();

			BusinessInformation businessInformation = new BusinessInformation();

			businessInformation.setBusinessName(buninessName);
			businessInformation.setBusinessAddress(buninessAddress);
			businessInformation.setBusinessEmail(buninessEmail);
			businessInformation.setBusinessContactNumber(buninessContactNumber);

			informationDAO.addBusinessInformation(businessInformation);

			HttpSession session = request.getSession(false);
			session.setAttribute("msg", "BusinessInformation created successfully...");
			response.sendRedirect(request.getContextPath() + "/admin/businessInformation");
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = getServletContext()
					.getRequestDispatcher("/WEB-INF/admin/addBusinessInformation.jsp");
			request.setAttribute("msg", "Something went wrong, Please try again...");
			rd.forward(request, response);
		}

	}

}
