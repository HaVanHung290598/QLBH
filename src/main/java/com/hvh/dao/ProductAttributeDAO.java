package com.hvh.dao;

import java.util.List;

import com.hvh.entity.ProductAttribute;

public interface ProductAttributeDAO {
	public ProductAttribute getProductAttributeById(int id);
	public List<ProductAttribute> getListProductAttributeByProduct(int product_id);
}
