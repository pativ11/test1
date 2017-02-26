package com.whirlpool.wcloud.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whirlpool.wcloud.dao.RoleDao;
import com.whirlpool.wcloud.exceptions.WCloudException;
import com.whirlpool.wcloud.model.AccountGroup;
import com.whirlpool.wcloud.model.Appliance;
import com.whirlpool.wcloud.model.Group;
import com.whirlpool.wcloud.model.Invitation;
import com.whirlpool.wcloud.model.LocationRole;
import com.whirlpool.wcloud.model.Role;
import com.whirlpool.wcloud.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleDao roleDao;

	@Override
	public Map<String, String> createGroup(Group group) throws WCloudException {
		Map<String, String> serviceResp = new HashMap<String, String>();
		serviceResp.put("response", roleDao.createGroup(group));
		return serviceResp;
	}

	@Override
	public List<Group> getGroupsByAccountId(Integer accountId) throws WCloudException {
		return roleDao.getGroupsByAccountId(accountId);
	}

	@Override
	public Map<String, String>  assignGroupToInvitedMembers(AccountGroup assignGroup) throws WCloudException {
		Map<String, String> serviceResp = new HashMap<String, String>();
		serviceResp.put("response", roleDao.assignGroupToInvitedMembers(assignGroup));
		return serviceResp;
	}

	@Override
	public List<Role> getUserRoles() throws WCloudException {
		return roleDao.getUserRoles();
	}

	@Override
	public List<Appliance> getAppliances(int accountId, int brandId) throws WCloudException {
		return roleDao.getMemberAppliancesByBrandId(accountId, brandId);
	}

	// TO DO Need TO Manage TX
	@Override
	public Map<String, String>  sendInvitation(Invitation invitation) throws WCloudException {
		Map<String, String> serviceResp = new HashMap<String, String>();
		String response = invitation.getEmailId() + " User Invited Sucessfully ";

		// check for valid user
		// Send Email
		// insert into account group
		AccountGroup assignGroup = new AccountGroup();
		assignGroup.setAccountId(invitation.getAccountId());
		assignGroup.setGroupId(invitation.getGroupId());
		roleDao.assignGroupToInvitedMembers(assignGroup);
		System.out.println(" Group Account Added ");
		// insert into Location Role
		LocationRole locationRole = new LocationRole();
		locationRole.setGroupId(invitation.getGroupId());
		locationRole.setLocationId(invitation.getAccountId());
		roleDao.assignLocationRole(locationRole);
		System.out.println(" Location Role Added ");
		serviceResp.put("response", response);
		return serviceResp;
	}

	@Override
	public Map<String, String>  setUserRole(int accountId) throws WCloudException {
		Map<String, String> serviceResp = new HashMap<String, String>();
		serviceResp.put("response", roleDao.setUserRole(accountId));
		return serviceResp;
	}

}
