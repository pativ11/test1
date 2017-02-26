package com.whirlpool.wcloud.dao;

import java.util.List;

import com.whirlpool.wcloud.exceptions.WCloudException;
import com.whirlpool.wcloud.model.AccountGroup;
import com.whirlpool.wcloud.model.Appliance;
import com.whirlpool.wcloud.model.Group;
import com.whirlpool.wcloud.model.LocationRole;
import com.whirlpool.wcloud.model.Role;

public interface RoleDao {

	public String createGroup(Group group) throws WCloudException;

	public List<Group> getGroupsByAccountId(Integer accountId) throws WCloudException;

	public String assignGroupToInvitedMembers(AccountGroup assignGroup) throws WCloudException;

	public List<Appliance> getMemberAppliancesByBrandId(int accountId , int brandId) throws WCloudException;

	//public List<Appliance> getAppliancesByBrandName(String brandName);

	public List<Role> getUserRoles() throws WCloudException;

	//public String sendInvitation(Invitation invitation);

	public String setUserRole(int accountId) throws WCloudException;

	public String assignLocationRole(LocationRole locationRole) throws WCloudException;

}
