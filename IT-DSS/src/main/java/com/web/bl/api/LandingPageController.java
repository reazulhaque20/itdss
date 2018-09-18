package com.web.bl.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.bl.dao.CustomersEmailAddressHome;
import com.web.bl.dao.IbRequestHome;
import com.web.bl.model.CustomersEmailAddress;
import com.web.bl.model.IbRequest;
import com.web.bl.wrapper.LandingPageWrapper;

@RestController
public class LandingPageController {

	@Autowired
	private IbRequestHome ibRequestHome;
	
	@Autowired
	private CustomersEmailAddressHome customersEmailAddressHome;
	
	
	@RequestMapping(value = "/getLandingData", method=RequestMethod.GET)
	public ResponseEntity<LandingPageWrapper> getLandingData() {
		
		LandingPageWrapper landingPageWrapper = new LandingPageWrapper();
		
		//IbRequest ibRequest = new IbRequest();
		List<IbRequest> listIB = new ArrayList<IbRequest>();
		//CustomersEmailAddress customersEmailAddress = new CustomersEmailAddress();
		List<CustomersEmailAddress> listCustomersEmailAddress = new ArrayList<CustomersEmailAddress>();
		
		/*ibRequest.setIbRequestId(BigDecimal.valueOf(10));
		ibRequest.setBillGroup("BG-31");
		ibRequest.setDeliveryCharge("FREE");
		ibRequest.setDeliveryType("EMAIL");
		ibRequest.setEmailAddress("test@test.com");
		ibRequest.setMonth("JUNE");
		ibRequest.setMsisdn("0000000000");
		ibRequest.setYear("2018");
		ibRequest.setStatus("Open");
		
		listIB.add(ibRequest);
		
		ibRequest.setIbRequestId(BigDecimal.valueOf(10));
		ibRequest.setBillGroup("BG-31");
		ibRequest.setDeliveryCharge("FREE");
		ibRequest.setDeliveryType("EMAIL");
		ibRequest.setEmailAddress("test@test.com");
		ibRequest.setMonth("JUNE");
		ibRequest.setMsisdn("0000000000");
		ibRequest.setYear("2018");
		ibRequest.setStatus("Open");
		
		listIB.add(ibRequest);*/
		
		listIB = ibRequestHome.findAllOpenIbRequest(); // Need to open
		
		landingPageWrapper.setListIbRequest(listIB);
		
		/*customersEmailAddress.setEmailAddress("Test@TEST.COM");
		customersEmailAddress.setSecondEmailAddress("test2@test2.com");
		customersEmailAddress.setCeaId(BigDecimal.valueOf(12));
		
		listCustomersEmailAddress.add(customersEmailAddress);*/
		
		try {
			listCustomersEmailAddress = customersEmailAddressHome.findAllOpenStatusResuest();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		landingPageWrapper.setListCustomerEmailAddress(listCustomersEmailAddress);
		
		return new ResponseEntity<LandingPageWrapper>(landingPageWrapper, HttpStatus.OK);
	}
}
