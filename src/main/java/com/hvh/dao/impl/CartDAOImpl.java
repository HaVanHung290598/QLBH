package com.hvh.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hvh.dao.CartDAO;
import com.hvh.entity.Cart;

@Repository
@Transactional
public class CartDAOImpl implements CartDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addCart(Cart cart) {
		sessionFactory.getCurrentSession().save(cart);		
	}

	@Override
	public List<Cart> getListCartByUser(int user_id) {
		String hql = "From Cart where user_id = :user_id";
		Session session = sessionFactory.getCurrentSession();
		Query<Cart> query = session.createQuery(hql, Cart.class);
		query.setParameter("user_id", user_id);
		List<Cart> result = query.list();
		return result;
	}

}
