package org.demo.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

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
	public boolean getUserVerified(String uname, String password) {
		boolean userexist = false;
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement result = connection.prepareStatement("SELECT * FROM user where username=? and password=?");
			result.setString(1, uname);
			result.setString(2, password);
			ResultSet userdetails=result.executeQuery();
			if(userdetails.next()) {
				userexist=true;
			}else {
				userexist=false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userexist;
	}

}
