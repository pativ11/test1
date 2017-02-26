package com.whirlpool.wcloud.model;

import java.io.Serializable;

public class GroupRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int Group_ID;
	private String Group_Name;
	private int Role_ID;
	private int Account_ID;

	public int getGroup_ID() {
		return Group_ID;
	}

	public void setGroup_ID(int group_ID) {
		Group_ID = group_ID;
	}

	public String getGroup_Name() {
		return Group_Name;
	}

	public void setGroup_Name(String group_Name) {
		Group_Name = group_Name;
	}

	public int getRole_ID() {
		return Role_ID;
	}

	public void setRole_ID(int role_ID) {
		Role_ID = role_ID;
	}

	public int getAccount_ID() {
		return Account_ID;
	}

	public void setAccount_ID(int account_ID) {
		Account_ID = account_ID;
	}

	@Override
	public String toString() {
		return "Group [Group_ID=" + Group_ID + ", Group_Name=" + Group_Name + ", Role_ID=" + Role_ID + ", Account_ID="
				+ Account_ID + "]";
	}

}
