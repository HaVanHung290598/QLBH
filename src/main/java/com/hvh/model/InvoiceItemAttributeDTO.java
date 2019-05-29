package com.hvh.model;

public class InvoiceItemAttributeDTO {
	private int id;
	private int invoice_item_id;
	private String attribute;
	private String value;
	public InvoiceItemAttributeDTO() {
		super();
	}
	public InvoiceItemAttributeDTO(int id, int invoice_item_id, String attribute, String value) {
		super();
		this.id = id;
		this.invoice_item_id = invoice_item_id;
		this.attribute = attribute;
		this.value = value;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getInvoice_item_id() {
		return invoice_item_id;
	}
	public void setInvoice_item_id(int invoice_item_id) {
		this.invoice_item_id = invoice_item_id;
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
