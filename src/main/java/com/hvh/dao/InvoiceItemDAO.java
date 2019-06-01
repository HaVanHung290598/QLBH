package com.hvh.dao;

import com.hvh.entity.InvoiceItem;

public interface InvoiceItemDAO {
	public void addInvoiceItem(InvoiceItem invoiceItem);
	public InvoiceItem  getInvoiceItemById(int invoice_item_id);
}
