package com.hvh.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="invoice")
public class Invoice {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="discount_amount")
	private int discount_amount;
	
	@Column(name="tax")
	private int tax;
	
	@Column(name="total_amount")
	private int total_amount;
	
	@Column(name="status")
	private String status;
	
	@Column(name="delivery_address")
	private String delivery_address;
	
	@Column(name="delivery_phone")
	private String delivery_phone;
	
	@Column(name="created_at")
	private Date created_at;
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "invoice")
//	private List<InvoiceItem> invoiceItems;
	@ManyToMany(mappedBy = "invoices")
	private List<Product> products;
	
	public Invoice() {
		super();
	}

	public Invoice(int id, User user, int discount_amount, int tax, int total_amount, String status,
			String delivery_address, String delivery_phone, Date created_at, List<Product> products) {
		super();
		this.id = id;
		this.user = user;
		this.discount_amount = discount_amount;
		this.tax = tax;
		this.total_amount = total_amount;
		this.status = status;
		this.delivery_address = delivery_address;
		this.delivery_phone = delivery_phone;
		this.created_at = created_at;
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
