package com.whirlpool.wcloud.model;


import java.sql.Timestamp;

public class UserAccount {
	
	private int accountId;
	private int companyId;
	private String first_name;
	private String last_name;
	private String email;
	private int languageId;
	private String password;
	private Timestamp email_confirmed_at;
	private Timestamp created_at;
	private Timestamp updated_at;
	private int signed_in_count;
	private Timestamp current_signed_in_at;
	private Timestamp last_signed_in_at;
	private Timestamp confirmation_sent_at;
	private Timestamp reset_password_sent_at;
	private Timestamp locked_at;
	private int m2m_user_id;
	private int	status_id;
	private String phoneNumber;
	private int notification_id;

	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
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
	public int getLanguageId() {
		return languageId;
	}
	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getEmail_confirmed_at() {
		return email_confirmed_at;
	}
	public void setEmail_confirmed_at(Timestamp email_confirmed_at) {
		this.email_confirmed_at = email_confirmed_at;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public Timestamp getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}
	public int getSigned_in_count() {
		return signed_in_count;
	}
	public void setSigned_in_count(int signed_in_count) {
		this.signed_in_count = signed_in_count;
	}
	public Timestamp getCurrent_signed_in_at() {
		return current_signed_in_at;
	}
	public void setCurrent_signed_in_at(Timestamp current_signed_in_at) {
		this.current_signed_in_at = current_signed_in_at;
	}
	public Timestamp getLast_signed_in_at() {
		return last_signed_in_at;
	}
	public void setLast_signed_in_at(Timestamp last_signed_in_at) {
		this.last_signed_in_at = last_signed_in_at;
	}
	public Timestamp getConfirmation_sent_at() {
		return confirmation_sent_at;
	}
	public void setConfirmation_sent_at(Timestamp confirmation_sent_at) {
		this.confirmation_sent_at = confirmation_sent_at;
	}
	public Timestamp getReset_password_sent_at() {
		return reset_password_sent_at;
	}
	public void setReset_password_sent_at(Timestamp reset_password_sent_at) {
		this.reset_password_sent_at = reset_password_sent_at;
	}
	public Timestamp getLocked_at() {
		return locked_at;
	}
	public void setLocked_at(Timestamp locked_at) {
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getNotification_id() {
		return notification_id;
	}
	public void setNotification_id(int notification_id) {
		this.notification_id = notification_id;
	}
}
