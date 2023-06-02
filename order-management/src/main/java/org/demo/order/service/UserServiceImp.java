package org.demo.order.service;

import org.demo.order.dao.UserDao;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserServiceImp implements UserService {

	private UserDao userDao;
	
	public UserServiceImp(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean getUserVerified(String uname, String password) {
	
		return userDao.getUserVerified(uname, password);
	}

}
