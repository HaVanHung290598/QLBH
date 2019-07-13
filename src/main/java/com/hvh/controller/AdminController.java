package com.hvh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		List<ProductDTO> productDTOs = productService.searchProduct(params, pages, limit);
		model.addAttribute("productDTOs", productDTOs);
		model.addAttribute("pages", pages);
		model.addAttribute("size", productService.searchProduct(params, 1, 10000).size());
		model.addAttribute("product_name", params.get("product_name"));
		return "homeAdmin";
	}
	@RequestMapping(value="/searchProduct", method = RequestMethod.GET)
	public String searchProduct(Model model, HttpServletRequest req) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("created_at", req.getParameter("created_at") == null ? "" : req.getParameter("created_at"));
		params.put("updated_at", req.getParameter("updated_at") == null ? "" : req.getParameter("updated_at"));
		params.put("sortPrice", req.getParameter("sortPrice") == null ? "" : req.getParameter("sortPrice"));
		params.put("sortQuantity", req.getParameter("sortQuantity") == null ? "" : req.getParameter("sortQuantity"));
		int pages = req.getParameter("pages") == null ? 1 : Integer.parseInt(req.getParameter("pages"));
		int limit = req.getParameter("limit") == null ? 8 : Integer.parseInt(req.getParameter("limit"));
		List<ProductDTO> productDTOs = productService.searchProductAdmin(params, pages, limit);
		model.addAttribute("productDTOs", productDTOs);
		model.addAttribute("pages", pages);
		model.addAttribute("size", productService.searchProductAdmin(params, 1, 10000).size());
		model.addAttribute("params", params);
		return "homeAdmin";
	}
	@RequestMapping(value="/addProduct", method = RequestMethod.GET)
	public String addProduct(Model model) {
		model.addAttribute("product", new ProductDTO());
		model.addAttribute("url", "addProduct");
		return "productAdmin";
	}
	@RequestMapping(value="/addProduct", method = RequestMethod.POST)
	public String addProduct(Model model, @ModelAttribute(name="product") ProductDTO product) {
		System.out.println("hello.........");
//		productService.addProduct(product);
		return "redirect:/admin/product";
	}
	@RequestMapping(value="/repairProduct", method = RequestMethod.GET)
	public String repairProduct(Model model) {
		model.addAttribute("product", new ProductDTO());
		model.addAttribute("url", "repairProduct");
		return "productAdmin";
	}
	@RequestMapping(value="repairProduct", method = RequestMethod.POST)
	public String repairProduct(Model model, @ModelAttribute(name="product") ProductDTO product) {
		productService.updateProduct(product);
		return "productAdmin";
	}
}
