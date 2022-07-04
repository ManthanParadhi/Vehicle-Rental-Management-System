package com.shashank.vrms.controllers.admin;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shashank.vrms.daos.BrandDAO;
import com.shashank.vrms.utilities.Helper;

@WebServlet("/admin/brand/add")
public class AddBrandController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/admin/addBrand.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String brandName = request.getParameter("brandName");

		if (!Helper.areFieldsValid(brandName)) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/admin/addBrand.jsp");
			request.setAttribute("msg", "Please fill required fields properly...");
			rd.forward(request, response);
			return;
		}
		try {
			BrandDAO brandDao = new BrandDAO();
			brandDao.addBrand(brandName);
				HttpSession session = request.getSession(false);
				session.setAttribute("msg", "Brand created successfully...");
				response.sendRedirect(request.getContextPath() + "/admin/brands");
			
		}
		catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/admin/addBrand.jsp");
			request.setAttribute("msg", "Something went wrong, Please try again...");
			rd.forward(request, response);
		}

	}

}
