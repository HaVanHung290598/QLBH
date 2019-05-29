package com.hvh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvh.dao.CartDAO;
import com.hvh.dao.ProductDAO;
import com.hvh.dao.UserDAO;
import com.hvh.entity.Cart;
import com.hvh.entity.Cart.Pk;
import com.hvh.model.CartDTO;
import com.hvh.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Override
	public void addCart(CartDTO cartDTO) {
		Cart cart = new Cart();
		Pk pk = new Pk();
		pk.setProduct(productDAO.getProductById(cartDTO.getProduct_id()));
		pk.setUser(userDAO.getUserById(cartDTO.getUser_id()));
		cart.setPk(pk);
		cart.setQuantity(cartDTO.getQuantity());
		cart.setSize(cartDTO.getSize());
		cart.setColor(cartDTO.getColor());
		cartDAO.addCart(cart);
	}

	@Override
	public List<CartDTO> getListCartByUser(int user_id) {
		List<Cart> carts = cartDAO.getListCartByUser(user_id);
		List<CartDTO> cartDTOs = new ArrayList<CartDTO>();
		for(Cart cart : carts) {
			CartDTO cartDTO = new CartDTO();
			cartDTO.setProduct_id(cart.getPk().getProduct().getId());
			cartDTO.setUser_id(cart.getPk().getUser().getId());			
			cartDTO.setQuantity(cart.getQuantity());
			cartDTO.setSize(cart.getSize());
			cartDTO.setColor(cart.getColor());
			cartDTOs.add(cartDTO);
		}
		return cartDTOs;
	}

}
