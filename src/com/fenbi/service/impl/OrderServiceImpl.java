package com.fenbi.service.impl;

import com.fenbi.bean.Order;
import com.fenbi.dao.OrderDao;
import com.fenbi.dao.impl.OrderDaoImpl;
import com.fenbi.service.OrderService;

public class OrderServiceImpl implements OrderService {

	@Override
	public int saveOrder(Order order) {
		OrderDao dao = new OrderDaoImpl();
		return dao.saveOrder(order);
	}

}
