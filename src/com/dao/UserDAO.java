package com.dao;

import java.util.List;

import org.hibernate.Session;

import com.model.User;

public interface UserDAO {
	
	public List<User> findAll();
	
	public User findById(int id);
	
	public void insertUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(User user);

}
