package com.hvh.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hvh.dao.InvoiceItemAttributeDAO;
import com.hvh.entity.InvoiceItemAttribute;

@Repository
@Transactional
public class InvoiceItemAttributeDAOImpl implements InvoiceItemAttributeDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addInvoiceItemAttribute(InvoiceItemAttribute invoiceItemAttribute) {
		sessionFactory.getCurrentSession().save(invoiceItemAttribute);
	}

}
