package com.hvh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvh.dao.InvoiceItemAttributeDAO;
import com.hvh.dao.InvoiceItemDAO;
import com.hvh.entity.InvoiceItemAttribute;
import com.hvh.model.InvoiceItemAttributeDTO;
import com.hvh.service.InvoiceItemAttributeService;

@Service
public class InvoiceItemAttributeServiceImpl implements InvoiceItemAttributeService {

	@Autowired
	InvoiceItemAttributeDAO invoiceItemAttributeDAO;
	@Autowired
	InvoiceItemDAO invoiceItemDAO;
	
	@Override
	public void addInvoiceItemAttribute(InvoiceItemAttributeDTO invoiceItemAttributeDTO) {
		InvoiceItemAttribute invoiceItemAttribute = new InvoiceItemAttribute();
		invoiceItemAttribute.setInvoiceItem(invoiceItemDAO.getInvoiceItemById(invoiceItemAttributeDTO.getInvoice_item_id()));
		invoiceItemAttribute.setAttribute(invoiceItemAttributeDTO.getAttribute());
		invoiceItemAttribute.setValue(invoiceItemAttributeDTO.getValue());
		invoiceItemAttributeDAO.addInvoiceItemAttribute(invoiceItemAttribute);
	}

}
