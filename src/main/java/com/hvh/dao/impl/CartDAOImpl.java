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
import com.hvh.entity.Cart.Pk;

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
	public void deleteCart(Pk pk) {
		sessionFactory.getCurrentSession().delete(getCartById(pk));
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
	@Override
	public Cart getCartById(Pk pk) {
		return sessionFactory.getCurrentSession().get(Cart.class, pk);
	}
	@Override
	public void deleteCartByUserId(int user_id) {
		List<Cart> carts = getListCartByUser(user_id);
		for(Cart cart : carts) {
			sessionFactory.getCurrentSession().delete(cart);
		}
	}
	@Override
	public void updateCart(Cart cart) {
		sessionFactory.getCurrentSession().merge(cart);
	}
}
