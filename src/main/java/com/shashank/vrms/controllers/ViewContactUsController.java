package com.shashank.vrms.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shashank.vrms.daos.BusinessInformationDAO;
import com.shashank.vrms.models.BusinessInformation;

@WebServlet("/contactUs")
public class ViewContactUsController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BusinessInformationDAO businessInformationDAO = new BusinessInformationDAO();
		
		BusinessInformation information = businessInformationDAO.getBusinessInformation();
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/contactUs.jsp");
		request.setAttribute("information", information);
		rd.forward(request, response);
		
	}

	

}
