package com.hvh.model;

public class ProductAttributeDTO {
	private int id;
	private int product_id;
	private String attribute;
	private String value;
	public ProductAttributeDTO() {
		super();
	}
	public ProductAttributeDTO(int id, int product_id, String attribute, String value) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.attribute = attribute;
		this.value = value;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
