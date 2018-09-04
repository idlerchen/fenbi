package com.fenbi.dao;

import com.fenbi.bean.User;
/**
 * @version:pro_day1 
* @Description: UserDao
* @author: cgq  
* @date: 2018年8月4日 下午9:58:48
 */
public interface UserDao {
	/*
	 * @Description: 用户登录时获取用户信息
	* @param username 用户名
	* @param password 用户密码
	* @return: 返回用户信息封装成User实体类
	 */
	User getUserByNameAndPassword(String username,String password);
	
	/*
	 * @Description: 用户注册
	* @param user 用户注册信息
	* @return: 用户插入数据库影响行数，>0则插入成功
	 */
	int saveUser(User user);
	
	User checkUserByName(String username);

}
