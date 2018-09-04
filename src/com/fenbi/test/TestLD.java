package com.fenbi.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fenbi.bean.Lesson;
import com.fenbi.dao.LessonDao;
import com.fenbi.dao.impl.LessonDaoImpl;

class TestLD {

	@Test
	void testGetLessonListByCourseId() {
		LessonDao dao = new LessonDaoImpl();
		
		List<Lesson> les = dao.getLessonListByCourseId(3);
		
		for(Lesson l:les) {
			System.out.println(l);
		}
	}

}
