package com.fenbi.dao.impl;

import java.util.List;

import com.fenbi.bean.Lesson;
import com.fenbi.dao.BaseDao;
import com.fenbi.dao.LessonDao;

public class LessonDaoImpl extends BaseDao<Lesson> implements LessonDao {

	@Override
	public List<Lesson> getLessonListByCourseId(int courseId) {
		String sql = "SELECT fl.id lessonId,fl.course_id courseId,fl.teacher_id teacherId,fl.title lessonTitle,"+ 
				"fl.start_time startTime,fl.end_time endTime,fl.create_time createTime,ft.name teacherName " + 
				"FROM fb_course fc,fb_lesson fl,fb_teacher ft " + 
				"WHERE fc.id = fl.course_id AND fc.status = 1 AND fl.teacher_id = ft.id AND fc.id = ?";
		return this.getBeanList(sql, courseId);
	}

}
