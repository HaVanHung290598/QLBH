package com.hvh.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
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

}
