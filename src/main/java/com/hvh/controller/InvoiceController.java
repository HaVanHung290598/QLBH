package com.hvh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hvh.model.CartDTO;
import com.hvh.model.InvoiceDTO;
import com.hvh.model.InvoiceItemDTO;
import com.hvh.model.SettingDTO;
import com.hvh.service.CartService;
import com.hvh.service.InvoiceItemService;
import com.hvh.service.InvoiceService;
import com.hvh.service.ProductService;
import com.hvh.service.SettingService;

@Controller
public class InvoiceController {
	long millis = System.currentTimeMillis();
	java.util.Date created_at = new java.util.Date(millis);
	java.util.Date updated_at = new java.util.Date(millis);
	
	@Autowired
	InvoiceService invoiceService;
	@Autowired
	CartService cartService;
	@Autowired
	ProductService productService;
	@Autowired
	InvoiceItemService invoiceItemService;
	@Autowired
	SettingService settingService;
	
	
	@RequestMapping(value="/invoice", method = RequestMethod.POST)
	public String invoice(Model model, HttpServletRequest req, HttpServletResponse resp) {
		int userId = Integer.parseInt(req.getParameter("userId"));
		SettingDTO settingDTO = settingService.getSettingById(1);
		int discountAmount = settingDTO.getDiscount_amount();
		int tax = settingDTO.getTax();
		int total = Integer.parseInt(req.getParameter("total"));
		String status = "pending";
		String deliveryAddress = req.getParameter("delivery-address");
		String deliveryPhone = req.getParameter("delivery-phone");
		InvoiceDTO invoiceDTO = new InvoiceDTO();
		invoiceDTO.setUser_id(userId);
		invoiceDTO.setDiscount_amount(discountAmount);
		invoiceDTO.setTax(tax);
		invoiceDTO.setTotal_amount(total);
		invoiceDTO.setStatus(status);
		invoiceDTO.setDelivery_address(deliveryAddress);
		invoiceDTO.setDelivery_phone(deliveryPhone);
		invoiceDTO.setCreated_at(created_at);
		invoiceService.addInvoice(invoiceDTO);
		List<CartDTO> cartDTOs = cartService.getListCartByUser(invoiceService.getNewInvoice(1,1).getUser_id());
		for(CartDTO cartDTO : cartDTOs) {
			InvoiceItemDTO invoiceItemDTO = new InvoiceItemDTO();
			invoiceItemDTO.setInvoice_id(invoiceService.getNewInvoice(1,1).getId());
			int productId = cartDTO.getProduct_id();
			invoiceItemDTO.setProduct_id(productId);
			invoiceItemDTO.setQuantity(cartDTO.getQuantity());
			invoiceItemDTO.setSize(cartDTO.getSize());
			invoiceItemDTO.setColor(cartDTO.getColor());
			invoiceItemDTO.setPrice(productService.getProductById(cartDTO.getProduct_id()).getUnit_price());
			invoiceItemDTO.setCreated_at(created_at);
			invoiceItemService.addInvoiceItem(invoiceItemDTO);
			productService.updateQuantityProduct(productId, productService.getProductById(productId).getQuantity_available() - cartDTO.getQuantity());
		}
		cartService.deleteCartByUserId(userId);
		return "redirect:/cart";
	}
}
