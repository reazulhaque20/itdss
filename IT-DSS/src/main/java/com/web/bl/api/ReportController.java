package com.web.bl.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.bl.dao.CustomersEmailAddressHome;
import com.web.bl.dao.IbRequestHome;
import com.web.bl.dao.UploadpodHome;
import com.web.bl.model.CustomersEmailAddress;
import com.web.bl.model.IbRequest;
import com.web.bl.model.Uploadpod;
import com.web.bl.wrapper.EmailAddressReportWrapper;
import com.web.bl.wrapper.IbReportWraper;
import com.web.bl.wrapper.PodReportWrapper;

@RestController
public class ReportController {

	@Autowired
	private IbRequestHome ibRequestHome;
	
	@Autowired
	private UploadpodHome uploadpodHome;
	
	@Autowired
	private CustomersEmailAddressHome customersEmailAddressHome;
	
	@RequestMapping(value="/ibReport/{startDate}/{endDate}/{msisdn}/{status}", method=RequestMethod.GET)
	public ResponseEntity<IbReportWraper> ibReport(@PathVariable("startDate") Date startDate, @PathVariable("endDate") Date endDate, @PathVariable("msisdn") String msisdn, @PathVariable("status") String status) {
		
		IbReportWraper ibReportWraper = new IbReportWraper();
		List<IbRequest> ibRequests = new ArrayList<IbRequest>();
		if(startDate == null) {
			ibReportWraper.setMessage("Start Date is blank.");
		}
		if(endDate == null) {
			ibReportWraper.setMessage("End Date is blank.");
		}
		/*if(msisdn == null || msisdn == "") {
			responseWrapper.setMessage("MSISDN is blank.");
		}
		if(status == null || status == "") {
			responseWrapper.setMessage("Status is blank.");
		}*/
		
		if(status.equalsIgnoreCase("null")) {
			status = null;
		}
		if(msisdn.equalsIgnoreCase("null")) {
			msisdn = null;
		}
		
		if(msisdn != null && status == null) {
			ibRequests = ibRequestHome.findByDateRangeandMsisdn(startDate, endDate, msisdn);
			if(!ibRequests.isEmpty()) {
				ibReportWraper.setIbRequestList(ibRequests);
				
				return new ResponseEntity<IbReportWraper>(ibReportWraper, HttpStatus.OK);
			}else {
				return new ResponseEntity<IbReportWraper>(ibReportWraper, HttpStatus.EXPECTATION_FAILED);
			}
		}else if(status != null && msisdn == null) {
			ibRequests = ibRequestHome.findByDateRangeAndStatus(startDate, endDate, status);
			if(!ibRequests.isEmpty()) {
				ibReportWraper.setIbRequestList(ibRequests);
				
				return new ResponseEntity<IbReportWraper>(ibReportWraper, HttpStatus.OK);
			}else {
				return new ResponseEntity<IbReportWraper>(ibReportWraper, HttpStatus.EXPECTATION_FAILED);
			}
		}else if(msisdn != null && status != null) {
			ibRequests = ibRequestHome.findByDatRangeAndMsisdnAndStatus(startDate, endDate, msisdn, status);
			if(!ibRequests.isEmpty()) {
				ibReportWraper.setIbRequestList(ibRequests);
				
				return new ResponseEntity<IbReportWraper>(ibReportWraper, HttpStatus.OK);
			}else {
				return new ResponseEntity<IbReportWraper>(ibReportWraper, HttpStatus.EXPECTATION_FAILED);
			}
		}else if(msisdn == null && status == null) {
			ibRequests = ibRequestHome.findByDateRange(startDate, endDate);
			if(!ibRequests.isEmpty()) {
				ibReportWraper.setIbRequestList(ibRequests);
				
				return new ResponseEntity<IbReportWraper>(ibReportWraper, HttpStatus.OK);
			}else {
				return new ResponseEntity<IbReportWraper>(ibReportWraper, HttpStatus.EXPECTATION_FAILED);
			}
		}
		
		ibReportWraper.setIbRequestList(ibRequests);
		
		return new ResponseEntity<IbReportWraper>(ibReportWraper, HttpStatus.OK);
	}
	
	@RequestMapping(value="/podReport/{msisdn}", method=RequestMethod.GET)
	public ResponseEntity<PodReportWrapper> podReport(@PathVariable("msisdn") String msisdn){
		PodReportWrapper podReportWrapper = new PodReportWrapper();
		List<Uploadpod> uploadpods = new ArrayList<Uploadpod>();
		try {
			uploadpods = uploadpodHome.findByMsisdn(msisdn);
			
			if(!uploadpods.isEmpty()) {
				podReportWrapper.setListuploadpod(uploadpods);
			}else {
				return new ResponseEntity<PodReportWrapper>(podReportWrapper, HttpStatus.EXPECTATION_FAILED);
			}
			return new ResponseEntity<PodReportWrapper>(podReportWrapper, HttpStatus.OK);
		}catch(Exception ex) {
			ex.printStackTrace();
			String message = "Error";
			podReportWrapper.setMessage(message);
			return new ResponseEntity<PodReportWrapper>(podReportWrapper, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	
	@RequestMapping(value="/emailAddressReport/{startDate}/{endDate}/{msisdn}/{emailAddress}/{isVerified}", method=RequestMethod.GET)
	public ResponseEntity<EmailAddressReportWrapper> emailAddressReport(@PathVariable("startDate") Date startDate, @PathVariable("endDate") Date endDate, @PathVariable("msisdn") String msisdn, @PathVariable("emailAddress") String emailAddress, @PathVariable("isVerified") String isVerified){
		EmailAddressReportWrapper emailAddressReportWrapper = new EmailAddressReportWrapper();
		List<CustomersEmailAddress> customersEmailAddresses = new ArrayList<CustomersEmailAddress>();
		
		if(msisdn.equalsIgnoreCase("null")) {
			msisdn = null;
		}
		if(emailAddress.equalsIgnoreCase("null")) {
			emailAddress = null;
		}
		if(isVerified.equalsIgnoreCase("null")) {
			isVerified = null;
		}
		
		if(msisdn != null && emailAddress == null && isVerified == null) {
			try {
				customersEmailAddresses = customersEmailAddressHome.findByDateRangeAndMsisdn(startDate, endDate, msisdn);
				
				if(!customersEmailAddresses.isEmpty()) {
					emailAddressReportWrapper.setListCustomersEmailAddress(customersEmailAddresses);
				}else {
					return new ResponseEntity<EmailAddressReportWrapper>(emailAddressReportWrapper, HttpStatus.EXPECTATION_FAILED);
				}
				return new ResponseEntity<EmailAddressReportWrapper>(emailAddressReportWrapper, HttpStatus.OK);
			}catch(Exception ex) {
				ex.printStackTrace();
				return new ResponseEntity<EmailAddressReportWrapper>(emailAddressReportWrapper, HttpStatus.EXPECTATION_FAILED);
			}
		}
		else if(msisdn == null && emailAddress != null && isVerified == null) {
			try {
				customersEmailAddresses = customersEmailAddressHome.findByDateRangeAndEmailAddress(startDate, endDate, emailAddress);
				
				if(!customersEmailAddresses.isEmpty()) {
					emailAddressReportWrapper.setListCustomersEmailAddress(customersEmailAddresses);
				}else {
					return new ResponseEntity<EmailAddressReportWrapper>(emailAddressReportWrapper, HttpStatus.EXPECTATION_FAILED);
				}
				return new ResponseEntity<EmailAddressReportWrapper>(emailAddressReportWrapper, HttpStatus.OK);
			}catch(Exception ex) {
				ex.printStackTrace();
				return new ResponseEntity<EmailAddressReportWrapper>(emailAddressReportWrapper, HttpStatus.EXPECTATION_FAILED);
			}
		}
		else if(msisdn == null && emailAddress == null && isVerified == null) {
			try {
				customersEmailAddresses = customersEmailAddressHome.findByDateRange(startDate, endDate);
				
				if(!customersEmailAddresses.isEmpty()) {
					emailAddressReportWrapper.setListCustomersEmailAddress(customersEmailAddresses);
				}else {
					return new ResponseEntity<EmailAddressReportWrapper>(emailAddressReportWrapper, HttpStatus.EXPECTATION_FAILED);
				}
				return new ResponseEntity<EmailAddressReportWrapper>(emailAddressReportWrapper, HttpStatus.OK);
			}catch(Exception ex) {
				ex.printStackTrace();
				return new ResponseEntity<EmailAddressReportWrapper>(emailAddressReportWrapper, HttpStatus.EXPECTATION_FAILED);
			}
		}
		else if(msisdn == null && emailAddress == null && isVerified != null) {
			try {
				customersEmailAddresses = customersEmailAddressHome.findByDateRangeAndVerificationStatus(startDate, endDate, isVerified);
				
				if(!customersEmailAddresses.isEmpty()) {
					emailAddressReportWrapper.setListCustomersEmailAddress(customersEmailAddresses);
				}else {
					return new ResponseEntity<EmailAddressReportWrapper>(emailAddressReportWrapper, HttpStatus.EXPECTATION_FAILED);
				}
				return new ResponseEntity<EmailAddressReportWrapper>(emailAddressReportWrapper, HttpStatus.OK);
			}catch(Exception ex) {
				ex.printStackTrace();
				return new ResponseEntity<EmailAddressReportWrapper>(emailAddressReportWrapper, HttpStatus.EXPECTATION_FAILED);
			}
		}
		emailAddressReportWrapper.setMessage("Error");
		return new ResponseEntity<EmailAddressReportWrapper>(emailAddressReportWrapper, HttpStatus.EXPECTATION_FAILED);
	}
}
