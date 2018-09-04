package com.fenbi.bean;

import java.io.Serializable;

/**
 * @version:project_day1 
* @Description: 登录用户的javabean
* @author: cgq  
* @date: 2018年8月4日 下午9:57:19
 */
public class User implements Serializable{

	private int id;
	private String username;
	private String password;
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	public User() {
		
	}
	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
