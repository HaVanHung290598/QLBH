package com.hvh.model;

import java.util.Date;
import java.util.List;

public class UserDTO {
	private int id;
	private String username;
	private String password;
	private String fullname;
	private String address;
	private String phone;
	private String email;
	private Date created_at;
	private Date updated_at;
	private int role;
	private List<CartDTO> carts;
	private List<InvoiceDTO> invoices;
	
	public UserDTO() {
		super();
	}

	public UserDTO(int id, String username, String password, String fullname, String address, String phone,
			String email, Date created_at, Date updated_at, int role, List<CartDTO> carts, List<InvoiceDTO> invoices) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.role = role;
		this.carts = carts;
		this.invoices = invoices;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public List<CartDTO> getCarts() {
		return carts;
	}

	public void setCarts(List<CartDTO> carts) {
		this.carts = carts;
	}

	public List<InvoiceDTO> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<InvoiceDTO> invoices) {
		this.invoices = invoices;
	}
}
