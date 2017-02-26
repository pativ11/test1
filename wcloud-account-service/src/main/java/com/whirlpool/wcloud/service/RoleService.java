package com.whirlpool.wcloud.service;

import java.util.List;
import java.util.Map;

import com.whirlpool.wcloud.exceptions.WCloudException;
import com.whirlpool.wcloud.model.AccountGroup;
import com.whirlpool.wcloud.model.Appliance;
import com.whirlpool.wcloud.model.Group;
import com.whirlpool.wcloud.model.Invitation;
import com.whirlpool.wcloud.model.Role;

public interface RoleService {
	
	public Map<String, String> createGroup(Group group) throws WCloudException;
	public List<Group> getGroupsByAccountId(Integer accountId) throws WCloudException;
	public Map<String, String> assignGroupToInvitedMembers(AccountGroup assignGroup) throws WCloudException;
	
	
	public List<Role> getUserRoles() throws WCloudException;
	public List<Appliance> getAppliances(int accountId , int brandId) throws WCloudException;
	public Map<String, String> sendInvitation(Invitation invitation) throws WCloudException;
	public Map<String, String> setUserRole(int accountId) throws WCloudException;
}
