package com.fenbi.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fenbi.bean.Address;
import com.fenbi.bean.City;
import com.fenbi.bean.County;
import com.fenbi.bean.Province;
import com.fenbi.bean.User;
import com.fenbi.service.AddressService;
import com.fenbi.service.impl.AddressServiceImpl;
import com.fenbi.utils.WEButils;
import com.google.gson.Gson;

public class AddressServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	
	AddressService aservice = new AddressServiceImpl();
	
	/*
	 * @Description: 获取所有省的请求
	* @param request：
	* @param response：
	* @throws ServletException
	* @throws IOException:
	 */
	public void getProvince(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<Province> province = aservice.getProvince();
		
		response.setContentType("application/json;charset=utf-8");
		
		Gson gson = new Gson();
		HashMap<String,Object> map = new HashMap<>();
		
		map.put("code", province == null ?0:1);
		map.put("province",province);
		map.put("msg", province == null ?"获取失败":"获取成功");
		String json = gson.toJson(map);
		
		response.getWriter().print(json);
	}
	
	public void getCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String provinceId = request.getParameter("provinceId");
		System.out.println(provinceId);
		List<City> city = aservice.getCityByProvinceId(provinceId);
		
		response.setContentType("application/json;charset=utf-8");
		
		Gson gson = new Gson();
		HashMap<String,Object> map = new HashMap<>();
		
		map.put("code", city == null ?0:1);
		map.put("city",city);
		map.put("msg", city == null ?"获取失败":"获取成功");
		String json = gson.toJson(map);
		
		response.getWriter().print(json);
	}
	
	public void getCounty(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cityId = request.getParameter("cityId");
		System.out.println(cityId);
		List<County> county = aservice.getCountyByCityId(cityId);
		
		response.setContentType("application/json;charset=utf-8");
		
		Gson gson = new Gson();
		HashMap<String,Object> map = new HashMap<>();
		
		map.put("code", county == null ?0:1);
		map.put("county",county);
		map.put("msg", county == null ?"获取失败":"获取成功");
		String json = gson.toJson(map);
		
		response.getWriter().print(json);
	}

	
	public void saveAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Address address = WEButils.param2Bean(request, new Address());
		User user = (User) request.getSession().getAttribute("loginUser");
		address.setUserId(user.getId());
		System.out.println(address);
		boolean saveStatus = aservice.saveAddress(address);
		
		response.setContentType("application/json;charset=utf-8");
		Gson gson = new Gson();
		HashMap<String,Object> map = new HashMap<>();
		
		map.put("code", saveStatus);
		String json = gson.toJson(map);
		
		response.getWriter().print(json);	
		
	}
	
	public void ManageAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = (User) request.getSession().getAttribute("loginUser");
		List<Address> addressList = aservice.getAddressByUserId(user.getId());
		request.setAttribute("addressList", addressList);
		request.getRequestDispatcher("/page/order/address.jsp").forward(request, response);
	}
	
	//修改地址中默认地址的属性
	public void UpdateAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = (User) request.getSession().getAttribute("loginUser");
		String addressId = request.getParameter("addressId");
		
		int updateY2N = aservice.updateY2N(user.getId());
		int updateN2Y = aservice.updateN2Y(user.getId(), addressId);
		int result = updateY2N+updateN2Y;

		response.setContentType("application/json;charset=utf-8");
		Gson gson = new Gson();
		HashMap<String,Object> map = new HashMap<>();
		
		map.put("code", result);
		map.put("msg", result > 1 ?"获取成功":"获取失败");
		String json = gson.toJson(map);
		
		response.getWriter().print(json);	
	}
	
	public void DeleteAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String addressId = request.getParameter("addressId");
		int delete = aservice.deleteAddress(addressId);

		response.setContentType("application/json;charset=utf-8");
		Gson gson = new Gson();
		HashMap<String,Object> map = new HashMap<>();
		
		map.put("code", delete);
		map.put("msg", delete > 0 ?"获取成功":"获取失败");
		String json = gson.toJson(map);
		
		response.getWriter().print(json);	
	}
	
	//修改地址中各个值
	public void AlterAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Address address = WEButils.param2Bean(request, new Address());
		System.out.println(address);
		int alter = aservice.alterAddress(address);

		response.setContentType("application/json;charset=utf-8");
		Gson gson = new Gson();
		HashMap<String,Object> map = new HashMap<>();
		
		map.put("code", alter);
		map.put("msg", alter > 0 ?"获取成功":"获取失败");
		String json = gson.toJson(map);
		
		response.getWriter().print(json);	
	}
	
	
	
	
	
	
	
}