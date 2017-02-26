package com.whirlpool.wcloud.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.whirlpool.wcloud.common.utils.LoggerUtil;
import com.whirlpool.wcloud.exceptions.WCloudException;
import com.whirlpool.wcloud.model.AccountGroup;
import com.whirlpool.wcloud.model.AccountUtil;
import com.whirlpool.wcloud.model.Appliance;
import com.whirlpool.wcloud.model.Group;
import com.whirlpool.wcloud.model.Invitation;
import com.whirlpool.wcloud.model.Role;
import com.whirlpool.wcloud.service.RoleService;

@RestController
@RequestMapping("/api")
public class RoleController {
	static final Logger logger = Logger.getLogger(RoleController.class);

	@Autowired
	RoleService roleService;

	/**
	 * USER STORY -1:When a user creates an account and confirms it, the users
	 * role shall be preset
	 * 
	 * @throws WCloudException
	 **/
	// Need to use methods getUserRoles() and createGroup()
	@RequestMapping(value = "/{accountId}/setRole", method = RequestMethod.GET)
	public ResponseEntity<Map> setUserRole(@PathVariable int accountId) throws WCloudException {
		LoggerUtil.logMessage(logger, " setRoles : SET");
		ResponseEntity<Map> response = null;
		if (accountId == 0) {
			throw new WCloudException(AccountUtil.ERR_CHECK_INPUTS);
		} else {
			response = new ResponseEntity<Map>(roleService.setUserRole(accountId), HttpStatus.OK);
		}
		return response;
	}

	/**
	 * USER STORY -2 :As a company adminstrator, I want to be able to select a
	 * Roles from a list so that I can assign the roles to the invited member
	 * (my company employee).
	 * 
	 * @throws WCloudException
	 **/
	@RequestMapping(value = "/create_group", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public ResponseEntity<Map> createGroup(@RequestBody Group group) throws WCloudException {
		LoggerUtil.logMessage(logger, " Start createGroup : POST " + group);
		ResponseEntity<Map> response = null;
		if (group.getAccountId() == 0 || group.getGroupName() == null || group.getRoleId() == 0) {
			throw new WCloudException(AccountUtil.ERR_CHECK_INPUTS);
		} else {
			
			response = new ResponseEntity<Map>(roleService.createGroup(group), HttpStatus.OK);
		}
		LoggerUtil.logMessage(logger, " End createGroup : POST");
		return response;
	}

	@RequestMapping(value = "/get_roles_list", method = RequestMethod.GET)
	public ResponseEntity<List<Role>> getRoles() throws WCloudException {
		LoggerUtil.logMessage(logger, " getRoles : GET");
		return new ResponseEntity<List<Role>>(roleService.getUserRoles(), HttpStatus.OK);
	}

	@RequestMapping(value = "/get_groups/{account_Id}", method = RequestMethod.GET)
	public ResponseEntity<List<Group>> getGroupsByAccountId(@PathVariable("account_Id") int accountId)
			throws WCloudException {
		LoggerUtil.logMessage(logger, " Start getGroupsByAccountId : GET");
		ResponseEntity<List<Group>> response = null;
		if (accountId == 0) {
			throw new WCloudException(AccountUtil.ERR_CHECK_INPUTS);
		} else {
			response = new ResponseEntity<List<Group>>(roleService.getGroupsByAccountId(accountId), HttpStatus.OK);
		}
		LoggerUtil.logMessage(logger, " End getGroupsByAccountId : GET");
		return response;
	}

	@RequestMapping(value = "/group_assignment", method = RequestMethod.POST)
	public ResponseEntity<Map> assignGroupToInvitedMembers(@RequestBody AccountGroup assignGroup)
			throws WCloudException {
		LoggerUtil.logMessage(logger, " Start assignGroupToInvitedMembers : POST");
		ResponseEntity<Map> response = null;
		if (assignGroup.getAccountId() == 0 && assignGroup.getAccountId() == 0) {
			throw new WCloudException(AccountUtil.ERR_CHECK_INPUTS);
		} else {
			response = new ResponseEntity<Map>(roleService.assignGroupToInvitedMembers(assignGroup), HttpStatus.OK);
		}
		LoggerUtil.logMessage(logger, " End assignGroupToInvitedMembers : POST");
		return response;
	}

	/** USER STORY -3 **/

	@RequestMapping(value = "/getAppliances", method = RequestMethod.GET)
	public ResponseEntity<List<Appliance>> getAppliances(@RequestParam("account_id") int accountId,
			@RequestParam("brand_id") int brandId) throws WCloudException {
		ResponseEntity<List<Appliance>> response = null;
		LoggerUtil.logMessage(logger, " getAppliances : GET");
		if (accountId == 0 || brandId == 0) {
			throw new WCloudException(AccountUtil.ERR_CHECK_INPUTS);
		} else {
			response = new ResponseEntity<List<Appliance>>(roleService.getAppliances(accountId, brandId),
					HttpStatus.OK);
		}
		return response;
	}

	/**
	 * USER STORY -4 : As a primary user, I should be able to invite another
	 * member to use my appliances specific to a location or multiple locations
	 **/
	@RequestMapping(value = "/invitation", method = RequestMethod.POST)
	public ResponseEntity<Map> sendInvitation(@RequestBody Invitation invitation) throws WCloudException {
		LoggerUtil.logMessage(logger, " sendInvitation : GET");
		ResponseEntity<Map> response = null;
		if (invitation.getAccountId() == 0 || invitation.getGroupId() == 0 || invitation.getLocationId() == 0) {
			throw new WCloudException(AccountUtil.ERR_CHECK_INPUTS);
		} else {
			response = new ResponseEntity<Map>(roleService.sendInvitation(invitation), HttpStatus.OK);
		}
		return response;
	}

}
