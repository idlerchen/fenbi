package com.fenbi.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fenbi.bean.Course;
import com.fenbi.dao.CourseDao;
import com.fenbi.dao.impl.CourseDaoImpl;

class TestMCD {

	@Test
	void testGetMyCourseList() {
		CourseDao dao = new CourseDaoImpl();
		
//		List<Course> m = dao.getMyCourseList(46);
//		for(Course c:m) {
//			System.out.println(c);
//		}
		List<Course> m1 = dao.getMyCourseListByCourseTypeId(46, "4");
		for(Course c:m1) {
			System.out.println(c);
		}
		System.out.println("-----------");
		Course m2 = dao.getMyCourseListByCourseId(46, "1");
		System.out.println(m2);
		
		
	}

}
