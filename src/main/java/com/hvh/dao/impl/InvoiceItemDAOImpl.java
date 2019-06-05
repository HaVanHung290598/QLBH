package com.hvh.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
	public List<InvoiceItem> getInvoiceItemByInvoiceId(int invoice_id) {
		String hql = "From InvoiceItem where invoice_id = : invoice_id";
		Session session = sessionFactory.getCurrentSession();
		Query<InvoiceItem> query = session.createQuery(hql, InvoiceItem.class);
		query.setParameter("invoice_id", invoice_id);
		List<InvoiceItem> invoiceItems = query.list();
		return invoiceItems;
	}

}
