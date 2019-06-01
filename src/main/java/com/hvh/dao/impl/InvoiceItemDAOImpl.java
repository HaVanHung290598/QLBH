package com.hvh.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hvh.dao.InvoiceItemDAO;
import com.hvh.entity.InvoiceItem;

@Repository
@Transactional
public class InvoiceItemDAOImpl implements InvoiceItemDAO {

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void addInvoiceItem(InvoiceItem invoiceItem) {
		sessionFactory.getCurrentSession().save(invoiceItem);
	}
	@Override
	public InvoiceItem getInvoiceItemById(int invoice_item_id) {
		return sessionFactory.getCurrentSession().get(InvoiceItem.class, invoice_item_id);
	}

}
