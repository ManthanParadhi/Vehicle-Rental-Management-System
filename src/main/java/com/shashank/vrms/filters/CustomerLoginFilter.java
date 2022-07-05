package com.shashank.vrms.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shashank.vrms.enums.Role;

@WebFilter("/c/*")
public class CustomerLoginFilter extends HttpFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		HttpSession session = request.getSession(false);
		Role role = session==null?null:(Role)session.getAttribute("role");
		
		if(role == null)
			response.sendRedirect(request.getContextPath() +"/login");
		else if(role==Role.CUSTOMER)
			chain.doFilter(request, response);
		else {
			response.sendRedirect(request.getContextPath() +"/");
		}
	}

}
