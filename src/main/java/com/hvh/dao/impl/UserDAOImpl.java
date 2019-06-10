package com.hvh.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hvh.dao.UserDAO;
import com.hvh.entity.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public User getUserById(int user_id) {
		return sessionFactory.getCurrentSession().get(User.class, user_id);
	}

	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public User getUserByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from User where username = :username";
		Query<User> query = session.createQuery(hql, User.class);
		query.setParameter("username", username);
		query.setFirstResult(0);
		query.setMaxResults(1);
		return query.getSingleResult();
	}

}
