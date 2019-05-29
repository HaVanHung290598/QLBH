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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="invoice_item")
public class InvoiceItem {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="invoice_id")
	private Invoice invoice;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="product_id")
	private Product product;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="price")
	private int price;
	
	@Column(name="discount_amount")
	private int discount_amount;
	
	@Column(name="created_at")
	private Date created_at;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "invoiceItem")
	List<InvoiceItemAttribute> invoiceItemAttributes;
	
	public InvoiceItem() {
		super();
	}

	public InvoiceItem(int id, Invoice invoice, Product product, int quantity, int price, int discount_amount,
			Date created_at, List<InvoiceItemAttribute> invoiceItemAttributes) {
		super();
		this.id = id;
		this.invoice = invoice;
		this.product = product;
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

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	public List<InvoiceItemAttribute> getInvoiceItemAttributes() {
		return invoiceItemAttributes;
	}

	public void setInvoiceItemAttributes(List<InvoiceItemAttribute> invoiceItemAttributes) {
		this.invoiceItemAttributes = invoiceItemAttributes;
	}
}
