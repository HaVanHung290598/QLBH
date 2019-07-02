package com.hvh.dao;

import java.util.List;
import java.util.Map;

import com.hvh.entity.Product;

public interface ProductDAO {
	public void addProduct(Product productDTO);
	public void updateProduct(Product productDTO);
	public void deleteProduct(int id);
	public Product getProductById(int id);
	public List<Product> getListProduct(int page, int limit);
	public List<Product> searchProduct(String productName);
	public List<Product> searchProduct(Map<String, String> params, int page, int limit);
}
