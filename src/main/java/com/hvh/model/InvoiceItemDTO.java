package com.hvh.model;

import java.util.Date;

public class InvoiceItemDTO {
	private int invoice_id;
	private int product_id;
	private int quantity;
	private String size;
	private String color;
	private int price;
	private int discount_amount;
	private Date created_at;
	public InvoiceItemDTO() {
		super();
	}
	public InvoiceItemDTO(int invoice_id, int product_id, int quantity, String size, String color, int price,
			int discount_amount, Date created_at) {
		super();
		this.invoice_id = invoice_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.size = size;
		this.color = color;
		this.price = price;
		this.discount_amount = discount_amount;
		this.created_at = created_at;
	}
	public int getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscount_amount() {
		return discount_amount;
	}
	public void setDiscount_amount(int discount_amount) {
		this.discount_amount = discount_amount;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
}
