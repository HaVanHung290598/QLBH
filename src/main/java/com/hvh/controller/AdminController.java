package com.hvh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hvh.model.ProductDTO;
import com.hvh.service.ProductService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/product", method = RequestMethod.GET)
	public String getProduct(Model model, HttpServletRequest req) {
		int pages = req.getParameter("pages") == null ? 1 : Integer.parseInt(req.getParameter("pages"));
		int limit = req.getParameter("limit") == null ? 8 : Integer.parseInt(req.getParameter("limit"));
		List<ProductDTO> productDTOs = productService.getListProduct(pages, limit);
		model.addAttribute("productDTOs", productDTOs);
		model.addAttribute("pages", pages);
		model.addAttribute("size", productService.getListProduct(1, 10000).size());
		return "homeAdmin";
	}
	
	@RequestMapping(value="/search", method = RequestMethod.GET)
	public String getProductByName(Model model, HttpServletRequest req) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("product_name", req.getParameter("productName") != null ? req.getParameter("productName") : "");
		params.put("price_from", req.getParameter("price_from") != null ? req.getParameter("price_from") : "");
		params.put("price_to", req.getParameter("price_to") != null ? req.getParameter("price_to") : "");
		int pages = req.getParameter("pages") == null ? 1 : Integer.parseInt(req.getParameter("pages"));
		int limit = req.getParameter("limit") == null ? 8 : Integer.parseInt(req.getParameter("limit"));
		System.out.println("thuc hien hibernate search...............");
		List<ProductDTO> productDTOs = productService.searchProduct(params, pages, limit);
		System.out.println("co sp nao ko????????");
		for(ProductDTO productDTO : productDTOs) {
			System.out.println(productDTO.getProduct_name());
		}
		model.addAttribute("productDTOs", productDTOs);
		model.addAttribute("pages", pages);
		model.addAttribute("size", productService.searchProduct(params, 1, 10000).size());
		model.addAttribute("product_name", params.get("product_name"));
		return "homeAdmin";
	}
}
