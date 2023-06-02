package org.demo.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.demo.order.model.OrderManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("orderDao")
public class OrderDaoImp implements OrderDao {

	private final DataSource dataSource;

	@Autowired
	public OrderDaoImp(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public OrderManagement createOrder(OrderManagement order) {

		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into order(order_id,order_name,order_price) values(?,?,?)");
			preparedStatement.setInt(1, order.getOrderId());
			preparedStatement.setString(2, order.getOrderName());
			preparedStatement.setString(3, order.getOrderPrice());
			preparedStatement.executeUpdate();
			System.out.println("Inserted Successfully.......");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public List<OrderManagement> getAllOrders() {
		List<OrderManagement> list = new ArrayList<OrderManagement>();
		try {
			Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			ResultSet re=statement.executeQuery("select * from order");
			//ResultSet result = statement.executeQuery("select * from order");
			System.out.println("Result "+ re);
			while ( re.next()) {
				list.add(new OrderManagement( re.getInt(1),  re.getString(2),  re.getString(3)));
			}

		} catch (Exception e) {
			e.getStackTrace();
		}

		return list;
	}

//	@Override
//	public List<Customer> getCustomerById(int i) {
//		List<Customer> list = new ArrayList<Customer>();
//		try {
//			Connection connection = dataSource.getConnection();
//			PreparedStatement result = connection.prepareStatement("SELECT * FROM customer where customer_id=?");
//			result.setInt(1, i);
//			ResultSet resultList=result.executeQuery();
//			while (resultList.next()) {
//				list.add(new Customer(resultList.getInt(1), resultList.getString(2), resultList.getString(3)));
//			}
//
//		} catch (Exception e) {
//			e.getStackTrace();
//		}
//		return list;
//		
//	}
//
//	@Override
//	public void deleteCustomerById(int i) {
//		try {
//			Connection connection = dataSource.getConnection();
//			PreparedStatement preparedStatement = connection
//					.prepareStatement("delete from customer where customer_id=?");
//			preparedStatement.setInt(1, i);
//			preparedStatement.execute();
//			System.out.println("Customer Deleted Successfully....");
//		}catch (Exception e) {
//			e.getStackTrace();
//		}
//		
//	}
//
//	@Override
//	public void updateCustomer(int id, String fname, String lname) {
//		
//		try {
//			Connection connection = dataSource.getConnection();
//			PreparedStatement preparedStatement = connection
//					.prepareStatement("update customer set first_name=?,last_name=? where customer_id=?");
//			preparedStatement.setString(1, fname);
//			preparedStatement.setString(2, lname);
//			preparedStatement.setInt(3, id);
//			preparedStatement.executeUpdate();
//			System.out.println("Customer Updated Successfully....");
//		}catch (Exception e) {
//			e.getStackTrace();
//		}
//	}

}
