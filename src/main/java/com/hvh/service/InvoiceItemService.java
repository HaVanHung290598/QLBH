package com.hvh.service;

import java.util.List;

import com.hvh.model.InvoiceItemDTO;

public interface InvoiceItemService {
	public void addInvoiceItem(InvoiceItemDTO invoiceItemDTO);
	public List<InvoiceItemDTO> getInvoiceItemByInvoiceId(int invoice_id);
}
