package com.hvh.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hvh.dao.ProductDAO;
import com.hvh.entity.Product;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addProduct(Product product) {
		sessionFactory.getCurrentSession().save(product);		
	}

	@Override
	public void updateProduct(Product product) {
		sessionFactory.getCurrentSession().merge(product);		
	}

	@Override
	public void deleteProduct(int id) {
		sessionFactory.getCurrentSession().delete(getProductById(id));		
	}

	@Override
	public Product getProductById(int id) {
		return sessionFactory.getCurrentSession().get(Product.class, id);
	}

	@Override
	public List<Product> getListProduct(int page, int limit) {
		String hql = "From Product";
		org.hibernate.Session session = (org.hibernate.Session) sessionFactory.getCurrentSession();
		Query<Product> query = session.createQuery(hql, Product.class);
		query.setFirstResult((page-1)*limit);
		query.setMaxResults(limit);
		return query.list();
//		return sessionFactory.getCurrentSession().createQuery("From product", Product.class).getResultList();
	}
}
