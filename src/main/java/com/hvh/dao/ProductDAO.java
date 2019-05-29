package com.hvh.dao;

import java.util.List;

import com.hvh.entity.Product;

public interface ProductDAO {
	public void addProduct(Product productDTO);
	public void updateProduct(Product productDTO);
	public void deleteProduct(int id);
	public Product getProductById(int id);
	public List<Product> getListProduct(int page, int limit);
}
