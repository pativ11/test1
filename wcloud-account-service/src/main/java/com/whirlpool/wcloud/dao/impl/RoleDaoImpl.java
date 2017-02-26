package com.whirlpool.wcloud.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.whirlpool.wcloud.common.utils.LoggerUtil;
import com.whirlpool.wcloud.dao.RoleDao;
import com.whirlpool.wcloud.db.dashdb.dao.impl.DashDbGenericDaoImpl;
import com.whirlpool.wcloud.exceptions.WCloudException;
import com.whirlpool.wcloud.model.AccountGroup;
import com.whirlpool.wcloud.model.AccountUtil;
import com.whirlpool.wcloud.model.Appliance;
import com.whirlpool.wcloud.model.Group;
import com.whirlpool.wcloud.model.LocationRole;
import com.whirlpool.wcloud.model.Role;

@ComponentScan(basePackages = { "com.whirlpool.wcloud" })
@Repository
public class RoleDaoImpl extends DashDbGenericDaoImpl implements RoleDao {
	final Logger logger = Logger.getLogger(RoleDaoImpl.class);

	/** USER STORY-1 : When a user creates an account and confirms it, the users role shall be preset**/
	// Need to get User Roles using method getUserRoles() and createGroup()

	/**
	 * set default role
	 * @throws WCloudException 
	 */
	@Override
	public String setUserRole(int accountId) throws WCloudException{
		try {
			insert(INSERT_GROUP, new Object[] { "Primary", accountId, AccountUtil.STANDARD_USER });
		} catch (Exception e) {
			throw new WCloudException(" Insertion Failed Please Check The Input");
		}
		return AccountUtil.INSERTED_SUCCESS;
	}

	/** User Story-2 
	 * @throws WCloudException */
	@Override
	public String createGroup(Group group) throws WCloudException {
		try {
			insert(INSERT_GROUP, new Object[] { group.getGroupName(), group.getAccountId(), group.getRoleId() });
		} catch (Exception e) {
			throw new WCloudException(" Group Creation Failed Please Check The Input");
		}
		return AccountUtil.INSERTED_SUCCESS;
	}

	@Override
	public List<Group> getGroupsByAccountId(Integer accountId) throws WCloudException {
		LoggerUtil.logMessage(logger, "RoleDaoImpl : getAccounts : executing " + SELECT_GROUPS);
		List<Group> list = null;
		try {
			list = get(SELECT_GROUPS, new Object[] { accountId });
		} catch (Exception e) {
			throw new WCloudException(" Insertion Failed Please Check The Input");
		}
		
		LoggerUtil.logMessage(logger, "RoleDaoImpl : getUserRoles : end : returning  " + list);
		return list;
	}

	@Override
	public List<Role> getUserRoles() throws WCloudException {
		LoggerUtil.logMessage(logger, "RoleDaoImpl : getAccounts : executing " + SELECT_ROLES);
		List<Role> list = null;
		try {
			list = select(SELECT_ROLES);
		} catch (Exception e) {
			throw new WCloudException(" Insertion Failed Please Check The Input");
		}
		LoggerUtil.logMessage(logger, "RoleDaoImpl : getUserRoles : end : returning  " + list);
		return list;
	}

	@Override
	public String assignGroupToInvitedMembers(AccountGroup assignGroup) throws WCloudException {
		try {
			insert(INSERT_ACCOUNT_GROUP, new Object[] { assignGroup.getAccountId(), assignGroup.getGroupId() });
		} catch (Exception e) {
			throw new WCloudException(" Insertion Failed Please Check The Input");
		}
		return AccountUtil.INVITATION_SUCCESS;
	}

	/**
	 * User Story-3:As a <brand> app user, I need only my<brand> appliances to
	 * be visible to the member
	 * @throws WCloudException 
	 **/

	@Override
	public List<Appliance> getMemberAppliancesByBrandId(int accountId ,int brandId) throws WCloudException {
		LoggerUtil.logMessage(logger, "RoleDaoImpl : getMemberAppliancesByBrandId " + SELECT_MEMBER_APPLIANCE_BY_BRAND);
		List<Appliance> list = null;
		try {
			list = get(SELECT_MEMBER_APPLIANCE_BY_BRAND, new Object[]{accountId, brandId});
		} catch (Exception e) {
			throw new WCloudException(" UNABLE TO FATCH APPLIANCCES ");
		}
		LoggerUtil.logMessage(logger, "RoleDaoImpl : getMemberAppliancesByBrandId : end : returning  " + list);
		return list;
	}

	/**
	 * User Story-4 : As a primary user, I should be able to invite another
	 * member to use my appliances specific to a location or multiple locations
	 * @throws WCloudException 
	 **/
	@Override
	public String assignLocationRole(LocationRole locationRole) throws WCloudException {
		try {
			insert(INSERT_LOCATION_GROUPS, new Object[] { locationRole.getGroupId(), locationRole.getLocationId() });
		} catch (Exception e) {
			throw new WCloudException(" LOCATION ROLE ASSIGNMENT FAILED ");
		}
		return AccountUtil.ASSIGN_GROUP_LOCATION;
	}


}
