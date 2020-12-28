package com.dao;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.User;
import com.util.HibernateUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public List<User> findAll() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session sess = sessionFactory.openSession();
		List<User> userList = sess.createQuery("from User").list();
		return userList;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertUser(User user) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session sess = sessionFactory.openSession();
		Transaction transaction = sess.beginTransaction();

		sess.save(user);
		transaction.commit();
	}

	@Override
	public void updateUser(User user) {
		
	}

	@Override
	public void deleteUser(User user) {

	}

}
