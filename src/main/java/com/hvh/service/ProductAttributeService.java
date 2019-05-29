package com.hvh.service;

import java.util.List;

import com.hvh.model.ProductAttributeDTO;

public interface ProductAttributeService {
	public ProductAttributeDTO getProductAttributeById(int id);
	public List<ProductAttributeDTO> getProductAttributeByProduct(int product_id);
}
