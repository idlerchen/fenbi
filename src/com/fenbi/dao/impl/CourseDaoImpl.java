package com.fenbi.dao.impl;

import java.util.List;

import com.fenbi.bean.Course;
import com.fenbi.dao.BaseDao;
import com.fenbi.dao.CourseDao;

public class CourseDaoImpl extends BaseDao<Course> implements CourseDao {

	@Override
	public List<Course> getCourseList() {
		String sql = "SELECT fc.id courseId,fc.type_id courseTypeId,fc.title courseTitle,fc.description description,fc.price price,"
				+ "fc.total total,fc.sale_num saleNum,fc.lesson_count lessonCount," + 
				"fc.start_time startTime,fc.end_time endTime,fc.create_time createTime,fc.status STATUS,fct.name courseTypeName " + 
				"FROM fb_course fc,fb_course_type fct " + 
				"WHERE fc.type_id = fct.id AND STATUS = 1";
		
		return this.getBeanList(sql);
	}

	@Override
	public List<Course> getCourseListByCourseTypeId(String courseTypeId) {
		String sql = "SELECT fc.id courseId,fc.type_id courseTypeId,fc.title courseTitle,fc.description description,fc.price price,"
				+ "fc.total total,fc.sale_num saleNum,fc.lesson_count lessonCount," + 
				"fc.start_time startTime,fc.end_time endTime,fc.create_time createTime,fc.status STATUS,fct.name courseTypeName " + 
				"FROM fb_course fc,fb_course_type fct " + 
				"WHERE fc.type_id = fct.id AND STATUS = 1 AND fc.type_id=?";
		return this.getBeanList(sql, courseTypeId);
	}

	@Override
	public Course getCourseListByCourseId(String courseId) {
		String sql = "SELECT fc.id courseId,fc.type_id courseTypeId,fc.title courseTitle,fc.description description,fc.price price,"
				+ "fc.total total,fc.sale_num saleNum,fc.lesson_count lessonCount," + 
				"fc.start_time startTime,fc.end_time endTime,fc.create_time createTime,fc.status STATUS,fct.name courseTypeName " + 
				"FROM fb_course fc,fb_course_type fct " + 
				"WHERE fc.type_id = fct.id AND STATUS = 1 AND fc.id=?";
		return this.getBean(sql, courseId);
	}
	
	@Override
	public List<Course> getMyCourseList(int userId) {
		String sql = "SELECT fc.id courseId,fc.type_id courseTypeId,fc.title courseTitle,fc.description description,fc.price price,\r\n" + 
				"fc.total total,fc.sale_num saleNum,fc.lesson_count lessonCount,fc.start_time startTime,fc.end_time endTime,fc.create_time createTime,\r\n" + 
				"fc.status STATUS,fct.name courseTypeName \r\n" + 
				"FROM fb_course fc,fb_course_type fct,fb_order fo\r\n" + 
				"WHERE fc.type_id = fct.id  AND fc.id=fo.course_id AND user_id=?";
		return this.getBeanList(sql, userId);
	}

	@Override
	public List<Course> getMyCourseListByCourseTypeId(int userId, String courseTypeId) {
		String sql = "SELECT fc.id courseId,fc.type_id courseTypeId,fc.title courseTitle,fc.description description,fc.price price,\r\n" + 
				"fc.total total,fc.sale_num saleNum,fc.lesson_count lessonCount,fc.start_time startTime,fc.end_time endTime,fc.create_time createTime,\r\n" + 
				"fc.status STATUS,fct.name courseTypeName \r\n" + 
				"FROM fb_course fc,fb_course_type fct,fb_order fo\r\n" + 
				"WHERE fc.type_id = fct.id  AND fc.id=fo.course_id AND user_id=? AND fc.type_id=?";
		return this.getBeanList(sql, userId,courseTypeId);
	}

	@Override
	public Course getMyCourseListByCourseId(int userId, String courseId) {
		String sql = "SELECT fc.id courseId,fc.type_id courseTypeId,fc.title courseTitle,fc.description description,fc.price price,\r\n" + 
				"fc.total total,fc.sale_num saleNum,fc.lesson_count lessonCount,fc.start_time startTime,fc.end_time endTime,fc.create_time createTime,\r\n" + 
				"fc.status STATUS,fct.name courseTypeName \r\n" + 
				"FROM fb_course fc,fb_course_type fct,fb_order fo\r\n" + 
				"WHERE fc.type_id = fct.id AND fc.id=fo.course_id AND user_id=? AND fc.id=?";
		return this.getBean(sql, userId,courseId);
	}

	

}
