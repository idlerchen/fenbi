package com.fenbi.service;

import com.fenbi.bean.User;
/**
 * @version:p_d1 
* @Description: UserDao的service，调用UserDao得到的数据
* @author: cgq  
* @date: 2018年8月4日 下午10:01:30
 */
public interface UserService {
	
	User login(String username,String password);
	
	boolean register(User user);
	
	boolean checkUser(String username);

}
