package com.fenbi.service.impl;

import java.util.List;

import com.fenbi.bean.Course;
import com.fenbi.bean.CourseType;
import com.fenbi.bean.Order;
import com.fenbi.dao.CourseDao;
import com.fenbi.dao.CourseTypeDao;
import com.fenbi.dao.LessonDao;
import com.fenbi.dao.OrderDao;
import com.fenbi.dao.TeacherDao;
import com.fenbi.dao.impl.CourseDaoImpl;
import com.fenbi.dao.impl.CourseTypeDaoImpl;
import com.fenbi.dao.impl.LessonDaoImpl;
import com.fenbi.dao.impl.OrderDaoImpl;
import com.fenbi.dao.impl.TeacherDaoImpl;
import com.fenbi.service.CourseService;

public class CourseServiceImpl implements CourseService {
	
	CourseDao cdao = new CourseDaoImpl();
	CourseTypeDao ctdao = new CourseTypeDaoImpl();
	TeacherDao tdao = new TeacherDaoImpl();
	LessonDao ldao = new LessonDaoImpl();
	OrderDao odao = new OrderDaoImpl();
	

	@Override
	public List<CourseType> getCourseTypeList() {
		
		return ctdao.getCourseTypeList();
	}

	@Override
	public List<Course> getCourseList() {
		
		List<Course> cs = cdao.getCourseList();
		
		for(Course c:cs) {
			
			int cid = c.getCourseId();
			
			c.setTeachers(tdao.getTeacherListByCourseId(cid));
			
			c.setLessons(ldao.getLessonListByCourseId(cid));
		}
		return cs;
	}
//47.98.172.33
	@Override
	public List<Course> getCourseListByCourseTypeId(String courseTypeId) {
		List<Course> cs = cdao.getCourseListByCourseTypeId(courseTypeId);
				
			for(Course c:cs) {
				
				int cid = c.getCourseId();
				
				c.setTeachers(tdao.getTeacherListByCourseId(cid));
				
				c.setLessons(ldao.getLessonListByCourseId(cid));
			}
			return cs;
	}

	@Override
	public Course getCourseByCourseId(String courseId) {
		Course c = cdao.getCourseListByCourseId(courseId);
		
			int cid = c.getCourseId();
			
			c.setTeachers(tdao.getTeacherListByCourseId(cid));
			
			c.setLessons(ldao.getLessonListByCourseId(cid));
		
		return c;
	}

	@Override
	public boolean queryIsBuy(int userId, String courseId) {
		 Order order = odao.getOrderByuserIdAndCourseId(userId, courseId);
		 return order != null;
	}
	
	
	@Override
	public List<Course> getMyCourseList(int userId) {
		List<Course> ml = cdao.getMyCourseList(userId);
		for(Course c:ml) {
					
			int cid = c.getCourseId();
			
			c.setTeachers(tdao.getTeacherListByCourseId(cid));
			
			c.setLessons(ldao.getLessonListByCourseId(cid));
		}
		
		return ml;
	}


//	@Override
//	public List<CourseType> getCourseTypeList() {
//		return ctdao.getCourseTypeList();
//	}


	@Override
	public List<Course> getMyCourseListByCourseTypeId(int userId, String courseTypeId) {
		List<Course> ml = cdao.getMyCourseListByCourseTypeId(userId, courseTypeId);
		for(Course c:ml) {
					
			int cid = c.getCourseId();
			
			c.setTeachers(tdao.getTeacherListByCourseId(cid));
			
			c.setLessons(ldao.getLessonListByCourseId(cid));
		}
		
		return ml;
	}


	@Override
	public Course getMyCourseListByCourseId(int userId, String courseId) {
		Course ml = cdao.getMyCourseListByCourseId(userId, courseId);
					
			int cid = ml.getCourseId();
			
			ml.setTeachers(tdao.getTeacherListByCourseId(cid));
			
			ml.setLessons(ldao.getLessonListByCourseId(cid));
		
		return ml;
	}
}
