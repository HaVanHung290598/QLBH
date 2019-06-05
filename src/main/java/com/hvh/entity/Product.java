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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="product")
public class Product {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "product_name")
	private String product_name;

	@Column(name = "unit_price")
	private int unit_price;

	@Column(name = "description")
	private String description;

	@Column(name = "image")
	private String image;

	@Column(name = "quantity_available")
	private int quantity_available;

	@Column(name = "created_at")
	@Temporal(TemporalType.DATE)
	private Date created_at;

	@Column(name = "updated_at")
	@Temporal(TemporalType.DATE)
	private Date updated_at;
	
	@ManyToMany
	@JoinTable(name="cart", joinColumns = @JoinColumn(name="product_id"), inverseJoinColumns = @JoinColumn(name="user_id"))
	private List<User> users;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
	private List<ProductAttribute> productAttributes;
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
//	private List<InvoiceItem> invoiceItems;
	@ManyToMany
	@JoinTable(name="invoice_item", joinColumns = @JoinColumn(name="invoice_id"), inverseJoinColumns = @JoinColumn(name="product_id"))
	private List<Invoice> invoices;

	public Product() {
		super();
	}

	public Product(int id, String product_name, int unit_price, String description, String image,
			int quantity_available, Date created_at, Date updated_at, List<User> users,
			List<ProductAttribute> productAttributes, List<Invoice> invoices) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.unit_price = unit_price;
		this.description = description;
		this.image = image;
		this.quantity_available = quantity_available;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.users = users;
		this.productAttributes = productAttributes;
		this.invoices = invoices;
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<ProductAttribute> getProductAttributes() {
		return productAttributes;
	}

	public void setProductAttributes(List<ProductAttribute> productAttributes) {
		this.productAttributes = productAttributes;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}
}
