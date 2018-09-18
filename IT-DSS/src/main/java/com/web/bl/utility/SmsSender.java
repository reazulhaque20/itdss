package com.web.bl.utility;

import org.springframework.web.client.RestTemplate;

public class SmsSender {

	
	public void sendSMS(String message, String toNumber) {
		String response = "";
		//message = "Test SMS";
		//toNumber = "8801962424653";
		
		String url = "http://10.10.31.115/kannel/sendSms/serviceLA3434.php?message="+message+"&msisdn="+toNumber+"&raddr=Banglalink&app=Email Verification";
		
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			response = restTemplate.getForObject(url, String.class);
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Failed to send SMS."+ response);
		}
		
	}
}
