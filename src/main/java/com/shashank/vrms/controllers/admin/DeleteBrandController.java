package com.shashank.vrms.controllers.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.shashank.vrms.daos.BrandDAO;

@WebServlet("/admin/brand/delete/*")
public class DeleteBrandController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DeleteProductController controller Servlet");
		String path = request.getPathInfo();
		int id = Integer.parseInt(path.substring(1));
		System.out.println(id);
		
		try {
			
			BrandDAO brandDAO = new BrandDAO();
			brandDAO.deleteBrand(id);
			HttpSession session = request.getSession();
			session.setAttribute("msg","Brand deleted successfully...");
			response.sendRedirect(request.getContextPath() +"/admin/brands");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
