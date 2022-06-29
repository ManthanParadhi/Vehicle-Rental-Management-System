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

import com.shashank.vrms.daos.BrandDAO;
import com.shashank.vrms.models.Brand;
import com.shashank.vrms.utilities.Helper;

@WebServlet("/admin/brand/edit/*")
public class EditBrandController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("EditProductController controller Servlet");
		String path = request.getPathInfo();
		int id = Integer.parseInt(path.substring(1));
		System.out.println(id);

		try {
			BrandDAO brandDAO = new BrandDAO();
			Brand brand = brandDAO.getBrandById(id);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/editBrand.jsp");
			request.setAttribute("brand", brand);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int brandId = Integer.parseInt(request.getParameter("id"));
		String brandName = request.getParameter("brandName");

		if (!Helper.areFieldsValid(brandName)) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/admin/editBrand.jsp");
			request.setAttribute("msg", "Please fill required fields...");
			rd.forward(request, response);
			return;
		}

		Brand brand = new Brand(brandId, brandName);
		brand.setUpdatedOn(new Timestamp(System.currentTimeMillis()));

		
		
		HttpSession session = request.getSession(false);

		try {
			BrandDAO brandDAO = new BrandDAO();
			brandDAO.updateBrand(brand);
			session.setAttribute("msg", "Brand updated successfully...");
			response.sendRedirect(request.getContextPath() + "/admin/brands");
		}

		catch (	Exception e) {
			session.setAttribute("msg", "Somthing went wrong, please try again...");
			response.sendRedirect(request.getContextPath() + "/admin/brands");
		}
	}

}
