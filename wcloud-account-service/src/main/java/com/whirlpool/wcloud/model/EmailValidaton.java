package com.whirlpool.wcloud.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.whirlpool.wcloud.common.utils.LoggerUtil;
import com.whirlpool.wcloud.dao.AccountsDao;

public class EmailValidaton {
	static final Logger logger = Logger.getLogger(EmailValidaton.class);
	
	private Pattern pattern;
	private Matcher matcher;
	
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-+\\+]+(\\.[_A-Za-z0-9-+]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	@Autowired
	private AccountsDao accountsDao;


	public EmailValidaton() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	public boolean validate(final String hex) {

		matcher = pattern.matcher(hex);
		return matcher.matches();

	}

	public boolean emailvalidate(String email) {
		Pattern pattern;
		Matcher matcher;
		pattern = Pattern.compile(EMAIL_PATTERN);
		// String email ="san1@gmail.com.uk";
		matcher = pattern.matcher(email);
		boolean b = matcher.matches();
		System.out.println(b);
		return (b);

	}
}
