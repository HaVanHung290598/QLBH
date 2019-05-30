package com.hvh.dao;

import java.util.List;

import com.hvh.entity.Cart;
import com.hvh.entity.Cart.Pk;

public interface CartDAO {
	public void addCart(Cart cart);
	public void deleteCart(Pk pk);
	public Cart getCartById(Pk pk);
	public List<Cart> getListCartByUser(int user_id);
}
