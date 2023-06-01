package org.demo.order.service;

import org.demo.order.dao.UserDao;
import org.demo.order.model.User;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserServiceImp implements UserService {

	private UserDao userDao = null;
	@Override
	public User getUserVerified(String uname, String password) {
		
		return userDao.getUserVerified(uname,password);
	}

}
