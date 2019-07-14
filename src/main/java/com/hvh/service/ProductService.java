package com.hvh.service;

import java.util.List;
import java.util.Map;

import com.hvh.model.ProductDTO;

public interface ProductService {
	public void addProduct(ProductDTO product);
	public void updateProduct(ProductDTO product);
	public void deleteProduct(int id);
	public ProductDTO getProductById(int id);
	public List<ProductDTO> getListProduct(int page, int limit);
//	public List<ProductDTO> searchProduct(String productName);
	public List<ProductDTO> searchProduct(Map<String, String> params, int page, int limit);
	public List<ProductDTO> searchProductAdmin(Map<String, String> params, int page, int limit);
	public List<ProductDTO> getTop5Product();
}
