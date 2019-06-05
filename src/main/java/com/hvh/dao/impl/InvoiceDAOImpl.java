package com.hvh.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hvh.dao.InvoiceDAO;
import com.hvh.entity.Invoice;

@Repository
@Transactional
public class InvoiceDAOImpl implements InvoiceDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addInvoice(Invoice invoice) {
		sessionFactory.getCurrentSession().save(invoice);		
	}

	@Override
	public Invoice getInvoiceById(int invoice_id) {
		return sessionFactory.getCurrentSession().get(Invoice.class, invoice_id);
	}

	@Override
	public Invoice getNewInvoice() {
		String hql = "From Invoice order by id DESC";
		Session session = sessionFactory.getCurrentSession();
		Query<Invoice> query = session.createQuery(hql, Invoice.class);
		query.setFirstResult(0);
		query.setMaxResults(1);
		return query.getSingleResult();
	}
}
