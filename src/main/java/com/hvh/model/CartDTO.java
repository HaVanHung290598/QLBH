package com.hvh.model;

public class CartDTO {
	private int user_id;
	private int product_id;
	private int quantity;
	private String size;
	private String color;
	public CartDTO() {
		super();
	}
	public CartDTO(int user_id, int product_id, int quantity, String size, String color) {
		super();
		this.user_id = user_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.size = size;
		this.color = color;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
