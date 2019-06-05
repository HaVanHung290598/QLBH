package com.hvh.dao;

import com.hvh.entity.Invoice;

public interface InvoiceDAO {
	public void addInvoice(Invoice invoice);
	public Invoice getNewInvoice();
	public Invoice getInvoiceById(int invoice_id);
}
