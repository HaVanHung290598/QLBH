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
	public Invoice getNewInvoice(int limit, int page) {
		String hql = "From Invoice order by id DESC";
		Session session = sessionFactory.getCurrentSession();
		Query<Invoice> query = session.createQuery(hql, Invoice.class);
		query.setFirstResult((page-1)*limit);
		query.setMaxResults(limit);
		return query.getSingleResult();
	}
	public List<Invoice> getListInvoice(int limit, int page) {
		String hql = "From Invoice order by id DESC";
		Session session = sessionFactory.getCurrentSession();
		Query<Invoice> query = session.createQuery(hql, Invoice.class);
		query.setFirstResult((page-1)*limit);
		query.setMaxResults(limit);
		return query.list();
	}
	
	public List<Invoice> searchInvoice(Map<String, String> params, int page, int limit) {
		String hql = "from Invoice where";
		Set<String> keys = params.keySet();
		for(String key : keys) {
			if(params.get(key) != "" && key != "status") {
				hql += " "+key+"(created_at)="+params.get(key)+" and";
			}
		}
		if(params.get("status") != "") {
			hql += " status='"+params.get("status")+"' and";
		}
		hql += " 1=1 order by created_at DESC";
		Session session = sessionFactory.getCurrentSession();
		Query<Invoice> query = session.createQuery(hql, Invoice.class);
		query.setFirstResult((page-1)*limit);
		query.setMaxResults(limit);
		return query.list();
	}

	@Override
	public void updateStatusInvoiceById(int id, String status) {
		String hql = "update from Invoice set status=:status where id=:id";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter("status", status);
		query.setParameter("id", id);
		query.executeUpdate();
	}
}
