package org.demo.order.dao;

import java.util.List;

import org.demo.order.model.OrderManagement;

public interface OrderDao {

	public OrderManagement createOrder(OrderManagement order);

	public List<OrderManagement> getAllOrders();

}
