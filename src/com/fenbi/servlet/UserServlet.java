package com.fenbi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fenbi.bean.User;
import com.fenbi.service.UserService;
import com.fenbi.service.impl.UserServiceImpl;
import com.fenbi.utils.WEButils;

public class UserServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	//继承父类，doget部分代码不需要了。
//	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	...
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//调用工具类：接收请求参数，传递bean对象，返回封装bean对象，
		User user = WEButils.param2Bean(request, new User());
		
		UserService service = new UserServiceImpl();
		User loginUser = service.login(user.getUsername(), user.getPassword());
		
		if(loginUser != null) {
			// 登陆成功了，将用户名以Cookie的形式发送给浏览器，浏览器保存信息。
			Cookie cookie = new Cookie("username", loginUser.getUsername());
			
			// 设置有效时间  7天
			cookie.setMaxAge(60*60*24*7);
			
			// 设置Cookie的有效路径
//			cookie.setPath(request.getContextPath() + "/page/user/login.jsp");
			
			response.addCookie(cookie);
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			
			//成功，重定向到首页
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
		else {
			//登录失败，转发登录页面继续登录,待会错误提示的参数
			request.setAttribute("msg", "登录失败");
			request.getRequestDispatcher("/page/user/login.jsp").forward(request, response);
		}
	}
	
	public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String formCode = request.getParameter("validate");
		String imgCode = (String)request.getSession().getAttribute("imageCode");
		System.out.println("输入的验证码："+formCode);
		System.out.println("生成的验证码："+imgCode);
		//验证码错误直接返回
		if(!imgCode.equals(formCode)) {
			//验证码错误，继续注册
			request.setAttribute("msg", "验证码错误");
			request.getRequestDispatcher("/page/user/register.jsp").forward(request, response);
		}
		//验证码正确再判断账户密码
		else {
			//调用工具类：接收请求参数，传递bean对象，返回封装bean对象，
			User user = WEButils.param2Bean(request, new User());
			UserService service = new UserServiceImpl();
			boolean save = service.register(user);
		
			if(save) {
				//注册成功，到达首页
				response.sendRedirect(request.getContextPath()+"/page/user/login.jsp");
			}else {
				//失败，继续注册
				request.setAttribute("msg", "注册失败");
				request.getRequestDispatcher("/page/user/register.jsp").forward(request, response);
			}
		}
		
	}
	
	public void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		String referer = request.getHeader("Referer");
		response.sendRedirect(referer);
	}
	
	public void checkUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService service = new UserServiceImpl();
		String username = request.getParameter("username");
		boolean flag = service.checkUser(username);
		
		if(flag) {
			response.getWriter().print("1");
		}else {
			response.getWriter().print("0");
		}
		
	}


}