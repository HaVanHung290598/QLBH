package com.hvh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="setting_admin")
public class Setting {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="keywords")
	private String keywords;
	
	@Column(name="author")
	private String author;
	
	@Column(name="discount_amount")
	private int discount_amount;
	
	@Column(name="tax")
	private int tax;

	public Setting() {
		
	}

	public Setting(int id, String title, String description, String keywords, String author, int discount_amount,
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
