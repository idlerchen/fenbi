package com.fenbi.dao;

import java.util.List;

import com.fenbi.bean.Teacher;

public interface TeacherDao {
	/*
	 * @Description: 根据课程id获取该课程的老师列表
	* @param courseId：传入课程id
	* @return:返回老师的list集合
	 */
	List<Teacher> getTeacherListByCourseId(int courseId);

}
