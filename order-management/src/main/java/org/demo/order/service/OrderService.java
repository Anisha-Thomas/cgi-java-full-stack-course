package org.demo.order.service;

import java.util.List;

import org.demo.order.model.OrderManagement;

public interface OrderService {
	public OrderManagement createOrder(OrderManagement order);

	public List<OrderManagement> getAllOrders();
}
