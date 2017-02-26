package com.whirlpool.wcloud.controller;


import java.net.UnknownHostException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.whirlpool.wcloud.app.BootApplication;
import com.whirlpool.wcloud.common.utils.LoggerUtil;
import com.whirlpool.wcloud.dao.MembersDao;
import com.whirlpool.wcloud.db.dashdb.model.Customer;
import com.whirlpool.wcloud.model.Account;
import com.whirlpool.wcloud.model.Members;



@RestController
@RequestMapping("/member")

public class MembersController {

static final Logger logger = Logger.getLogger(BootApplication.class);


	@Autowired
	private MembersDao membersDao;
	
	
	/**
	 * The method is GET all members for an account or a location. This will fetch list of accounts from data access layer and send back in response.
	 * @return
	 * 			List of members  in JSON in format
	 *	 * @throws UnknownHostException
	 */
	
	@RequestMapping(value = "/api/v4/accounts", method = RequestMethod.GET)
	public @ResponseBody List<Members> getMembers() throws UnknownHostException{
		
		//LoggerUtil.initMDC("WPTest100"); //TODO: set actual appliance id
		LoggerUtil.logMessage(logger, " MembersController : GET");
	
		return membersDao.getMembers();
	}
	
	
	
	
	/**
	 * The method is GET information about a member. This will fetch member details from data access layer and send back in response.
	 * @return
	 * 			Information about a member in JSON in format
	 *	 * @throws UnknownHostException
	 */
	
	@RequestMapping(value = "/api/v4/accounts/{id}", method = RequestMethod.GET)
	public ResponseEntity getMember(@PathVariable int id) throws UnknownHostException{

	LoggerUtil.logMessage(logger, "MembersController : GET ID");
		
		List list = membersDao.get(id);
				
		if (list.size() == 0) {
			LoggerUtil.logMessage(logger, "MembersController : GET ID returns: HttpStatus.NOT_FOUND ");
			return new ResponseEntity("No Member found for ID " + id, HttpStatus.NOT_FOUND);
		}
		
		LoggerUtil.logMessage(logger, "SampleRestController  : GET ID returns : HttpStatus.OK");
		return new ResponseEntity(list.get(0), HttpStatus.OK);
		
	}
	
	
	
	
	
	
	/**
	 * The method is GET information about a member based on location. This will fetch member details from data access layer and send back in response.
	 * @return
	 * 			Information about a member in JSON in format
	 *	 * @throws UnknownHostException
	 */
	
	@RequestMapping(value = "/api/v4/location/{location_id}", method = RequestMethod.GET)
	public ResponseEntity getAccounts(@PathVariable int location_id) throws UnknownHostException{

	LoggerUtil.logMessage(logger, "MembersController : GET location_id");
		
		List list = membersDao.get(location_id);
				
		if (list.size() == 0) {
			LoggerUtil.logMessage(logger, "MembersController : GET location_id returns: HttpStatus.NOT_FOUND ");
			return new ResponseEntity("No LOCATION found for LOCATION_ID " + location_id, HttpStatus.NOT_FOUND);
		}
		//TODO: implement business logic
		LoggerUtil.logMessage(logger, "SampleRestController  : GET location_id returns : HttpStatus.OK");
		return new ResponseEntity(list.get(0), HttpStatus.OK);
		
	}
	
	
	
	
	
	
	

	
	/**
	 * The method is to update a member. This will update the member details.
	 * @return
	 * 			Information about a member in JSON in format
	 *	 * @throws UnknownHostException
	 */
	
	
	@RequestMapping(value = "/api/v4/accounts/{id}/{firstName}/{lastName}/{email}/{phoneNumber}", method = RequestMethod.PUT)
	public ResponseEntity updateMember(@PathVariable int id,@PathVariable String firstName,@PathVariable String lastName,@PathVariable String email,@PathVariable long phoneNumber) {
		LoggerUtil.logMessage(logger, "MembersController : PUT");
	
		
		Members member = new Members();
		List<Members> updatemember = membersDao.get(id);
		if (updatemember == null) {
			logger.error("Unable to update. Member with id {} not found.");
			return new ResponseEntity("Unable to upate. Member with id " + id + " not found.", HttpStatus.NOT_FOUND);
    }
	
	member.setFirst_name(firstName);
	member.setLast_name(lastName);
	member.setEmail(email);
	member.setPhone_number(phoneNumber);
	
	System.out.println("Member VALUES............................" + member);
        
    membersDao.updateMember(member,id);
   	return new ResponseEntity( "Updated Success",HttpStatus.OK);
		
}
	
	
	
	
	
	/**
	 * The method is to delete a member. This will delete the member details.
	 * @return
	 * 			Information about a member in JSON in format
	 *	 * @throws UnknownHostException
	 */
	
	
	@RequestMapping(value = "/api/v4/accounts/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteMember(@PathVariable int id) {
	LoggerUtil.logMessage(logger, "MembersController : DELETE");
	
	
	List member = membersDao.get(id);
    if (member == null) {
    logger.error("Unable to delete. User with id {} not found.");
    return new ResponseEntity(("Unable to delete. User with id " + id + " not found."), HttpStatus.NOT_FOUND);
    }
    
	membersDao.deleteMember(id);
    LoggerUtil.logMessage(logger, "MembersController : DELETE returns HttpStatus.OK");
	return new ResponseEntity(id, HttpStatus.OK);

	}


	
	
	
	
	/**
	 * The method is Get information about the current member. This will fetch the information about the current member and send back in response.
	 * @return
	 * 			List of members  in JSON in format
	 *	 * @throws UnknownHostException
	 */

	@RequestMapping(value = "/api/v4/account", method = RequestMethod.GET)
	public ResponseEntity getMember(@RequestBody Members member) throws UnknownHostException {
		
		
		List<Members> currentMember = membersDao.getMember();
		//List list = membersDao.getMember(member);
       
       if (currentMember == null) {
			LoggerUtil.logMessage(logger, "MembersController : GET returns: HttpStatus.NOT_FOUND ");
			return new ResponseEntity("No Member found", HttpStatus.NOT_FOUND);
       }
              
       membersDao.getMember();
       
       LoggerUtil.logMessage(logger, "MembersController  : GET returns : HttpStatus.OK");
		//return new ResponseEntity(membersDao.getMember(), HttpStatus.OK);
       return (ResponseEntity) membersDao.getMember();
       
	}

	
	
	
	
	/**
	 * The method is to create a member. This will create the member details.
	 * @return
	 * 			Information about a member in JSON in format
	 *	 * @throws UnknownHostException
	 */

	
	@RequestMapping(value = "/api/v4/accounts", method = RequestMethod.POST)
	public ResponseEntity createMember(@RequestBody Members member) {
		LoggerUtil.logMessage(logger, "MembersController : POST");

		if (membersDao.isMembersExist(member)) {
			logger.error("Unable to create. A User with name {} already exist");
			return new ResponseEntity(("Unable to create. A User already exist."),HttpStatus.CONFLICT);
        }
		membersDao.createMember(member);
		
		LoggerUtil.logMessage(logger, "MembersController : POST : returns : HttpStatus.OK" );
		return new ResponseEntity("Success", HttpStatus.OK);
		
	}	
	
}

	
	
	



