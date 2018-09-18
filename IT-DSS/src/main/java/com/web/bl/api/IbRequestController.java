package com.web.bl.api;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.bl.dao.IbRequestHome;
import com.web.bl.model.IbRequest;
import com.web.bl.wrapper.IbRequestWrapper;
import com.web.bl.wrapper.ResponseWrapper;

@RestController
public class IbRequestController {

	@Autowired
	private IbRequestHome ibRequestHome;
	
	@Autowired
	private HttpSession httpSession;
	
	@RequestMapping(value="submitIbRequest/", method=RequestMethod.POST)
	public ResponseEntity<ResponseWrapper> submitIbRequest(@RequestBody IbRequestWrapper ibRequestWrapper) {
		
		System.out.println(ibRequestWrapper);
		
		ibRequestWrapper.getIbRequest().setStatus("Approved");
		try {
			ibRequestWrapper.getIbRequest().setCreatedBy(httpSession.getAttribute("userName").toString());
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Unable to acquire Session Value.");
		}
		ibRequestWrapper.getIbRequest().setCreatedDate(new Date());
		try {
			ibRequestWrapper.getIbRequest().setUpdatedBy(httpSession.getAttribute("userName").toString());
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Unable to acquire Session Value.");
		}
		
		ibRequestWrapper.getIbRequest().setUpdatedDate(new Date());
		ResponseWrapper responseWrapper = new ResponseWrapper();
		
		try {
			for(String month : ibRequestWrapper.getMonths()) {
				ibRequestWrapper.getIbRequest().setMonth(month);
				ibRequestHome.persist(ibRequestWrapper.getIbRequest());
			}
			 // Need to open
			responseWrapper.setMessage("Successfully Data Saved.");
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
		}catch(Exception ex) {
			ex.printStackTrace();
			responseWrapper.setMessage("Error while saving data.");
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	
	@RequestMapping(value="updateIbRequest/", method=RequestMethod.POST)
	public ResponseEntity<ResponseWrapper> updateIbRequest(@RequestBody IbRequest ibRequest){
		
		ResponseWrapper responseWrapper = new ResponseWrapper();
		try {
		ibRequest.setUpdatedBy(httpSession.getAttribute("userName").toString());
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Unable to acquire Session Value.");
		}
		ibRequest.setUpdatedDate(new Date());
		
		System.out.println("IB Request:"+ ibRequest);
		ibRequestHome.merge(ibRequest); //need to open
		
		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
	}
}
