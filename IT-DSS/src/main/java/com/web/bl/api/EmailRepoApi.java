package com.web.bl.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.web.bl.dao.CustomersEmailAddressHome;
import com.web.bl.model.CustomersEmailAddress;
import com.web.bl.utility.MailSender;
import com.web.bl.wrapper.CustomCustomersEmailAddressWrapper;

@RestController
public class EmailRepoApi {
	
	@Autowired
	private CustomersEmailAddressHome customersEmailAddressHome;
	
	
	@RequestMapping(value="/getEmail", method=RequestMethod.GET)
	public ResponseEntity<CustomCustomersEmailAddressWrapper> getEmail(@RequestParam(value="msisdn", required=true) String msisdn) {
		
		//RestTemplate restTemplate = new RestTemplate();
		//ResponseWrapper responseWrapper = new ResponseWrapper();
		CustomCustomersEmailAddressWrapper customCustomersEmailAddressWrapper = new CustomCustomersEmailAddressWrapper();
		//Integer customerID = 0;
		//Customers customers = null;
		CustomersEmailAddress customersEmailAddress = null;
		
		//UserEmailWrapper userEmailWrapper = restTemplate.getForObject("http://localhost:8080/IT-DSS/setEmail", UserEmailWrapper.class);
		
		try {
			
			//MailSender.getInstance().sendMail("reazul.haque@banglalink.net", "Test Mail", "Its a test mail. Thanks");
			
			customersEmailAddress = customersEmailAddressHome.findByMSISDN(msisdn);
			
			if(customersEmailAddress != null) {
				customCustomersEmailAddressWrapper.setCustomersEmailAddress(customersEmailAddress);
				customCustomersEmailAddressWrapper.setMessage("Success");
				return new ResponseEntity<CustomCustomersEmailAddressWrapper>(customCustomersEmailAddressWrapper, HttpStatus.OK);
			}
			else {
				customCustomersEmailAddressWrapper.setMessage("No Result Found For MSISDN:"+msisdn);
				return new ResponseEntity<CustomCustomersEmailAddressWrapper>(customCustomersEmailAddressWrapper, HttpStatus.EXPECTATION_FAILED);
			}
		}catch(Exception ex) {
			//ex.printStackTrace();
			customCustomersEmailAddressWrapper.setMessage("Unexpexted Error Occured.");
			return new ResponseEntity<CustomCustomersEmailAddressWrapper>(customCustomersEmailAddressWrapper, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@RequestMapping(value="/sendVerificationMail", method=RequestMethod.GET)
	public void sendVerificationMail() {
		
		String body="<html>\r\n" + 
				"    <head>\r\n" + 
				"    </head>\r\n" + 
				"    <body>\r\n" + 
				"        <div> <button><a href=\"http://172.16.234.39:8080/IT-DSS/confirmMail\">Confirm</a></button> </div>\r\n" + 
				"    </body>\r\n" + 
				"</html>";
		
		MailSender.getInstance().sendMail("reazul.haque@banglalink.net", "Confirmation Mail", body);
		
	}
	
	@RequestMapping(value="/confirmMail", method=RequestMethod.GET)
	public String confirmMail() {
		String test = "Thanks for confirmation.";
		
		System.out.println(test);
		
		return test;
	}

}
