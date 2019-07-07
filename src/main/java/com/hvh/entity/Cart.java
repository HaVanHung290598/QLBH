package com.hvh.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart_item")
public class Cart {
	@EmbeddedId
	private Pk pk;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="size")
	private String size;
	
	@Column(name="color")
	private String color;
	
	@Embeddable
	public static class Pk implements Serializable {
		private static final long serialVersionUID = 1L;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="product_id")
		private Product product;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="user_id")
		private User user;

		public Pk() {
			super();
		}

		public Pk(Product product, User user) {
			super();
			this.product = product;
			this.user = user;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
	}

	public Cart() {
		super();
	}

	public Cart(Pk pk, int quantity, String size, String color) {
		super();
		this.pk = pk;
		this.quantity = quantity;
		this.size = size;
		this.color = color;
	}

	public Pk getPk() {
		return pk;
	}

	public void setPk(Pk pk) {
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
}
