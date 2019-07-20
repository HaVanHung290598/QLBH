package com.hvh.dao.impl;

import java.util.List;

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
	@Override
	public List<User> getListUser(int page, int limit) {
		String hql = "from User order by id DESC";
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery(hql, User.class);
		query.setFirstResult((page-1)*limit);
		query.setMaxResults(limit);
		return query.list();
	}

	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().merge(user);
	}

	@Override
	public List<User> searchUser(String username, int page, int limit) {
		String hql = "from User where username like '%"+username+"%'";
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery(hql, User.class);
		query.setFirstResult((page-1)*limit);
		query.setMaxResults(limit);
		return query.list();
	}

	@Override
	public void deleteUser(int id) {
		sessionFactory.getCurrentSession().delete(getUserById(id));
	}
}
