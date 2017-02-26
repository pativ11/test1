package com.whirlpool.wcloud.dao;

import java.util.List;

import com.whirlpool.wcloud.model.Members;

public interface MembersDao {


	public List getMembers();
	public List get(int id);
	public void updateMember(Members member, int accountId);
	public List deleteMember(int id);	
	public List getMember();
	public void createMember(Members member);	
	public List getAccounts();

	public boolean isMembersExist(Members member);	
}
