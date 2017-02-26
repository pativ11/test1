package com.whirlpool.wcloud.dao;

import java.util.List;

import com.whirlpool.wcloud.db.dashdb.model.Customer;
import com.whirlpool.wcloud.model.Account;
import com.whirlpool.wcloud.model.AccountCreation;

public interface AccountsDao {

	public void createAccount (AccountCreation account);
	
	public List getAccounts();
	public List get(int accountId);
	public void updateLanguagePref(int accountId, String language);
	public void logout(int accountId);	
	public List getusername();
	public String getBrand();
	public List getEmailTimestamp(int accountId);
	public void updateStatus(int accountId, int statusID);
}
