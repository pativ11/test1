package com.whirlpool.wcloud.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.whirlpool.wcloud.app.BootApplication;
import com.whirlpool.wcloud.common.utils.LoggerUtil;
import com.whirlpool.wcloud.dao.LocationDao;
import com.whirlpool.wcloud.exceptions.WCloudException;
import com.whirlpool.wcloud.model.Account;
import com.whirlpool.wcloud.model.LocationModel;
import com.whirlpool.wcloud.model.UpdateModel;


@RestController
@RequestMapping("/api")




public class LocationController {
	
static final Logger logger = Logger.getLogger(BootApplication.class);

@Autowired
private LocationDao locationDao;
	
	/**
	 * 
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/location/accounts", method = RequestMethod.POST)
	public ResponseEntity createlocationn(@RequestBody LocationModel location) {
		
		//LoggerUtil.initMDC("WPTest100"); //TODO: set actual appliance id
		LoggerUtil.logMessage(logger, "SampleRestController : POST"+location);

		//TODO: Add logic for new account
		
		locationDao.createLocation(location);

		LoggerUtil.logMessage(logger, "SampleRestController : POST : returns : HttpStatus.OK" );
		return new ResponseEntity(location, HttpStatus.OK);
	}

	
	
	/**
	 * 
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/location/updateAccounts", method = RequestMethod.PUT)
	public ResponseEntity updatelocation(@RequestBody LocationModel location) {
		
		//LoggerUtil.initMDC("WPTest100"); //TODO: set actual appliance id
		LoggerUtil.logMessage(logger, "SampleRestController : PUT");

		//TODO: Add logic for new account
		
		locationDao.updateLocation(location);

		LoggerUtil.logMessage(logger, "SampleRestController : PUT : returns : HttpStatus.OK" );
		return new ResponseEntity(location, HttpStatus.OK);
	}


/**
 * 
 * @param customer
 * @return
 */
@RequestMapping(value = "/location/getAccounts/{account_id}", method = RequestMethod.GET)
public ResponseEntity<List<LocationModel>> getlocation(@PathVariable("account_id") int accountId) throws WCloudException {
	
	LoggerUtil.logMessage(logger, "SampleRestController : GET");
	ResponseEntity<List<LocationModel>> response = null;
	

	if (accountId == 0) {
		throw new WCloudException();
	} else {
	
		response = new ResponseEntity<List<LocationModel>>(locationDao.getLocationByAccountId(accountId), HttpStatus.OK);

	LoggerUtil.logMessage(logger, "SampleRestController : GET : returns : HttpStatus.OK" );
	return response;
}

}


/**
 * 
 * @param customer
 * @return
 */
@RequestMapping(value = "/location/getLocation/{location_id}", method = RequestMethod.GET)
public ResponseEntity<List<LocationModel>> getlocationByLocId(@PathVariable("location_id") int locationId) throws WCloudException {
	
	LoggerUtil.logMessage(logger, "SampleRestController : GET");
	ResponseEntity<List<LocationModel>> response = null;
	

	if (locationId == 0) {
		throw new WCloudException();
	} else {
	
		response = new ResponseEntity<List<LocationModel>>(locationDao.getLocationByLocationId(locationId), HttpStatus.OK);

	LoggerUtil.logMessage(logger, "SampleRestController : GET : returns : HttpStatus.OK" );
	return response;
}

}

}


