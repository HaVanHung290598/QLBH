package com.hvh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="invoice_item_attribute")
public class InvoiceItemAttribute {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="invoice_item_id")
	private InvoiceItem invoiceItem;
	
	@Column(name="attribute")
	private String attribute;
	
	@Column(name="value")
	private String value;
	
	public InvoiceItemAttribute() {
		super();
	}

	public InvoiceItemAttribute(int id, InvoiceItem invoiceItem, String attribute, String value) {
		super();
		this.id = id;
		this.invoiceItem = invoiceItem;
		this.attribute = attribute;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public InvoiceItem getInvoiceItem() {
		return invoiceItem;
	}

	public void setInvoiceItem(InvoiceItem invoiceItem) {
		this.invoiceItem = invoiceItem;
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
