package com.shashank.vrms.controllers.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shashank.vrms.daos.BusinessInformationDAO;
import com.shashank.vrms.models.BusinessInformation;

@WebServlet("/admin/businessInformation")
public class ViewBusinessInformationController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		BusinessInformationDAO informationDAO = new BusinessInformationDAO();
		BusinessInformation information = informationDAO.getBusinessInformation();
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/admin/businessInformation.jsp");
		request.setAttribute("information", information);
		rd.forward(request, response);
		}
		catch (Exception e) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/admin/adminDashboard.jsp");
			request.setAttribute("msg", "Something went wrong, please try again...");
			rd.forward(request, response);
		}
	}

	

}
