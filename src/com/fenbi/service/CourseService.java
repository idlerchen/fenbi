package com.fenbi.service;

import java.util.List;

import com.fenbi.bean.Course;
import com.fenbi.bean.CourseType;
import com.fenbi.bean.Order;

public interface CourseService {
	
	List<CourseType> getCourseTypeList();

	List<Course> getCourseList();
	
	List<Course> getCourseListByCourseTypeId(String courseTypeId);
	
	Course getCourseByCourseId(String courseId);
	
	boolean queryIsBuy(int userId, String courseId);
	
//	List<CourseType> getCourseTypeList();

	List<Course> getMyCourseList(int userId);
	
	List<Course> getMyCourseListByCourseTypeId(int userId,String courseTypeId);
	
	Course getMyCourseListByCourseId(int userId,String courseId);
}
