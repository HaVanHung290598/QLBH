package com.hvh.dao;

import java.util.List;

import com.hvh.entity.Cart;

public interface CartDAO {
	public void addCart(Cart cart);
	public List<Cart> getListCartByUser(int user_id);
}
