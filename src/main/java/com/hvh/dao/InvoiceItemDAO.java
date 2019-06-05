package com.hvh.dao;

import java.util.List;

import com.hvh.entity.InvoiceItem;

public interface InvoiceItemDAO {
	public void addInvoiceItem(InvoiceItem invoiceItem);
	public List<InvoiceItem>  getInvoiceItemByInvoiceId(int invoice_id);
}
