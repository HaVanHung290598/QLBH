package com.hvh.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hvh.model.CartDTO;
import com.hvh.model.ProductAttributeDTO;
import com.hvh.model.ProductDTO;
import com.hvh.model.UserDTO;
import com.hvh.service.CartService;
import com.hvh.service.InvoiceItemService;
import com.hvh.service.ProductAttributeService;
import com.hvh.service.ProductService;
import com.hvh.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductAttributeService productAtttributeService;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	InvoiceItemService invoiceItemService;
	
	public List<Map<String, Object>> getListCart() {
		List<Map<String, Object>> params = new ArrayList<Map<String, Object>>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.isAuthenticated()) {
			String username = authentication.getName();
			UserDTO userDTO = userService.getUserByUsername(username);
			
			List<CartDTO> carts = cartService.getListCartByUser(userDTO.getId());
			for(CartDTO cart : carts) {
				ProductDTO product = productService.getProductById(cart.getProduct_id());
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("product-id", cart.getProduct_id());
				param.put("user-id", cart.getUser_id());
				param.put("color", cart.getColor());
				param.put("size", cart.getSize());
				param.put("quantity", cart.getQuantity());
				param.put("product-name", product.getProduct_name());
				param.put("image", product.getImage());
				param.put("price", product.getUnit_price());
				params.add(param);
			}
		}
		return params;
	}
	
	@RequestMapping(value= {"/","/home"}, method = RequestMethod.GET)
	public String home(Model model, Principal principal, HttpServletRequest req) {
		List<ProductDTO> productDTOs = productService.getListProduct(6,4);
		model.addAttribute("productDTOs", productDTOs);
		model.addAttribute("Top5Product", productService.getTop5Product());
		model.addAttribute("display", "none");
		model.addAttribute("color", "#f1b8c4");		
		if (principal != null) {
			model.addAttribute("params", getListCart());	
		}
		return "home";
	}
	@RequestMapping(value="/collection", method = RequestMethod.GET)
	public String collection(Model model, HttpServletRequest req, HttpServletResponse resp, Principal principal) {
		int pages = req.getParameter("page") == null ? 1 : Integer.parseInt(req.getParameter("page"));
		int limit = req.getParameter("limit") == null ? 8 : Integer.parseInt(req.getParameter("limit"));
		List<ProductDTO> productDTOs = productService.getListProduct(pages,limit);
		int size = productService.getListProduct(1, 1000).size();
		model.addAttribute("size", size);
		model.addAttribute("pages", pages);
		model.addAttribute("limit", limit);
		model.addAttribute("productDTOs", productDTOs);
		model.addAttribute("head", "COLLECTION");
		model.addAttribute("home", "HOME");
		model.addAttribute("page", "PRODUCT");
		model.addAttribute("display", "flex");
		model.addAttribute("color", "#f1b8c4");
		if (principal != null) {
			model.addAttribute("params", getListCart());	
		}
		return "collection";
	}
	@RequestMapping(value="/productSingle", method = RequestMethod.GET)
	public String ProductSingle(Model model, @RequestParam(name="productId", required = false) Integer productId, Principal principal) {
		if(productId != null) {
			ProductDTO productDTO = productService.getProductById(productId);
			model.addAttribute("productDTO", productDTO);
			model.addAttribute("display", "flex");
			List<ProductAttributeDTO> productAttributeDTOs = productAtttributeService.getProductAttributeByProduct(productId);
			model.addAttribute("productAttributeDTOs", productAttributeDTOs);			
		} else {
			model.addAttribute("display", "none");
		}
		model.addAttribute("head", "PRODUCT SINGLE");
		model.addAttribute("home", "HOME");
		model.addAttribute("page", "PRODUCT SINGLE");
		model.addAttribute("color", "#f1b8c4");

		if (principal != null) {
			model.addAttribute("params", getListCart());	
		}
		
		return "productSingle";
	}
	@RequestMapping(value="/search", method = RequestMethod.GET)
	public String searchProduct(Model model, HttpServletRequest req, Principal principal) {
		int page = req.getParameter("page") != null ? Integer.parseInt(req.getParameter("page")) : 1;
		int limit = req.getParameter("limit") != null ? Integer.parseInt(req.getParameter("limit")) : 8;
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("product_name", req.getParameter("productName") != null ? req.getParameter("productName") : "");
		params.put("price_from", req.getParameter("price_from") != null ? req.getParameter("price_from") : "");
		params.put("price_to", req.getParameter("price_to") != null ? req.getParameter("price_to") : "");
		
		List<ProductDTO> productDTOs = productService.searchProduct(params, page, limit);
		int size = productService.searchProduct(params, 1, 1000).size();
		model.addAttribute("size", size);
		model.addAttribute("pages", page);
		model.addAttribute("limit", limit);
		model.addAttribute("productDTOs", productDTOs);
		model.addAttribute("paramSearch", params);
		model.addAttribute("head", "COLLECTION");
		model.addAttribute("home", "HOME");
		model.addAttribute("page", "PRODUCT");
		model.addAttribute("display", "flex");
		model.addAttribute("color", "#f1b8c4");
		if (principal != null) {
			model.addAttribute("params", getListCart());	
		}
		return "collection";
	}
}
