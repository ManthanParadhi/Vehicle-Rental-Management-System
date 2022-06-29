package com.shashank.vrms.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shashank.vrms.enums.Role;



@WebFilter("/*")
public class NoCacheFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("in filter");
		  HttpServletRequest request = (HttpServletRequest)req;
	        HttpServletResponse response = (HttpServletResponse) res;

	        response.setHeader("Cache-Control", "no-cache, no-store");
	        response.setHeader("Pragma", "no-cache");
	        
	        String path = request.getRequestURI().substring(request.getContextPath().length());
	        HttpSession session = request.getSession(false);
	        Role role = Role.valueOf((String)session.getAttribute("role"));
	        System.out.println(path);
	        
	        if(session==null || session.getAttribute("email")==null){
	        	System.out.println("1st if");
	        	chain.doFilter(request, response);
	        }
	        else if (path.equals("/login") || path.equals("/register") ) {
	        	System.out.println("2st if");
	        	response.sendRedirect(request.getContextPath()+"/");
			}
	        else if (role==Role.ADMIN && !path.contains("/admin")) {
				response.sendRedirect(request.getContextPath()+"/admin/");
			}
	       
	        
	        
	        
	        else {
				chain.doFilter(request, response);
			}
	        
	        
	        	
	       
	        
		
	}


}
