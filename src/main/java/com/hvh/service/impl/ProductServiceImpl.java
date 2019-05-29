package com.hvh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvh.dao.ProductDAO;
import com.hvh.entity.Product;
import com.hvh.model.ProductDTO;
import com.hvh.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDAO productDAO;

	@Override
	public void addProduct(ProductDTO productDTO) {
		Product product = new Product();
		product.setId(productDTO.getId());
		product.setProduct_name(productDTO.getProduct_name());
		product.setUnit_price(productDTO.getUnit_price());
		product.setDescription(productDTO.getDescription());
		product.setImage(productDTO.getImage());
		product.setQuantity_available(productDTO.getQuantity_available());
		product.setCreated_at(productDTO.getCreated_at());
		product.setUpdated_at(productDTO.getUpdated_at());
		productDAO.addProduct(product);		
	}

	@Override
	public void updateProduct(ProductDTO productDTO) {
		Product product = new Product();
		product.setId(productDTO.getId());
		product.setProduct_name(productDTO.getProduct_name());
		product.setUnit_price(productDTO.getUnit_price());
		product.setDescription(productDTO.getDescription());
		product.setImage(productDTO.getImage());
		product.setQuantity_available(productDTO.getQuantity_available());
		product.setCreated_at(productDTO.getCreated_at());
		product.setUpdated_at(productDTO.getUpdated_at());
		productDAO.updateProduct(product);
	}

	@Override
	public void deleteProduct(int id) {
		productDAO.deleteProduct(id);
		
	}

	@Override
	public ProductDTO getProductById(int id) {
		Product product = productDAO.getProductById(id);
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setProduct_name(product.getProduct_name());
		productDTO.setUnit_price(product.getUnit_price());
		productDTO.setDescription(product.getDescription());
		productDTO.setImage(product.getImage());
		productDTO.setQuantity_available(product.getQuantity_available());
		productDTO.setCreated_at(product.getCreated_at());
		productDTO.setUpdated_at(product.getUpdated_at());
		return productDTO;
	}

	@Override
	public List<ProductDTO> getListProduct(int page, int limit) {
		List<Product> arrProduct = new ArrayList<Product>();
		arrProduct = productDAO.getListProduct(page, limit);
		List<ProductDTO> arrProductDTO = new ArrayList<ProductDTO>();
		for(Product product : arrProduct) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setId(product.getId());
			productDTO.setProduct_name(product.getProduct_name());
			productDTO.setUnit_price(product.getUnit_price());
			productDTO.setDescription(product.getDescription());
			productDTO.setImage(product.getImage());
			productDTO.setQuantity_available(product.getQuantity_available());
			productDTO.setCreated_at(product.getCreated_at());
			productDTO.setUpdated_at(product.getUpdated_at());
			arrProductDTO.add(productDTO);
		}
		return arrProductDTO;
	}
}
