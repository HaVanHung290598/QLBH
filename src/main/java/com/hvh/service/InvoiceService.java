package com.hvh.service;

import com.hvh.model.InvoiceDTO;

public interface InvoiceService {
	public void addInvoice(InvoiceDTO invoiceDTO);
	public InvoiceDTO getInvoiceById(int invoice_id);
}
