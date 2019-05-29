package com.hvh.service;

import java.util.List;

import com.hvh.model.CartDTO;

public interface CartService {
	public void addCart(CartDTO cartDTO);
	public List<CartDTO> getListCartByUser(int user_id);
}
