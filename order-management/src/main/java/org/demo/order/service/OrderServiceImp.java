package org.demo.order.service;

import java.util.List;

import org.demo.order.dao.OrderDao;
import org.demo.order.model.OrderManagement;
import org.springframework.stereotype.Component;

@Component("orderService")
public class OrderServiceImp implements OrderService {
	
	public OrderDao orderDao;

	public OrderServiceImp(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	public OrderManagement createOrder(OrderManagement order) {
		return orderDao.createOrder(order);
	}
	public List<OrderManagement> getAllOrders() {
		return orderDao.getAllOrders();
	}

}
