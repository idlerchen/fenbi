package com.fenbi.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import com.fenbi.bean.User;
import com.fenbi.dao.BaseDao;
import com.fenbi.dao.UserDao;
import com.fenbi.utils.DButils;

/**
 * @version:p_d1 /p_d2
* @Description: UserDao实现类/1.利用DButils简化开发 2.抽取重复代码(传递参数，封装结果)至父类
* @author: cgq  
* @date: 2018年8月4日 下午9:59:24/ 8.6
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {
	/*
	 * 用户登录时查询获取该用户信息 p_d1
	 * 代码提取至父类，调用时传入sql、操作字段即可
	 */
	@Override
	public User getUserByNameAndPassword(String username, String password) {
		
//		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
//
//		User queryUser = null;
//		try {
//			queryUser = runner.query("select * from fb_user where username=? and password=?",
//					new BeanHandler<>(User.class), username, password);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return queryUser;
		
		String sql = "select * from fb_user where username = ? and password = ?";
		return this.getBean(sql, username,password);
	}

	/*
	 * 用户注册时插入用户信息至数据库用户表
	 */
	@Override
	public int saveUser(User user) {
		
		String sql = "insert into fb_user(username,password) values(?,?)";
		return this.update(sql, user.getUsername(),user.getPassword());
	}

	@Override
	public User checkUserByName(String username) {
		String sql = "select * from fb_user where username=?";
		return this.getBean(sql, username);
	}

}
