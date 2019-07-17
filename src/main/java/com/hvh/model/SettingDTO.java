package com.hvh.model;

public class SettingDTO {
	private int id;
	private String title;
	private String description;
	private String keywords;
	private String author;
	private int discount_amount;
	private int tax;
	public SettingDTO() {
		
	}
	public SettingDTO(int id, String title, String description, String keywords, String author, int discount_amount,
			int tax) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.keywords = keywords;
		this.author = author;
		this.discount_amount = discount_amount;
		this.tax = tax;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
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
}
