package com.hvh.model;

import java.util.Date;

public class SettingDTO {
	private int id;
	private String setting_name;
	private String value;
	private Date created_at;
	private Date updated_at;
	public SettingDTO() {
		super();
	}
	public SettingDTO(int id, String setting_name, String value, Date created_at, Date updated_at) {
		super();
		this.id = id;
		this.setting_name = setting_name;
		this.value = value;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSetting_name() {
		return setting_name;
	}
	public void setSetting_name(String setting_name) {
		this.setting_name = setting_name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
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
}