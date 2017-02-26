package com.whirlpool.wcloud.controller;

import java.net.UnknownHostException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.whirlpool.wcloud.app.BootApplication;
import com.whirlpool.wcloud.common.utils.LoggerUtil;
import com.whirlpool.wcloud.controllers.BaseController;
import com.whirlpool.wcloud.dao.AccountsDao;
import com.whirlpool.wcloud.db.dashdb.model.Customer;
import com.whirlpool.wcloud.model.Account;
import org.springframework.web.servlet.handler.*;



/**
 * This is sample RestController written as a reference. This can be used by WCloud developers as reference to build their micro services.
 * 
 * @author Syntel
 * @since 18-Jan-2017
 */

@RestController
@RequestMapping("/api/sample")

public class SampleRestController  {
/*
	static final Logger logger = Logger.getLogger(BootApplication.class);

	@Autowired
	private AccountsDao accountsDao;
	
	
	*//**
	 * The method is GET end point for Sample service. This will fetch list of accounts from data access layer and send back in response.
	 * @return
	 * 			List of accounts  in JSON in format
	 *	 * @throws UnknownHostException
	 *//*
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody List<Account> getAccounts() throws UnknownHostException{
		
		//LoggerUtil.initMDC("WPTest100"); //TODO: set actual appliance id
		LoggerUtil.logMessage(logger, " SampleRestController : GET");
	
		return accountsDao.getAccounts();
		
	}
	*//**
	 * 
	 * @param id
	 * @return
	 * @throws UnknownHostException
	 *//*
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity getAccount(@PathVariable int id) throws UnknownHostException{

		//LoggerUtil.initMDC("WPTest100"); //TODO: set actual appliance id
		LoggerUtil.logMessage(logger, "SampleRestController : GET ID");
		
		List list = accountsDao.get(id);
				
		//Customer customer = customerDao.get(new Integer(id));
		
		if (list.size() == 0) {
			LoggerUtil.logMessage(logger, "SampleRestController : GET ID returns: HttpStatus.NOT_FOUND ");
			return new ResponseEntity("No Account found for ID " + id, HttpStatus.NOT_FOUND);
		}
		//TODO: implement business logic
		LoggerUtil.logMessage(logger, "SampleRestController  : GET ID returns : HttpStatus.OK");
		return new ResponseEntity(list.get(0), HttpStatus.OK);
		
	}

	*//**
	 * 
	 * @param customer
	 * @return
	 *//*
	@RequestMapping(value = "/accounts", method = RequestMethod.POST)
	public ResponseEntity createAccount(@RequestBody Account account) {

		//LoggerUtil.initMDC("WPTest100"); //TODO: set actual appliance id
		LoggerUtil.logMessage(logger, "SampleRestController : POST");

		//TODO: Add logic for new account

		LoggerUtil.logMessage(logger, "SampleRestController : POST : returns : HttpStatus.OK" );
		return new ResponseEntity(account, HttpStatus.OK);
	}

	
	
	*//**
	 * @param id
	 * @return
	 *//*
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteAccount(@PathVariable Long id) {

		//LoggerUtil.initMDC("WPTest100"); //TODO: set actual appliance id
		LoggerUtil.logMessage(logger, "SampleRestController : DELETE");
	
		//TODO: Add business logic
		LoggerUtil.logMessage(logger, "SampleRestController : DELETE returns HttpStatus.OK");
		return new ResponseEntity(id, HttpStatus.OK);

	}

	*//**
	 * 
	 * @param id
	 * @param customer
	 * @return
	 *//*
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {

	//TODO: please add business logic for update
		//LoggerUtil.initMDC("WPTest100"); //TODO: set actual appliance id
		LoggerUtil.logMessage(logger, "SampleRestController : PUT");
	
		return new ResponseEntity(customer, HttpStatus.OK);
	}*/

}

