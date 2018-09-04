package com.fenbi.dao;

import java.util.List;

import com.fenbi.bean.Lesson;

public interface LessonDao {
	/*
	 * @Description:根据课程id获取该课程的课时 
	* @param courseId：传入课程id
	* @return:返回课时
	 */
	List<Lesson> getLessonListByCourseId(int courseId);

}
