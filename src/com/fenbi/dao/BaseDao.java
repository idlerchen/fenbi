package com.fenbi.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.fenbi.utils.DButils;
/*
 * 泛型类，传入泛型，执行方法时需要获取这个对象类型，去实例化sql得到的rs，封装成对象返回
 */
public class BaseDao<T> {	
	
	private Class type;
	
	public BaseDao() {
		//获取父类的泛型，由于此类是父类不会调用，是通过子类执行时调用，所以是得到父类的泛型
		ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass();
		//得到泛型的类型，是一个数组
		Type[] types = pt.getActualTypeArguments();
		//得到第一个泛型，转成class类型，type是class父类，在执行sql封装bean对象时用上
		type = (Class)types[0];
	}
	
	//执行增删改这些更新操作，得到int返回值，不需要使用泛型
	//Object... params可变参数 ... ，0-n个参数
	public int update(String sql, Object... params) {
		QueryRunner runner = new QueryRunner(DButils.getDs());
		int count = 0;
		try {
			count =  runner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	//获得一条记录，封装成传进来的T-泛型类型并返回
	public T getBean(String sql, Object... params) {
		QueryRunner runner = new QueryRunner(DButils.getDs());
		T t = null;
		try {
			t = runner.query(sql, new BeanHandler<T>(type), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}
	
	//获得N条记录，封装成list<T>并返回
	public List<T> getBeanList(String sql, Object... params) {
		QueryRunner runner = new QueryRunner(DButils.getDs());
		List<T> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<T>(type), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
