package com.fenbi.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fenbi.bean.Teacher;
import com.fenbi.dao.TeacherDao;
import com.fenbi.dao.impl.TeacherDaoImpl;

class TestTD {

	@Test
	void testGetTeacherListByCourseId() {
		TeacherDao dao = new TeacherDaoImpl();
		
		List<Teacher> ts = dao.getTeacherListByCourseId(3);
		
		for(Teacher t:ts) {
			System.out.println(t);
		}
	}

}
