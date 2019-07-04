package com.hvh.dao.impl;

import java.util.List;

import javax.transaction.Transactional;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hvh.dao.ProductAttributeDAO;
import com.hvh.entity.ProductAttribute;

@Repository
@Transactional
public class ProductAttributeDAOImpl implements ProductAttributeDAO {
	
	@Autowired
	org.hibernate.SessionFactory SessionFactory;

	@Override
	public ProductAttribute getProductAttributeById(int id) {
		return SessionFactory.getCurrentSession().get(ProductAttribute.class, id);
	}

	@Override
	public List<ProductAttribute> getListProductAttributeByProduct(int product_id) {
		String hql = "From ProductAttribute where product_id = :product_id";
		Session session = SessionFactory.getCurrentSession();
		Query<ProductAttribute> query = session.createQuery(hql, ProductAttribute.class);
		query.setParameter("product_id", product_id);
		List<ProductAttribute> result = query.list();
		return result;
	}
}
