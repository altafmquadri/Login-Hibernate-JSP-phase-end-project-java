package com.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import com.dao.UserDAO;
import com.dao.UserDAOImpl;
import com.model.User;

public class UserServiceImpl implements UserService {
	private UserDAO userDao = new UserDAOImpl();

	@Override
	public boolean login(String name, String password) {
		AtomicBoolean isCorrect = new AtomicBoolean(false);

		userDao.findAll();
		List<User> userList = userDao.findAll();
		userList.forEach(user -> {
			if (user.getName().equalsIgnoreCase(name) && user.getPassword().equals(password)) {
				isCorrect.set(true);
			}
		});

		return isCorrect.get();
	}

}
