package org.demo.order.service;

import org.demo.order.model.User;

public interface UserService {

	public User getUserVerified(String uname, String password);
}
