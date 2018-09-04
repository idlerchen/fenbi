package com.fenbi.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fenbi.bean.CourseType;
import com.fenbi.dao.CourseTypeDao;
import com.fenbi.dao.impl.CourseTypeDaoImpl;

class TestCTD {

	@Test
	void testGetCourseTypeList() {
		CourseTypeDao ctd = new CourseTypeDaoImpl();
		
		List<CourseType> cts = ctd.getCourseTypeList();
		for(CourseType ct:cts) {
			System.out.println(ct);
		}
	}

}
