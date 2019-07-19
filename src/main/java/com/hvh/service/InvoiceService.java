package com.hvh.service;

import java.util.List;
import java.util.Map;

import com.hvh.model.InvoiceDTO;

public interface InvoiceService {
	public void addInvoice(InvoiceDTO invoiceDTO);
	public InvoiceDTO getNewInvoice(int limit, int page);
	public InvoiceDTO getInvoiceById(int invoice_id);
	public List<InvoiceDTO> getListInvoice(int limit, int page);
	public List<InvoiceDTO> searchInvoice(Map<String, String> params, int page, int limit);
	public void updateStatusInvoiceById(int id, String status);
}
