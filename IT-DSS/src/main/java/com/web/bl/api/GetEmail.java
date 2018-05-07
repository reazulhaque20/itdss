package com.web.bl.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.bl.dao.EmailsHome;
import com.web.bl.model.Emails;
import com.web.bl.model.UserEmail;
import com.web.bl.wrapper.UserEmailWrapper;

@RestController
public class GetEmail {

	@Autowired
	private EmailsHome emailsHome;
	
	@RequestMapping(value="/getDataFronDB", method=RequestMethod.GET)
	public ResponseEntity<Emails> getDataFronDB(){
		
		Emails emails = new Emails();
		
		try {
			emails = emailsHome.finfByMSISDN("1962424653");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		//EmailsId persist_EmailsID = new EmailsId();
		
		//persist_EmailsID.setMsisdn("1234");
		//persist_EmailsID.setEmail("test");
		
		Emails newEmails = new Emails();
		newEmails.setMsisdn("1962424653");
		newEmails.setBillcycle("1");
		//newEmails.setId(persist_EmailsID);
		try {
			emailsHome.persist(newEmails);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return new ResponseEntity<Emails>(emails, HttpStatus.OK);
	}
	
	/*@RequestMapping(value="/getEmail", method=RequestMethod.POST)
	public ResponseEntity<UserEmailWrapper> getEmail(@RequestBody UserEmailWrapper userEmailWrapper){
		
		
		
		return new ResponseEntity<UserEmailWrapper>(userEmailWrapper, HttpStatus.OK);
	}*/
	
	@RequestMapping(value="/setEmail", method=RequestMethod.GET)
	public ResponseEntity<UserEmailWrapper> setEmail(){
		
		UserEmail userEmail = new UserEmail();
		List<UserEmail> listUserEmail = new ArrayList<UserEmail>();
		
		userEmail.setEmail("reazul.haque@banglalink.net");
		userEmail.setBillCycle(5);
		userEmail.setChannel("POC");
		userEmail.setMsisdn("01962424653");
		userEmail.setProduct("Postpaid");
		listUserEmail.add(userEmail);
		
		userEmail = new UserEmail();
		userEmail.setBillCycle(2);
		userEmail.setChannel("BOS");
		userEmail.setMsisdn("01962424649");
		userEmail.setProduct("Postpaid");
		userEmail.setEmail("shakil.ahmed@banglalink.net");
		listUserEmail.add(userEmail);
		
		UserEmailWrapper userEmailWrapper = new UserEmailWrapper();
		
		userEmailWrapper.setListUserEmail(listUserEmail);
		
		return new ResponseEntity<UserEmailWrapper>(userEmailWrapper, HttpStatus.OK);
		
	}
}
