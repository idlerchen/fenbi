package com.fenbi.dao;

import com.fenbi.bean.Order;

public interface OrderDao {
	
	Order getOrderByuserIdAndCourseId(int userId,String courseId);
	
	int saveOrder(Order order);

}
