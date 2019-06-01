package com.hvh.service;

import com.hvh.model.InvoiceItemDTO;

public interface InvoiceItemService {
	public void addInvoiceItem(InvoiceItemDTO invoiceItemDTO);
	public InvoiceItemDTO getInvoiceItemById(int invoice_item_id);
}
