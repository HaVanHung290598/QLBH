package com.hvh.model;

import java.util.Date;
import java.util.List;

public class InvoiceDTO {
	private int id;
	private int user_id;
	private int discount_amount;
	private int tax;
	private int total_amount;
	private String status;
	private String delivery_address;
	private String delivery_phone;
	private Date created_at;
	private List<InvoiceItemDTO> invoiceItems;
	public InvoiceDTO() {
		super();
	}
	public InvoiceDTO(int id, int user_id, int discount_amount, int tax, int total_amount, String status,
			String delivery_address, String delivery_phone, Date created_at, List<InvoiceItemDTO> invoiceItems) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.discount_amount = discount_amount;
		this.tax = tax;
		this.total_amount = total_amount;
		this.status = status;
		this.delivery_address = delivery_address;
		this.delivery_phone = delivery_phone;
		this.created_at = created_at;
		this.invoiceItems = invoiceItems;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getDiscount_amount() {
		return discount_amount;
	}
	public void setDiscount_amount(int discount_amount) {
		this.discount_amount = discount_amount;
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	public int getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDelivery_address() {
		return delivery_address;
	}
	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}
	public String getDelivery_phone() {
		return delivery_phone;
	}
	public void setDelivery_phone(String delivery_phone) {
		this.delivery_phone = delivery_phone;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public List<InvoiceItemDTO> getInvoiceItems() {
		return invoiceItems;
	}
	public void setInvoiceItems(List<InvoiceItemDTO> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}
}
