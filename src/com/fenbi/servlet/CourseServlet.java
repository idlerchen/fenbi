package com.fenbi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fenbi.bean.Course;
import com.fenbi.bean.CourseType;
import com.fenbi.bean.Order;
import com.fenbi.bean.User;
import com.fenbi.service.CourseService;
import com.fenbi.service.impl.CourseServiceImpl;

public class CourseServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	
	public void getCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		CourseService courseService = new CourseServiceImpl();
		
		List<CourseType> courseTypeList = courseService.getCourseTypeList();
		
		List<Course> courseList = courseService.getCourseList();
		
		request.setAttribute("courseTypeList", courseTypeList);
		request.setAttribute("courseList", courseList);
		request.getRequestDispatcher("/page/course/course_list.jsp").forward(request, response);
	}
	
	public void getCourseByCourseTypeId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
			
			CourseService courseService = new CourseServiceImpl();
			
			List<CourseType> courseTypeList = courseService.getCourseTypeList();
			
			String courseTypeId = request.getParameter("courseTypeId");
			List<Course> courseList = courseService.getCourseListByCourseTypeId(courseTypeId);
			
			request.setAttribute("courseTypeList", courseTypeList);
			request.setAttribute("courseList", courseList);
			request.getRequestDispatcher("/page/course/course_list.jsp").forward(request, response);
	}

	public void getCourseByCourseId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		CourseService courseService = new CourseServiceImpl();
		
		List<CourseType> courseTypeList = courseService.getCourseTypeList();
		User user = (User)request.getSession().getAttribute("loginUser");
		String courseId = request.getParameter("courseId");
		Course course = courseService.getCourseByCourseId(courseId);
		
		
		if(user == null) {
			// 没有登陆
			request.setAttribute("isBuy", false);
		}else {
			// 已经登陆了
			boolean isBuy = courseService.queryIsBuy(user.getId(), courseId);
			request.setAttribute("isBuy", isBuy);
		}
		request.setAttribute("courseTypeList", courseTypeList);
		request.setAttribute("course", course);
		request.getRequestDispatcher("/page/course/course_detail.jsp").forward(request, response);
	}

	

}