package com.fenbi.dao.impl;

import java.util.List;

import com.fenbi.bean.Teacher;
import com.fenbi.dao.BaseDao;

public class TeacherDaoImpl extends BaseDao<Teacher> implements com.fenbi.dao.TeacherDao {

	@Override
	public List<Teacher> getTeacherListByCourseId(int courseId) {
		String sql = "SELECT ft.id teacherId,ft.name teacherName,ft.gender gender,email,username,"
				+ "STATUS,photo_url photoUrl,description,score,create_time createTime " + 
				"FROM fb_teacher ft " + 
				"WHERE ft.id IN (SELECT DISTINCT teacher_id " + 
				"	FROM fb_course fc,fb_lesson fl " + 
				"	WHERE fc.id = fl.course_id AND fc.id=?)";
		return this.getBeanList(sql, courseId);
	}

}
