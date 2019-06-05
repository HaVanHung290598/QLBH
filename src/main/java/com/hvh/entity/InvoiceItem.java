package com.hvh.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="invoice_item")
public class InvoiceItem {
//	@Id
//	@Column(name="id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
	@EmbeddedId
	private PkInvoiceItem pk;
	
	@Embeddable
	public static class PkInvoiceItem implements Serializable {
		private static final long serialVersionUID = 1L;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="product_id")
		private Product product;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="invoice_id")
		private Invoice invoice;

		public PkInvoiceItem() {
			super();
		}

		public PkInvoiceItem(Product product, Invoice invoice) {
			super();
			this.product = product;
			this.invoice = invoice;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public Invoice getInvoice() {
			return invoice;
		}

		public void setInvoice(Invoice invoice) {
			this.invoice = invoice;
		}
	}
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="size")
	private String size;
	
	@Column(name="color")
	private String color;
	
	@Column(name="price")
	private int price;
	
	@Column(name="discount_amount")
	private int discount_amount;
	
	@Column(name="created_at")
	private Date created_at;

	public InvoiceItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvoiceItem(PkInvoiceItem pk, int quantity, String size, String color, int price, int discount_amount,
			Date created_at) {
		super();
		this.pk = pk;
		this.quantity = quantity;
		this.size = size;
		this.color = color;
		this.price = price;
		this.discount_amount = discount_amount;
		this.created_at = created_at;
	}

	public PkInvoiceItem getPk() {
		return pk;
	}

	public void setPk(PkInvoiceItem pk) {
		this.pk = pk;
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
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "invoiceItem")
//	List<InvoiceItemAttribute> invoiceItemAttributes;
	
	
}
