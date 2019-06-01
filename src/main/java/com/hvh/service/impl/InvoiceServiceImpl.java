package com.hvh.service.impl;

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
		Invoice invoice = new Invoice();
		invoice.setUser(userDAO.getUserById(invoiceDTO.getUser_id()));
		invoice.setDiscount_amount(invoiceDTO.getDiscount_amount());
		invoice.setTax(invoiceDTO.getTax());
		invoice.setTotal_amount(invoiceDTO.getTotal_amount());
		invoice.setStatus(invoiceDTO.getStatus());
		invoice.setDelivery_address(invoiceDTO.getDelivery_address());
		invoice.setDelivery_phone(invoiceDTO.getDelivery_phone());
		invoice.setCreated_at(invoiceDTO.getCreated_at());
		invoiceDAO.addInvoice(invoice);
	}

	@Override
	public InvoiceDTO getInvoiceById(int invoice_id) {
		Invoice invoice = invoiceDAO.getInvoiceById(invoice_id);
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

}
