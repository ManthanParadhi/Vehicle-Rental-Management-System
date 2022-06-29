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

@WebFilter("/admin/*")
public class AdminLoginFilter extends HttpFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		HttpSession session = request.getSession(false);
		Role role = Role.valueOf((String)session.getAttribute("role"));
		
		if(role==Role.ADMIN)
			chain.doFilter(request, response);
		else {
			response.sendRedirect(request.getContextPath() +"/");
		}
	}

}
