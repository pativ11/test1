/**
 * 
 */
package com.whirlpool.wcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.whirlpool.wcloud.model.Email;

/**
 * @author AH33812
 *
 */
@RestController
@RequestMapping("/api")
public class EmailController {

	@Autowired
	private JavaMailSender javaMailSender;

	@RequestMapping(value = "/accounts/sendMailNotification", method = RequestMethod.POST, produces = {
			"application/json" })
	public ResponseEntity<Email> sendSimpleMail(@RequestBody Email email) {
		try {
			System.out.println("Inside Email controller : with email id : " + email.getTo());
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(email.getFrom());
			message.setTo(email.getTo());
			message.setSubject(email.getSubject());
			message.setText(email.getBodyMessage());
			javaMailSender.send(message);
			email.setStatus(true);
			return new ResponseEntity<Email>(email, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Email>(email, HttpStatus.NO_CONTENT);
		}

	}
}
