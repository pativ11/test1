package com.whirlpool.wcloud.model;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ComponentScan(basePackages = { "com.whirlpool.wcloud" })
public class PasswordValidation {


	
	  static  String PASSWORD_PATTERN =
	              "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,60})";

	// .* matches any character from whole string 

	  
	 public boolean pwdvalidation(String password)
	 {
	 
	 Pattern pattern;
	 Matcher matcher;
	 pattern = Pattern.compile(PASSWORD_PATTERN);
	 
	
	// String   password ="1234@lfC";
	 matcher = pattern.matcher(password);
	 boolean b = matcher.matches();
	 System.out.println(b);
	 return(b);
	 
	 }
	 
	 /**
	 * Validate password with regular expression
	 * @param password password for validation
	  * @return 
	 * @return true valid password, false invalid password
	 */
	 	public boolean validate (String password){
	 		String PASSWORD_PATTERN ="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,60})";
	 		Pattern pattern;
	 		Matcher matcher;
	 		pattern = Pattern.compile(PASSWORD_PATTERN);


	 		//String   password ="Omkar@99";
	 		matcher = pattern.matcher(password);
	 		boolean b = matcher.matches();
	 		System.out.println(b);
	 		return b;

	 	}	 
	 

}
