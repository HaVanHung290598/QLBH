package com.hvh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvh.dao.InvoiceDAO;
import com.hvh.dao.InvoiceItemDAO;
import com.hvh.dao.ProductDAO;
import com.hvh.entity.InvoiceItem;
import com.hvh.model.InvoiceItemDTO;
import com.hvh.service.InvoiceItemService;

@Service
public class InvoiceItemServiceImpl implements InvoiceItemService {

	@Autowired
	InvoiceDAO invoiceDAO;
	@Autowired
	InvoiceItemDAO invoiceItemDAO;
	@Autowired
	ProductDAO productDAO;
	
	@Override
	public void addInvoiceItem(InvoiceItemDTO invoiceItemDTO) {
		InvoiceItem invoiceItem = new InvoiceItem();
		invoiceItem.setInvoice(invoiceDAO.getInvoiceById(invoiceItemDTO.getInvoice_id()));
		invoiceItem.setProduct(productDAO.getProductById(invoiceItemDTO.getProduct_id()));
		invoiceItem.setQuantity(invoiceItemDTO.getQuantity());
		invoiceItem.setPrice(invoiceItemDTO.getPrice());
		invoiceItem.setDiscount_amount(invoiceItemDTO.getDiscount_amount());
		invoiceItem.setCreated_at(invoiceItemDTO.getCreated_at());
		invoiceItemDAO.addInvoiceItem(invoiceItem);
	}

	@Override
	public InvoiceItemDTO getInvoiceItemById(int invoice_item_id) {
		InvoiceItem invoiceItem = invoiceItemDAO.getInvoiceItemById(invoice_item_id);
		InvoiceItemDTO invoiceItemDTO = new InvoiceItemDTO();
		invoiceItemDTO.setId(invoiceItem.getId());
		invoiceItemDTO.setInvoice_id(invoiceItem.getInvoice().getId());
		invoiceItemDTO.setProduct_id(invoiceItem.getProduct().getId());
		invoiceItemDTO.setQuantity(invoiceItem.getQuantity());
		invoiceItemDTO.setPrice(invoiceItem.getPrice());
		invoiceItemDTO.setDiscount_amount(invoiceItem.getDiscount_amount());
		invoiceItemDTO.setCreated_at(invoiceItem.getCreated_at());
		return invoiceItemDTO;
	}

}
