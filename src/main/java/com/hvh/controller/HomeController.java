package com.hvh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hvh.model.CartDTO;
import com.hvh.model.ProductAttributeDTO;
import com.hvh.model.ProductDTO;
import com.hvh.service.CartService;
import com.hvh.service.ProductAttributeService;
import com.hvh.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductAttributeService productAtttributeService;
	
	@Autowired
	CartService cartService;
	
	@RequestMapping(value= {"/","home"}, method = RequestMethod.GET)
	public String home(Model model) {
		List<ProductDTO> productDTOs = productService.getListProduct(6,4);
		model.addAttribute("productDTOs", productDTOs);
		model.addAttribute("display", "none");
		return "home";
	}
	@RequestMapping(value="/collection", method = RequestMethod.GET)
	public String collection(Model model, HttpServletRequest req, HttpServletResponse resp) {
		int pages = req.getParameter("page") == null ? 1 : Integer.parseInt(req.getParameter("page"));
		int limit = req.getParameter("limit") == null ? 8 : Integer.parseInt(req.getParameter("limit"));
		List<ProductDTO> productDTOs = productService.getListProduct(pages,limit);
		model.addAttribute("pages", pages);
		model.addAttribute("limit", limit);
		model.addAttribute("productDTOs", productDTOs);
		model.addAttribute("head", "COLLECTION");
		model.addAttribute("home", "HOME");
		model.addAttribute("page", "PRODUCT");
		model.addAttribute("display", "block");
		return "collection";
	}
	@RequestMapping(value="/productSingle", method = RequestMethod.GET)
	public String ProductSingle(Model model, @RequestParam(name="productId", required = false) Integer productId) {
		if(productId != null) {
			ProductDTO productDTO = productService.getProductById(productId);
			model.addAttribute("productDTO", productDTO);
			model.addAttribute("display", "block");
			List<ProductAttributeDTO> productAttributeDTOs = productAtttributeService.getProductAttributeByProduct(productId);
			model.addAttribute("productAttributeDTOs", productAttributeDTOs);			
		} else {
			model.addAttribute("display", "none");
		}
		model.addAttribute("head", "PRODUCT SINGLE");
		model.addAttribute("home", "HOME");
		model.addAttribute("page", "PRODUCT SINGLE");
		return "productSingle";
	}
	@RequestMapping(value="/cart", method = RequestMethod.GET)
	public String cart(Model model) {
		model.addAttribute("head", "MY CART");
		model.addAttribute("home", "HOME");
		model.addAttribute("page", "CART");
		List<CartDTO> carts = cartService.getListCartByUser(1);
		model.addAttribute("carts", carts);
		return "cart";
	}
	@RequestMapping(value="/cart", method = RequestMethod.POST)
	public String cart(HttpServletRequest req, HttpServletResponse resp) {
		int product_id = Integer.parseInt(req.getParameter("product-id"));
		String color = req.getParameter("product-color");
		String size = req.getParameter("product-size");
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		CartDTO cartDTO = new CartDTO();
		cartDTO.setProduct_id(product_id);
		cartDTO.setUser_id(1);
		cartDTO.setQuantity(quantity);
		cartDTO.setSize(size);
		cartDTO.setColor(color);
		cartService.addCart(cartDTO);
		return "redirect:/cart";
	}
}
