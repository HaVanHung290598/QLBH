package com.hvh.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
		String hql = "from User where username=:username";
		Query<User> query = session.createQuery(hql, User.class);
		query.setParameter("username", username);
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

	@Override
	public List<User> searchUser(Map<String, String> params, int page, int limit) {
		String hql = "from User where";
		Set<String> keys = params.keySet();
		for(String key : keys) {
			if(params.get(key) != "" && key != "created_at") {
				hql += " "+key+" like '%"+params.get(key)+"%' and";
			}
		}
		if(params.get("created_at") != "") {
			hql += " created_at='"+params.get("created_at")+"' and";
		}
		hql += " 1=1 order by id DESC";
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery(hql, User.class);
		query.setFirstResult((page-1)*limit);
		query.setMaxResults(limit);
		return query.list();
	}

	@Override
	public Boolean getUserByInforUser(String username, String phone, String email) {
		String hql = "from User where username=:username or phone=:phone or email=:email";
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery(hql, User.class);
		query.setParameter("username", username).setParameter("phone", phone).setParameter("email", email);
		if( query.getResultList().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
