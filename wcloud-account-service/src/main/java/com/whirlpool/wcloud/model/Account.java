package com.whirlpool.wcloud.model;

import java.util.Date;

public class Account {

	private int id;
	private String account_status;
	private Date created_at;
	private Date updated_at;
	private int m2m_user_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAccount_status() {
		return account_status;
	}
	public void setAccount_status(String account_status) {
		this.account_status = account_status;
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
	public int getM2m_user_id() {
		return m2m_user_id;
	}
	public void setM2m_user_id(int m2m_user_id) {
		this.m2m_user_id = m2m_user_id;
	}
	
	
}
