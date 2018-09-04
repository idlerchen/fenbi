package com.fenbi.service.impl;

import com.fenbi.bean.User;
import com.fenbi.dao.UserDao;
import com.fenbi.dao.impl.UserDaoImpl;
import com.fenbi.service.UserService;
import com.fenbi.utils.MD5Utils;
/**
 * @version:p_d1 
* @Description: UserService的实现类
* @author: cgq  
* @date: 2018年8月4日 下午10:03:16
 */
public class UserServiceImpl implements UserService {
	UserDao dao = new UserDaoImpl();
	@Override
	public User login(String username, String password) {
		
		User loginUser = dao.getUserByNameAndPassword(username, MD5Utils.md5(password));
		return loginUser;
	}

	@Override
	public boolean register(User user) {
		String password = user.getPassword();
		user.setPassword(MD5Utils.md5(password));
		return dao.saveUser(user) >0;
	}

	@Override
	public boolean checkUser(String username) {
		User user = dao.checkUserByName(username);
		return user == null;
	}

}
