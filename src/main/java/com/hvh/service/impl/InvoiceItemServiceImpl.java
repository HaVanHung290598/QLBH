package com.hvh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvh.dao.InvoiceDAO;
import com.hvh.dao.InvoiceItemDAO;
import com.hvh.dao.ProductDAO;
import com.hvh.entity.InvoiceItem;
import com.hvh.entity.InvoiceItem.PkInvoiceItem;
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
		PkInvoiceItem pk = new PkInvoiceItem();
		pk.setInvoice(invoiceDAO.getInvoiceById(invoiceItemDTO.getInvoice_id()));
		pk.setProduct(productDAO.getProductById(invoiceItemDTO.getProduct_id()));
		invoiceItem.setPk(pk);
		invoiceItem.setQuantity(invoiceItemDTO.getQuantity());
		invoiceItem.setSize(invoiceItemDTO.getSize());
		invoiceItem.setColor(invoiceItemDTO.getColor());
		invoiceItem.setPrice(invoiceItemDTO.getPrice());
		invoiceItem.setDiscount_amount(invoiceItemDTO.getDiscount_amount());
		invoiceItem.setCreated_at(invoiceItemDTO.getCreated_at());
		invoiceItemDAO.addInvoiceItem(invoiceItem);
	}

	@Override
	public List<InvoiceItemDTO> getInvoiceItemByInvoiceId(int invoice_id) {
		List<InvoiceItemDTO> invoiceItemDTOs = new ArrayList<InvoiceItemDTO>();
		List<InvoiceItem> invoiceItems = invoiceItemDAO.getInvoiceItemByInvoiceId(invoice_id);
		for(InvoiceItem invoiceItem : invoiceItems) {
			InvoiceItemDTO invoiceItemDTO = new InvoiceItemDTO();
			invoiceItemDTO.setInvoice_id(invoiceItem.getPk().getInvoice().getId());
			invoiceItemDTO.setProduct_id(invoiceItem.getPk().getProduct().getId());
			invoiceItemDTO.setQuantity(invoiceItem.getQuantity());
			invoiceItemDTO.setSize(invoiceItem.getSize());
			invoiceItemDTO.setColor(invoiceItem.getColor());
			invoiceItemDTO.setPrice(invoiceItem.getPrice());
			invoiceItemDTO.setDiscount_amount(invoiceItem.getDiscount_amount());
			invoiceItemDTO.setCreated_at(invoiceItem.getCreated_at());
			invoiceItemDTOs.add(invoiceItemDTO);
		}
		return invoiceItemDTOs;
	}

}
