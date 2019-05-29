package com.hvh.model;

import java.util.Date;
import java.util.List;

public class InvoiceItemDTO {
	private int id;
	private int invoice_id;
	private int product_id;
	private int quantity;
	private int price;
	private int discount_amount;
	private Date created_at;
	private List<InvoiceItemAttributeDTO> invoiceItemAttributes;
	public InvoiceItemDTO() {
		super();
	}
	public InvoiceItemDTO(int id, int invoice_id, int product_id, int quantity, int price, int discount_amount,
			Date created_at, List<InvoiceItemAttributeDTO> invoiceItemAttributes) {
		super();
		this.id = id;
		this.invoice_id = invoice_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.price = price;
		this.discount_amount = discount_amount;
		this.created_at = created_at;
		this.invoiceItemAttributes = invoiceItemAttributes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public List<InvoiceItemAttributeDTO> getInvoiceItemAttributes() {
		return invoiceItemAttributes;
	}
	public void setInvoiceItemAttributes(List<InvoiceItemAttributeDTO> invoiceItemAttributes) {
		this.invoiceItemAttributes = invoiceItemAttributes;
	}
}
