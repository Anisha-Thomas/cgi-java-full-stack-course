package org.demo.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.demo.order.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userDao")
public class UserDaoImp implements UserDao {

	private final DataSource dataSource;
	@Autowired
	public UserDaoImp(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public User getUserVerified(String uname, String password) {

		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement result = connection.prepareStatement("SELECT * FROM user where username=? and password=?");
			result.setString(1, uname);
			result.setString(2, password);
			User userdetails=(User) result.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}
		User userdetails = null;
		return userdetails;
	}

}
