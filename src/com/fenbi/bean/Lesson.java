package com.fenbi.bean;

import java.util.Date;

public class Lesson {

	private int lessonId;
	
	private int courseId;
	
	private int teacherId;
	
	private String lessonTitle;
	
	private Date startTime;
	
	private Date endTime;
	
	private Date createTime;
	
	private String teacherName;

	public Lesson(int lessonId, int courseId, int teacherId, String lessonTitle, Date startTime, Date endTime,
			Date createTime, String teacherName) {
		this.lessonId = lessonId;
		this.courseId = courseId;
		this.teacherId = teacherId;
		this.lessonTitle = lessonTitle;
		this.startTime = startTime;
		this.endTime = endTime;
		this.createTime = createTime;
		this.teacherName = teacherName;
	}

	public Lesson() {
	}

	public int getLessonId() {
		return lessonId;
	}

	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getLessonTitle() {
		return lessonTitle;
	}

	public void setLessonTitle(String lessonTitle) {
		this.lessonTitle = lessonTitle;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	@Override
	public String toString() {
		return "Lesson [lessonId=" + lessonId + ", courseId=" + courseId + ", teacherId=" + teacherId + ", lessonTitle="
				+ lessonTitle + ", startTime=" + startTime + ", endTime=" + endTime + ", createTime=" + createTime
				+ ", teacherName=" + teacherName + "]";
	}
	
	
}
