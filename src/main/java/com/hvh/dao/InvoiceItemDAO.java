package com.hvh.dao;

import java.util.List;

import com.hvh.entity.InvoiceItem;
import com.hvh.entity.InvoiceItem.PkInvoiceItem;

public interface InvoiceItemDAO {
	public void addInvoiceItem(InvoiceItem invoiceItem);
	public void deleteInvoiceItemByInvoiceId(int invoiceId);
	public List<InvoiceItem>  getInvoiceItemByInvoiceId(int invoice_id);
	public List<PkInvoiceItem> getTop5Product();
}
