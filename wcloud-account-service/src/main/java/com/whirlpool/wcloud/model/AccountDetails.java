package com.whirlpool.wcloud.model;

public class AccountDetails {

	private AccountBrand brand;
	private UserAccount userAccount;
	private LocationModel location;
	
	public AccountBrand getBrand() {
		return brand;
	}
	public void setBrand(AccountBrand brand) {
		this.brand = brand;
	}
	public UserAccount getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	public LocationModel getLocation() {
		return location;
	}
	public void setLocation(LocationModel location) {
		this.location = location;
	}
	
}
