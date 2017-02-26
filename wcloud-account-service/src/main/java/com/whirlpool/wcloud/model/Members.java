package com.whirlpool.wcloud.model;

import java.util.Date;

public class Members {
	
	
	private int id;
	private int company_id;
	private int language_id;	
	private int status_id;
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	private Date email_confirmed_at;
	private int signed_in_count;
	private Date current_sign_in_at;
	private Date last_sign_in_at;
	private Date locked_at;
	private Date reset_password_sent_at;
	private Date confirmation_sent_at;
	private long phone_number;
	private Date created_at;
	private Date updated_at;
	private int m2m_user_id;
	private String Notification_id;
	
public String getNotification_id() {
		return Notification_id;
	}
	public void setNotification_id(String notification_id) {
		Notification_id = notification_id;
	}
	//	public int getLocation_id() {
//		return location_id;
//	}
//	public void setLocation_id(int location_id) {
//		this.location_id = location_id;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getLanguage_id() {
		return language_id;
	}
	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getEmail_confirmed_at() {
		return email_confirmed_at;
	}
	public void setEmail_confirmed_at(Date email_confirmed_at) {
		this.email_confirmed_at = email_confirmed_at;
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
	public int getSigned_in_count() {
		return signed_in_count;
	}
	public void setSigned_in_count(int signed_in_count) {
		this.signed_in_count = signed_in_count;
	}
	public Date getCurrent_sign_in_at() {
		return current_sign_in_at;
	}
	public void setCurrent_sign_in_at(Date current_sign_in_at) {
		this.current_sign_in_at = current_sign_in_at;
	}
	public Date getLast_sign_in_at() {
		return last_sign_in_at;
	}
	public void setLast_sign_in_at(Date last_sign_in_at) {
		this.last_sign_in_at = last_sign_in_at;
	}
	public Date getConfirmation_sent_at() {
		return confirmation_sent_at;
	}
	public void setConfirmation_sent_at(Date confirmation_sent_at) {
		this.confirmation_sent_at = confirmation_sent_at;
	}
	public Date getReset_password_sent_at() {
		return reset_password_sent_at;
	}
	public void setReset_password_sent_at(Date reset_password_sent_at) {
		this.reset_password_sent_at = reset_password_sent_at;
	}
	public Date getLocked_at() {
		return locked_at;
	}
	public void setLocked_at(Date locked_at) {
		this.locked_at = locked_at;
	}
	public int getM2m_user_id() {
		return m2m_user_id;
	}
	public void setM2m_user_id(int m2m_user_id) {
		this.m2m_user_id = m2m_user_id;
	}
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	
	}
