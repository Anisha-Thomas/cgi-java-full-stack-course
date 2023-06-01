package org.demo.order.dao;

import org.demo.order.model.User;

public interface UserDao {

	User getUserVerified(String uname, String password);

}
