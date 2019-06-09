package com.hvh.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hvh.model.CartDTO;
import com.hvh.model.ProductDTO;
import com.hvh.service.CartService;
import com.hvh.service.ProductService;

@Controller
//@RequestMapping(value = "/admin")
public class CartController {
	@Autowired
	CartService cartService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/cart", method = RequestMethod.GET)
	public String cart(Model model, HttpServletRequest req) {
		model.addAttribute("head", "MY CART");
		model.addAttribute("home", "HOME");
		model.addAttribute("page", "CART");
		model.addAttribute("display", "none");
		model.addAttribute("color", "#f1b8c4");
		List<Map<String, Object>> params = new ArrayList<Map<String, Object>>();
		List<CartDTO> carts = cartService.getListCartByUser(1);
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
		model.addAttribute("params", params);
		
		int pages = req.getParameter("page") == null ? 1 : Integer.parseInt(req.getParameter("page"));
		int limit = req.getParameter("limit") == null ? 8 : Integer.parseInt(req.getParameter("limit"));
		List<ProductDTO> productDTOs = productService.getListProduct(pages,limit);
		model.addAttribute("pages", pages);
		model.addAttribute("limit", limit);
		model.addAttribute("productDTOs", productDTOs);
		model.addAttribute("display", "block");
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
//		if(cartService.getCartById(1, product_id) == null) {
			cartService.addCart(cartDTO);
//		} else {
//			req.setAttribute("error", "Product already exists in cart");
//		}
		return "redirect:/cart";
	}
	@RequestMapping(value="/deleteCartItem", method = RequestMethod.GET)
	public String deleteCartItem(Model model, @RequestParam(name="user-id")int user_id, @RequestParam(name="product-id")int product_id) {
		cartService.deleteCart(user_id, product_id);
		return "redirect:/cart";
	}
}
