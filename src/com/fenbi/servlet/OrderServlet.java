package com.fenbi.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fenbi.bean.Address;
import com.fenbi.bean.Course;
import com.fenbi.bean.Order;
import com.fenbi.bean.User;
import com.fenbi.service.AddressService;
import com.fenbi.service.CourseService;
import com.fenbi.service.OrderService;
import com.fenbi.service.impl.AddressServiceImpl;
import com.fenbi.service.impl.CourseServiceImpl;
import com.fenbi.service.impl.OrderServiceImpl;
import com.fenbi.utils.WEButils;
import com.google.gson.Gson;

public class OrderServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	
	AddressService aservice = new AddressServiceImpl();
	
	public void previewOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//按courseId找到课程信息，传递
		String courseId = request.getParameter("courseId");
		String addressId = request.getParameter("addressId");
		System.out.println(addressId);
		CourseService cservice = new CourseServiceImpl();
		Course course = cservice.getCourseByCourseId(courseId);
		
		//按user找到默认地址，传递///业务更改，从立即购买进入则从数据库找数据
		//从修改地址返回则用刚刚选中返回的数据，  添加判断
		Address address = null;
		if(addressId == null | "".equals(addressId)) {
			User user = (User)request.getSession().getAttribute("loginUser");
			address = aservice.getDefaultAddress(user.getId());
		}
		else {
			address = aservice.getAddressByAddressId(addressId);
		}
		//跳转到order_submit.jsp
		request.setAttribute("course", course);
		request.setAttribute("defaultAddress", address);
		request.getRequestDispatcher("/page/order/order_submit.jsp").forward(request, response);
	}
	
	public void saveOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order order = WEButils.param2Bean(request, new Order());
		User user = (User)request.getSession().getAttribute("loginUser");
		order.setUserId(user.getId());
		System.out.println("获取的"+order);
		OrderService service = new OrderServiceImpl();
		int save = service.saveOrder(order);
		System.out.println(save);
		response.setContentType("application/json;charset=utf-8");
		Gson gson = new Gson();
		HashMap<String,Object> map = new HashMap<>();
		
		map.put("code", save);
		map.put("msg", save > 0 ?"获取成功":"获取失败");
		String json = gson.toJson(map);
		
		response.getWriter().print(json);	
	}
	
	
}