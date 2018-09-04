package com.fenbi.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fenbi.bean.Course;
import com.fenbi.dao.CourseDao;
import com.fenbi.dao.impl.CourseDaoImpl;

class TestCD {

	@Test
	void testGetCourseList() {
		CourseDao courseDao = new CourseDaoImpl();
		List<Course> courses = courseDao.getCourseList();
		for(Course c:courses) {
			System.out.println(c);
		}
	}
	
	@Test
	void t() {
		CourseDao courseDao = new CourseDaoImpl();
		List<Course> courses = courseDao.getCourseListByCourseTypeId("4");
		for(Course c:courses) {
			System.out.println(c);
		}
	}
	
	@Test
	void tcti() {
		CourseDao courseDao = new CourseDaoImpl();
		Course c = courseDao.getCourseListByCourseId("38");
			System.out.println(c);
	}

}
