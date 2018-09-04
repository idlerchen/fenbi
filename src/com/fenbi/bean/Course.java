package com.fenbi.bean;

import java.util.Date;
import java.util.List;

/**
 * @version: p_d3
* @Description: course的实体类
* @author: cgq  
* @date: 2018年8月7日 下午9:13:55
 */
public class Course {
	private int courseId;	//课程id
	
	private int courseTypeId;		//课程类型id
	
	private String courseTitle;	//课程标题
	
	private String description;	//课程描述信息
	
	private double price;	//课程价格
	
	private int total;	//课程限购数量
	
	private int saleNum;	//课程总购买人数
	
	private int lessonCount;	//课程课时数
	
	private Date startTime;		//课程开始时间
	
	private Date endTime;	//课程结束时间
	
	private int status;		//课程上下线状态
	
	private String courseTypeName; //课程类型名字
	
	private List<Teacher> teachers;	//课程讲课老师
	
	private List<Lesson> lessons;	//课程课时信息

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseTypeId=" + courseTypeId + ", courseTitle=" + courseTitle
				+ ", description=" + description + ", price=" + price + ", total=" + total + ", saleNum=" + saleNum
				+ ", lessonCount=" + lessonCount + ", startTime=" + startTime + ", endTime=" + endTime + ", status="
				+ status + ", courseTypeName=" + courseTypeName + ", teachers=" + teachers + ", lessons=" + lessons
				+ "]";
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(int courseId, int courseTypeId, String courseTitle, String description, double price, int total,
			int saleNum, int lessonCount, Date startTime, Date endTime, int status, String courseTypeName,
			List<Teacher> teachers, List<Lesson> lessons) {
		super();
		this.courseId = courseId;
		this.courseTypeId = courseTypeId;
		this.courseTitle = courseTitle;
		this.description = description;
		this.price = price;
		this.total = total;
		this.saleNum = saleNum;
		this.lessonCount = lessonCount;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
		this.courseTypeName = courseTypeName;
		this.teachers = teachers;
		this.lessons = lessons;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getCourseTypeId() {
		return courseTypeId;
	}

	public void setCourseTypeId(int courseTypeId) {
		this.courseTypeId = courseTypeId;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getSaleNum() {
		return saleNum;
	}

	public void setSaleNum(int saleNum) {
		this.saleNum = saleNum;
	}

	public int getLessonCount() {
		return lessonCount;
	}

	public void setLessonCount(int lessonCount) {
		this.lessonCount = lessonCount;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCourseTypeName() {
		return courseTypeName;
	}

	public void setCourseTypeName(String courseTypeName) {
		this.courseTypeName = courseTypeName;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

	
}
