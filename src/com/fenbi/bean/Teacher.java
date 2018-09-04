package com.fenbi.bean;

import java.util.Date;

public class Teacher {
	private int teacherId;
	
	private String teacherName;
	
	private String gender;
	
	private String email;
	
	private String useName;
	
	private int status;
	
	private String photoUrl;
	
	private String description;
	
	private double score;
	
	private Date createTime;

	public Teacher(int teacherId, String teacherName, String gender, String email, String useName, int status,
			String photoUrl, String description, double score, Date createTime) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.gender = gender;
		this.email = email;
		this.useName = useName;
		this.status = status;
		this.photoUrl = photoUrl;
		this.description = description;
		this.score = score;
		this.createTime = createTime;
	}

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", gender=" + gender + ", email="
				+ email + ", useName=" + useName + ", status=" + status + ", photoUrl=" + photoUrl + ", description="
				+ description + ", score=" + score + ", createTime=" + createTime + "]";
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUseName() {
		return useName;
	}

	public void setUseName(String useName) {
		this.useName = useName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	

}
