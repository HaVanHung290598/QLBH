package com.hvh.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hvh.model.ProductDTO;
import com.hvh.service.ProductService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	long millis = System.currentTimeMillis();
	java.util.Date created_at = new java.util.Date(millis);
	java.util.Date updated_at = new java.util.Date(millis);
	
	@Autowired
	ProductService productService;

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String getProduct(Model model, HttpServletRequest req) {
		int pages = req.getParameter("pages") == null ? 1 : Integer.parseInt(req.getParameter("pages"));
		int limit = req.getParameter("limit") == null ? 8 : Integer.parseInt(req.getParameter("limit"));
		List<ProductDTO> productDTOs = productService.getListProduct(pages, limit);
		model.addAttribute("productDTOs", productDTOs);
		model.addAttribute("pages", pages);
		model.addAttribute("size", productService.getListProduct(1, 10000).size());
		return "homeAdmin";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
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

	@RequestMapping(value = "/searchProduct", method = RequestMethod.GET)
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

	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String addProduct(Model model) {
		model.addAttribute("product", new ProductDTO());
		model.addAttribute("url", "addProduct");
		model.addAttribute("header", "Create Product");
		return "productAdmin";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(Model model, HttpServletRequest req, @RequestParam(name="file") MultipartFile file) {
		String productName = req.getParameter("product_name");
		int price = Integer.parseInt(req.getParameter("unit_price"));
		String description = req.getParameter("description");
		int quantity = Integer.parseInt(req.getParameter("quantity_available"));
		ProductDTO product = new ProductDTO();
		product.setProduct_name(productName);
		product.setUnit_price(price);
		product.setDescription(description);
		product.setImage(file.getOriginalFilename());
		product.setQuantity_available(quantity);
		product.setCreated_at(created_at);
		File files  = new File("D:\\java\\QLBH\\src\\main\\webapp\\resources\\images", file.getOriginalFilename());
	    try {
			file.transferTo(files);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		productService.addProduct(product);
		return "redirect:/admin/product";
	}

	@RequestMapping(value = "/repairProduct", method = RequestMethod.GET)
	public String repairProduct(Model model, HttpServletRequest req) {
		int productId = Integer.parseInt(req.getParameter("id"));
		ProductDTO product = productService.getProductById(productId);
		model.addAttribute("product", product);
		model.addAttribute("url", "repairProduct");
		model.addAttribute("header", "Repair Product");
		return "productAdmin";
	}

	@RequestMapping(value = "repairProduct", method = RequestMethod.POST)
	public String repairProduct(Model model, HttpServletRequest req, @RequestParam(name="file", required = false) MultipartFile file) {
		int productId = Integer.parseInt(req.getParameter("id"));
		String productName = req.getParameter("product_name");
		int price = Integer.parseInt(req.getParameter("unit_price"));
		String description = req.getParameter("description");
		int quantity = Integer.parseInt(req.getParameter("quantity_available"));
		ProductDTO product = new ProductDTO();
		product.setId(productId);
		product.setProduct_name(productName);
		product.setUnit_price(price);
		product.setDescription(description);
		product.setImage(file.getOriginalFilename());
		product.setQuantity_available(quantity);
		product.setCreated_at(productService.getProductById(productId).getCreated_at());
		product.setUpdated_at(updated_at);
		productService.updateProduct(product);
		return "redirect:/admin/product";
	}
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//		sdf.setLenient(true);
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
//	}
}
