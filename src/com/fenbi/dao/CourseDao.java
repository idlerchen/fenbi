package com.fenbi.dao;

import java.util.List;

import com.fenbi.bean.Course;

public interface CourseDao {
	/*
	 * @Description:获取所有课程 
	* @return:课程list集合
	 */
	List<Course> getCourseList();
	/*
	 * @Description: 根据课程分类获取课程列表
	* @param courseTypeId：课程分类id
	* @return:指定分类的课程列表
	 */
	List<Course> getCourseListByCourseTypeId(String courseTypeId);
	/*
	 * @Description: 根据课程ID获取指定课程的详细信息
	* @param courseId：课程id
	* @return:该课程信息
	 */
	Course getCourseListByCourseId(String courseId);
	
	/*
	 * @Description: 根据用户ID获取改用户的所有课程列表
	* @param userId：传入用户的id
	* @return:返回用户的课程列表
	 */
	List<Course> getMyCourseList(int userId);
	/*
	 * @Description: 根据课程分类id获取某用户的课程列表
	* @param userId：用户id
	* @param courseTypeId：课程分类id
	* @return:制定分类的课程集合
	 */
	List<Course> getMyCourseListByCourseTypeId(int userId,String courseTypeId);
	/*
	 * @Description: 根据课程id获取某用户的指定课程信息
	* @param userId：用户id
	* @param courseId：课程id
	* @return:某课程
	 */
	Course getMyCourseListByCourseId(int userId,String courseId);
	

}
