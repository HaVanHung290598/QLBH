package com.hvh.service;

import java.util.List;

import com.hvh.model.CartDTO;

public interface CartService {
	public void addCart(CartDTO cartDTO);
	public void updateCart(CartDTO cartDTO);
	public void deleteCartByUserId(int user_id);
	public void deleteCart(int user_id, int product_id);
	public CartDTO getCartById(int user_id, int product_id);
	public List<CartDTO> getListCartByUser(int user_id);
}
