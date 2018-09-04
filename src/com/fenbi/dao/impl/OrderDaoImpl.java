package com.fenbi.dao.impl;

import com.fenbi.bean.Order;
import com.fenbi.dao.BaseDao;
import com.fenbi.dao.OrderDao;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {

	@Override
	public Order getOrderByuserIdAndCourseId(int userId, String courseId) {
		String sql = "SELECT * FROM fb_order WHERE user_id = ? AND course_id = ?";
		return this.getBean(sql, userId,courseId);
	}

	@Override
	public int saveOrder(Order order) {
		String sql = "INSERT INTO fb_order(user_id,course_id,course_title,start_time,end_time,lesson_count,price,receiver,province_name,city_name,county_name,address,telephone,pay_way,create_time) " + 
				"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,now());";
		return this.update(sql, order.getUserId(),order.getCourseId(),order.getCourseTitle(),order.getStartTime(),order.getEndTime(),order.getLessonCount(),order.getPrice(),order.getReceiver(),order.getProvinceName(),
				order.getCityName(),order.getCountyName(),order.getAddress(),order.getTelephone(),order.getPayWay());
	}

}
