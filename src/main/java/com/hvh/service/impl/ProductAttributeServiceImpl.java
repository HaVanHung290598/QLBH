package com.hvh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvh.dao.ProductAttributeDAO;
import com.hvh.entity.ProductAttribute;
import com.hvh.model.ProductAttributeDTO;
import com.hvh.service.ProductAttributeService;

@Service
public class ProductAttributeServiceImpl implements ProductAttributeService {

	@Autowired
	ProductAttributeDAO productAttributeDAO;

	@Override
	public ProductAttributeDTO getProductAttributeById(int id) {
		
		return null;
	}

	@Override
	public List<ProductAttributeDTO> getProductAttributeByProduct(int product_id) {
		List<ProductAttribute> productAttributes = productAttributeDAO.getListProductAttributeByProduct(product_id);
		List<ProductAttributeDTO> productAttributeDTOs = new ArrayList<ProductAttributeDTO>();
		for(ProductAttribute productAttribute : productAttributes) {
			ProductAttributeDTO productAttributeDTO = new ProductAttributeDTO();
			productAttributeDTO.setId(productAttribute.getId());
			productAttributeDTO.setProduct_id(productAttribute.getProduct().getId());
			productAttributeDTO.setAttribute(productAttribute.getAttribute());
			productAttributeDTO.setValue(productAttribute.getValue());
			productAttributeDTOs.add(productAttributeDTO);
		}
		return productAttributeDTOs;
	}
}
