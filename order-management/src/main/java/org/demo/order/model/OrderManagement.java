package org.demo.order.model;

public class OrderManagement {

	public int orderId;
	public String orderName;
	public String orderPrice;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}
	public OrderManagement(int orderId, String orderName, String orderPrice) {
		this.orderId = orderId;
		this.orderName = orderName;
		this.orderPrice = orderPrice;
	}
	public OrderManagement() {
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + ", orderPrice=" + orderPrice + "]";
	}
	
}
