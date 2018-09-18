package com.web.bl.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.bl.wrapper.ApiPostWrapper;
import com.web.bl.wrapper.VerificationWrapper;

@RestController
public class TestController {

	
	@RequestMapping(value="/getCustomerInfo", method=RequestMethod.GET)
	public ResponseEntity<ApiPostWrapper> getCustomerInfo(){
		
		ApiPostWrapper apiPostWrapper = new ApiPostWrapper();
		apiPostWrapper.setMsisdn("1962424653");
		apiPostWrapper.setEmail_primary("reazul.haque@banglalink.net");
		apiPostWrapper.setEmail_secondary("reazul@banglalink.net");
		apiPostWrapper.setBillCycle("BG-31");
		apiPostWrapper.setProduct("BL_POSTPAID");
		apiPostWrapper.setMedia("BOS");
		apiPostWrapper.setCreatedBy("reazul.haque");
		apiPostWrapper.setInterestedForCourier("Yes");
		apiPostWrapper.setInterestedForEbill("Yes");
		
		return new ResponseEntity<ApiPostWrapper>(apiPostWrapper, HttpStatus.OK);
	}
	
	/*@RequestMapping(value="/confirmMail", method=RequestMethod.GET)
	public String confirmMail() {
		String test = "Thanks for confirmation.";
		
		System.out.println(test);
		
		return test;
	}*/
	
	@RequestMapping(value="getVerWrp", method=RequestMethod.GET)
	public ResponseEntity<VerificationWrapper> getVerWrp(){
		VerificationWrapper verificationWrapper = new VerificationWrapper();
		verificationWrapper.setIb_need("Yes");
		verificationWrapper.setClient("abcd");
		verificationWrapper.setMail("reaz@reaz.com");
		verificationWrapper.setMsisdn("8801962424653");
		
		return new ResponseEntity<VerificationWrapper>(verificationWrapper, HttpStatus.OK);
		}
}
