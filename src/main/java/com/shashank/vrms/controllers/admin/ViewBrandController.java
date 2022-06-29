package com.shashank.vrms.controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shashank.vrms.daos.BrandDAO;
import com.shashank.vrms.models.Brand;

@WebServlet("/admin/brands")
public class ViewBrandController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("brands");
		try {
			
		BrandDAO brandDao = new BrandDAO();
		List<Brand> brandList = brandDao.getAllBrands();
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/admin/brands.jsp");
		request.setAttribute("brandList", brandList);
		rd.forward(request, response);
		}
		catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/admin/brands.jsp");
			request.setAttribute("msg", "Something went wrong, please try again...");
			rd.forward(request, response);
			
		}
		}
	}


