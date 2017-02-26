package com.whirlpool.wcloud.controller;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whirlpool.wcloud.common.utils.LoggerUtil;
import com.whirlpool.wcloud.dao.AccountsDao;
import com.whirlpool.wcloud.exceptions.WCloudException;
import com.whirlpool.wcloud.model.Account;
import com.whirlpool.wcloud.model.AccountCreation;
import com.whirlpool.wcloud.model.Email;
import com.whirlpool.wcloud.model.PasswordValidation;

@RestController
@RequestMapping("/api")
public class AccountController {

	static final Logger logger = Logger.getLogger(AccountController.class);

	@Autowired
	private AccountsDao accountsDao;
	@Autowired
	private PasswordValidation validateObj;

	@RequestMapping(value = "/accounts", method = RequestMethod.GET)
	public @ResponseBody List<Account> getAccounts() throws UnknownHostException {

		LoggerUtil.logMessage(logger, " AccountController : GET");

		return accountsDao.getAccounts();
	}

	@RequestMapping(value = "/accounts", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity createAccount(@RequestBody AccountCreation account, @RequestHeader("Authorization") String token) throws WCloudException {

		LoggerUtil.logMessage(logger, "AccountController : POST");

		accountsDao.createAccount(account);
		sendEmail(token, account.getAccount().getUserAccount().getEmail());
		LoggerUtil.logMessage(logger, "AccountController : POST : returns : HttpStatus.OK");
		return new ResponseEntity(account, HttpStatus.OK);
	}

	@RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET)
	public ResponseEntity getAccount(@PathVariable int id) throws UnknownHostException {

		LoggerUtil.logMessage(logger, "AccountController : GET ID");

		List list = accountsDao.get(id);

		if (list.size() == 0) {
			LoggerUtil.logMessage(logger, "AccountController : GET ID returns: HttpStatus.NOT_FOUND ");
			return new ResponseEntity("No Account found for ID " + id, HttpStatus.NOT_FOUND);
		}
		LoggerUtil.logMessage(logger, "AccountController  : GET ID returns : HttpStatus.OK");
		return new ResponseEntity(list.get(0), HttpStatus.OK);

	}

	@RequestMapping(value = "/accounts/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteAccount(@PathVariable Long id) {

		LoggerUtil.logMessage(logger, "AccountController : DELETE");

		// TODO: Add business logic
		LoggerUtil.logMessage(logger, "AccountController : DELETE returns HttpStatus.OK");
		return new ResponseEntity(id, HttpStatus.OK);

	}

	@RequestMapping(value = "/accounts/{accountId}/{language}", method = RequestMethod.PUT)
	private ResponseEntity<String> update(@PathVariable("accountId") int accountId,
			@PathVariable("language") String language) {

		accountsDao.updateLanguagePref(accountId, language);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(value = "/accounts/logout/{accountId}", method = RequestMethod.POST)
	private ResponseEntity<String> logout(@PathVariable("accountId") int accountId) {

		accountsDao.logout(accountId);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(value = "/accounts/reset_password", method = RequestMethod.POST)
	public String resetPassword() {

		List Username = accountsDao.getusername();
		if (Username.isEmpty()) {
			LoggerUtil.logMessage(logger, "AccountController : POST : returns : HttpStatus.UNPROCESSABLE_ENTITY");
			// return new ResponseEntity(account,
			// HttpStatus.UNPROCESSABLE_ENTITY);
		} else if (accountsDao.getBrand() == null) {
			LoggerUtil.logMessage(logger, "AccountController : POST : returns : HttpStatus.UNPROCESSABLE_ENTITY");
			// return new ResponseEntity(account,
			// HttpStatus.UNPROCESSABLE_ENTITY);
		} else {
			// call Mail function to send the mail
		}

		LoggerUtil.logMessage(logger, " AccountController : GET");
		// call common email notification service here to send email
		return "password link sent";
	}

	@RequestMapping(value = "/accounts/update_password", method = RequestMethod.POST)
	public String validatenUpdatePassword() {

		String previouspassword = "Omakr123";

		if (!validateObj.validate(previouspassword)) {
			return "previouspassword Password Format error";
		}
		String currentpassword1 = "Omkr1213";
		String currentpassword2 = "Omkr";

		if (!(validateObj.validate(currentpassword1))) {
			return "currentpwd1 Password Format error";
		}
		if (!validateObj.validate(currentpassword2)) {
			return "currentpwd2 Password Format error";
		}
		if (!currentpassword1.contentEquals(currentpassword2)) {
			return "Current passwords doesnot match";
		}

		// UpdatePasswordMethod to be called

		return "password updated";
	}

	@RequestMapping(value = "/accounts/resend_confirmation", method = RequestMethod.GET)
	public ResponseEntity<Email> resendConfirmation(@RequestHeader("Authorization") String token) {

		Email result = sendEmail(token, "vishwanath_patil_syntel@whirlpool.com");

		return new ResponseEntity<Email>(result, HttpStatus.OK);
	}

	private Email sendEmail(String token, String sToEmail) {
		String tokenMod = token.replace("Bearer ", "");
		logger.info("Printing token " + tokenMod);
		//This can be better read from properties file
		final String uri = "http://localhost:8080/api/accounts/sendMailNotification/?access_token=" + tokenMod;

		RestTemplate restTemplate = new RestTemplate();
		Email email = new Email();
		email.setFrom("Test@localhost");
		email.setTo(sToEmail);
		email.setSubject("Confirmation Mail Subject");
		email.setBodyMessage("Confirmation Mail Body");
		ObjectMapper mapper = new ObjectMapper();
		
		Email result = new Email();
		try {
			logger.info(mapper.writeValueAsString(email));
			result = restTemplate.postForObject(uri, email, Email.class);
		} catch (HttpClientErrorException e) {

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value = "/accounts/confirm_email/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> verifyEmailAddress(@PathVariable("id") int id) {
		LoggerUtil.logMessage(logger, "AccountController : POST");

		int statusID;
		List list = accountsDao.get(id);

		if (list.size() == 0) {
			LoggerUtil.logMessage(logger, "AccountController : POST returns: HttpStatus.NOT_FOUND ");
			Map<String, String> result = new HashMap<String, String>();
			result.put("Message", "No account exist for given ID");
			return new ResponseEntity(result, HttpStatus.NOT_FOUND);
		} else {
			List durationChar = accountsDao.getEmailTimestamp(id);
			int duration = Integer.parseInt(durationChar.get(0).toString().split("=")[1].split("}")[0]);

			if (duration <= 120) {
				statusID = 1;
				accountsDao.updateStatus(id, statusID);
				Map<String, String> result = new HashMap<String, String>();
				result.put("Message", "Account verified.");
				LoggerUtil.logMessage(logger, "AccountController : POST : returns : HttpStatus.OK");
				return new ResponseEntity(result, HttpStatus.OK);
			} else {
				Map<String, String> result = new HashMap<String, String>();

				result.put("Message", "Confirmation mail Expired.");
				LoggerUtil.logMessage(logger, "AccountController : POST returns: HttpStatus.BAD_REQUEST ");
				return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
			}
		}
	}
}
