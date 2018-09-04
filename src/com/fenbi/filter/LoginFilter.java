package com.fenbi.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fenbi.bean.User;


public class LoginFilter extends HttpFilter  {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		User user = (User)request.getSession().getAttribute("loginUser");
//		System.out.println(user);
		if(user == null) {
			request.setAttribute("msg", "请先登录");
			request.getRequestDispatcher("/page/user/login.jsp").forward(request, response);
		}else {
			chain.doFilter(request, response);
		}
	}

   
}
