package com.hvh.model;

import java.util.Date;
import java.util.List;

import com.hvh.entity.InvoiceItem;

public class ProductDTO {
	private int id;
	private String product_name;
	private int unit_price;
	private String description;
	private String image;
	private int quantity_available;
	private Date created_at;
	private Date updated_at;

	private List<ProductAttributeDTO> productAttributes;
	private List<CartDTO> carts;
	private List<InvoiceItem> invoiceItems;
	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDTO(int id, String product_name, int unit_price, String description, String image,
			int quantity_available, Date created_at, Date updated_at, List<ProductAttributeDTO> productAttributes,
			List<CartDTO> carts, List<InvoiceItem> invoiceItems) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.unit_price = unit_price;
		this.description = description;
		this.image = image;
		this.quantity_available = quantity_available;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.productAttributes = productAttributes;
		this.carts = carts;
		this.invoiceItems = invoiceItems;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(int unit_price) {
		this.unit_price = unit_price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getQuantity_available() {
		return quantity_available;
	}
	public void setQuantity_available(int quantity_available) {
		this.quantity_available = quantity_available;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public List<ProductAttributeDTO> getProductAttributes() {
		return productAttributes;
	}
	public void setProductAttributes(List<ProductAttributeDTO> productAttributes) {
		this.productAttributes = productAttributes;
	}
	public List<CartDTO> getCarts() {
		return carts;
	}
	public void setCarts(List<CartDTO> carts) {
		this.carts = carts;
	}
	public List<InvoiceItem> getInvoiceItems() {
		return invoiceItems;
	}
	public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}	
}