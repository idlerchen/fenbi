package com.fenbi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fenbi.bean.Course;
import com.fenbi.bean.CourseType;
import com.fenbi.bean.User;
import com.fenbi.service.CourseService;
import com.fenbi.service.impl.CourseServiceImpl;

public class MyCourseServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public void getMyCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		User user = (User)request.getSession().getAttribute("loginUser");
		CourseService mycourseService = new CourseServiceImpl();
		List<CourseType> courseTypeList = mycourseService.getCourseTypeList();
		
		int userId = user.getId();
		
		List<Course> myCourseList = mycourseService.getMyCourseList(userId);
		
		request.setAttribute("courseTypeList", courseTypeList);
		request.setAttribute("myCourseList", myCourseList);
		request.getRequestDispatcher("/page/mycourse/course_list.jsp").forward(request, response);
	
	}

	public void getMyCourseByCourseTypeId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = (User)request.getSession().getAttribute("loginUser");
		
		CourseService mycourseService = new CourseServiceImpl();
		List<CourseType> courseTypeList = mycourseService.getCourseTypeList();
		int userId = user.getId();
		String courseTypeId = request.getParameter("courseTypeId");
		List<Course> myCourseList = mycourseService.getMyCourseListByCourseTypeId(userId, courseTypeId);
		
		request.setAttribute("courseTypeList", courseTypeList);
		request.setAttribute("myCourseList", myCourseList);
		request.getRequestDispatcher("/page/mycourse/course_list.jsp").forward(request, response);
	
		
	}
	
	public void getMyCourseByCourseId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = (User)request.getSession().getAttribute("loginUser");
		
		CourseService mycourseService = new CourseServiceImpl();
		List<CourseType> courseTypeList = mycourseService.getCourseTypeList();
		int userId = user.getId();
		String courseId = request.getParameter("courseId");
		Course myCourse = mycourseService.getMyCourseListByCourseId(userId, courseId);
		
		request.setAttribute("courseTypeList", courseTypeList);
		request.setAttribute("course", myCourse);
		request.getRequestDispatcher("/page/mycourse/course_detail.jsp").forward(request, response);
	
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}