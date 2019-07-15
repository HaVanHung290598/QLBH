package com.hvh.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvh.dao.InvoiceDAO;
import com.hvh.dao.UserDAO;
import com.hvh.entity.Invoice;
import com.hvh.model.InvoiceDTO;
import com.hvh.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	InvoiceDAO invoiceDAO;
	@Autowired
	UserDAO userDAO;
	
	@Override
	public void addInvoice(InvoiceDTO invoiceDTO) {
		invoiceDAO.addInvoice(convert(invoiceDTO));
	}

	@Override
	public InvoiceDTO getInvoiceById(int invoice_id) {
		Invoice invoice = invoiceDAO.getInvoiceById(invoice_id);
		return convert(invoice);
	}

	@Override
	public InvoiceDTO getNewInvoice(int limit, int page) {
		Invoice invoice = invoiceDAO.getNewInvoice(limit, page);
		return convert(invoice);
	}
	
	private InvoiceDTO convert(Invoice invoice) {
		InvoiceDTO invoiceDTO = new InvoiceDTO();
		invoiceDTO.setId(invoice.getId());
		invoiceDTO.setUser_id(invoice.getUser().getId());
		invoiceDTO.setDiscount_amount(invoice.getDiscount_amount());
		invoiceDTO.setTax(invoice.getTax());
		invoiceDTO.setTotal_amount(invoice.getTotal_amount());
		invoiceDTO.setStatus(invoice.getStatus());
		invoiceDTO.setDelivery_address(invoice.getDelivery_address());
		invoiceDTO.setDelivery_phone(invoice.getDelivery_phone());
		invoiceDTO.setCreated_at(invoice.getCreated_at());
		return invoiceDTO;
	}
	private Invoice convert(InvoiceDTO invoiceDTO) {
		Invoice invoice = new Invoice();
		invoice.setUser(userDAO.getUserById(invoiceDTO.getUser_id()));
		invoice.setDiscount_amount(invoiceDTO.getDiscount_amount());
		invoice.setTax(invoiceDTO.getTax());
		invoice.setTotal_amount(invoiceDTO.getTotal_amount());
		invoice.setStatus(invoiceDTO.getStatus());
		invoice.setDelivery_address(invoiceDTO.getDelivery_address());
		invoice.setDelivery_phone(invoiceDTO.getDelivery_phone());
		invoice.setCreated_at(invoiceDTO.getCreated_at());
		return invoice;
	}

	@Override
	public List<InvoiceDTO> getListInvoice(int limit, int page) {
		List<Invoice> invoices = invoiceDAO.getListInvoice(limit, page);
		List<InvoiceDTO> invoiceDTOs = new ArrayList<InvoiceDTO>();
		for(Invoice invoice : invoices) {
			invoiceDTOs.add(convert(invoice));
		}
		return invoiceDTOs;
	}

	@Override
	public List<InvoiceDTO> searchInvoice(Map<String, String> params, int page, int limit) {
		List<Invoice> invoices = invoiceDAO.searchInvoice(params, page, limit);
		List<InvoiceDTO> invoiceDTOs = new ArrayList<InvoiceDTO>();
		for(Invoice invoice : invoices) {
			invoiceDTOs.add(convert(invoice));
		}
		return invoiceDTOs;
	}
}
