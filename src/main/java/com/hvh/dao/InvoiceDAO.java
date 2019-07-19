package com.hvh.dao;

import java.util.List;
import java.util.Map;

import com.hvh.entity.Invoice;

public interface InvoiceDAO {
	public void addInvoice(Invoice invoice);
	public Invoice getNewInvoice(int limit, int page);
	public Invoice getInvoiceById(int invoice_id);
	public List<Invoice> getListInvoice(int limit, int page);
	public List<Invoice> searchInvoice(Map<String, String> params, int page, int limit);
	public void updateStatusInvoiceById(int id, String status);
}
