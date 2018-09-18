package com.web.bl.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.bl.dao.CustomersEmailAddressHome;
import com.web.bl.dao.CustomersHome;
import com.web.bl.model.Customers;
import com.web.bl.model.CustomersEmailAddress;

import com.web.bl.utility.MailSender;

@Component("verificationMailSender")
public class VerificationMailSender {

	@Autowired
	private CustomersEmailAddressHome customersEmailAddressHome;

	@Autowired
	private CustomersHome customersHome;
	
	public void sendVerificationMail() {
		System.out.println("Send Verification Mail Method");
		System.out.println("Running From Schedular.");
//		String mailBody = "";
//		Integer success = 0;
		List<String> emailAddress = new ArrayList<String>();
		List<String> duplicateEmailAddress = new ArrayList<String>();
//		List<String> uniqueEmailAddress = new ArrayList<String>();
		Set<String> hs = new HashSet<String>();
		try {
			List<CustomersEmailAddress> listCustomersEmailAddress = customersEmailAddressHome.findAllNotVerifiedCustomers();
			
			for(CustomersEmailAddress c : listCustomersEmailAddress) {
				emailAddress.add(c.getEmailAddress());
			}
			duplicateEmailAddress.addAll( emailAddress );
			hs.addAll(emailAddress);
			emailAddress.clear();
			emailAddress.addAll(hs);
			
			for(int i = 0; i<emailAddress.size(); i++) {
				if(!listCustomersEmailAddress.isEmpty()) {
					for(String email : emailAddress) {
						int frequency = Collections.frequency(duplicateEmailAddress, email);
						
						if(frequency == 1) {
							sendNonCorporateEmail(email);
						}
						else if(frequency > 1) {
							sendCorporateEmail(email);
						}
					}
				}
			}
			
			
			/*if(!listCustomersEmailAddress.isEmpty()) {
				for(CustomersEmailAddress customersEmailAddress : listCustomersEmailAddress) {
					try {
						MailSender.getInstance().sendMail(customersEmailAddress.getEmailAddress(), "Banglalink Email Verification", mailBody);
						success = 1;
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					
					try {
						SmsSender smsSender = new SmsSender();
						String number = "880" + customersEmailAddress.getCustomers().getMsisdn();
						smsSender.sendSMS("Test SMS", number);
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					
					if(success == 1) {
						if(customersEmailAddress.getVerificationEmail1st() == null) {
							customersEmailAddress.setVerificationEmail1st("YES");
							customersEmailAddress.setVerifEmail1stDate(new Date());
						}
						else if(customersEmailAddress.getVerificationEmail2nd() == null) {
							customersEmailAddress.setVerificationEmail2nd("YES");
							customersEmailAddress.setVerifEmail2ndDate(new Date());
						}
						else if(customersEmailAddress.getVerificationEmail3rd() == null) {
							customersEmailAddress.setVerificationEmail3rd("Yes");
							customersEmailAddress.setVerifEmail3rdDate(new Date());
						}
						
						try {
							customersEmailAddressHome.merge(customersEmailAddress);
						}catch(Exception ex) {
							ex.printStackTrace();
						}
					}
				}
			}*/
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error.");
		}
	}
	
	public void sendNonCorporateEmail(String emailAddress) {
//		send mail activity
		CustomersEmailAddress customersEmailAddress = null;// = new CustomersEmailAddress();
		int success = 0;
		String msg_1 ="<div style=\"width: 100%\"><img style=\"width: 100%; height: 40%; \" src=\"https://www.banglalink.net/sites/default/files/4G-%20Slide%202_0%281%29.jpg\" alt=\"BL_4G\"/></div>\r\n" + 
				"<div stype=\"background-color: #fcfdeb\";\">\r\n" + 
				"<p>Dear Valued Customer,</p>\r\n" + 
				"<p>Please click on below button to verify your email address.</p>\r\n" + 
				"<button style=\"background-color: #4CAF50; border: none; color: white; round: 3px 3px; padding: 15px 32px; text-align: center; text-decoration: none; display: inline-block; font-size: 16px; margin: 4px 2px; cursor: pointer;\"><a style=\"text-decoration: none !important; decoration:none; \" href=\"";
		String msg_2 = "\">Verify</a></button>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<div style=\"position: fixed;left: 0;bottom: 0; width: 100%;height: 10%;background-color: #f26f23;color: white;text-align: center;\">© 2018 Banglalink (Banglalink Digital Communications Ltd.)</div>";
		String link = "https://blbs.banglalink.net:8443/IT-DSS/confirmMail";
		try {
			customersEmailAddress = customersEmailAddressHome.findByEmailAddress(emailAddress);
			String l = "?client="+customersEmailAddress.getCustomers().getCustomerSecret()+"&mail="+customersEmailAddress.getEmailAddress();
			String final_link = link + l;
			String final_msg = msg_1 + final_link + msg_2;
			if(customersEmailAddress != null) {
				try {
					MailSender.getInstance().sendMail(customersEmailAddress.getEmailAddress(), "Banglalink Email Verification", final_msg);
					success = 1;
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
				if(customersEmailAddress.getCustomers().getFlag1() != null) {
					try {
						SmsSender smsSender = new SmsSender();
						String number = "880" + customersEmailAddress.getCustomers().getMsisdn();
						smsSender.sendSMS("Dear Valued Customer,\r\n" + 
								"Thank you for registering your email address. Please verify your email address via verification email send to your email address. \r\n" + 
								"", number);
						Customers customers = customersEmailAddress.getCustomers();
						customers.setFlag1("YES");
						customersHome.merge(customers);
					}catch(Exception ex) {
						ex.printStackTrace();
					}
				}
				if(success == 1) {
					if(customersEmailAddress.getVerificationEmail1st() == null) {
						customersEmailAddress.setVerificationEmail1st("YES");
						customersEmailAddress.setVerifEmail1stDate(new Date());
						SmsSender smsSender = new SmsSender();
						String number = "880" + customersEmailAddress.getCustomers().getMsisdn();
						smsSender.sendSMS("Dear Valued Customer,\r\n" + 
								"This is to remind you that, you are yet to verify your email address"+ customersEmailAddress.getEmailAddress() +"for e bill service. Please verify your email address.\r\n" + 
								"", number);
					}
					else if(customersEmailAddress.getVerificationEmail2nd() == null) {
						customersEmailAddress.setVerificationEmail2nd("YES");
						customersEmailAddress.setVerifEmail2ndDate(new Date());
						SmsSender smsSender = new SmsSender();
						String number = "880" + customersEmailAddress.getCustomers().getMsisdn();
						smsSender.sendSMS("Dear Valued Customer,\r\n" + 
								"This is to remind you that, you are yet to verify your email address"+ customersEmailAddress.getEmailAddress() +"for e bill service. Please verify your email address.\r\n" + 
								"", number);
					}
					else if(customersEmailAddress.getVerificationEmail3rd() == null) {
						customersEmailAddress.setVerificationEmail3rd("Yes");
						customersEmailAddress.setVerifEmail3rdDate(new Date());
						SmsSender smsSender = new SmsSender();
						String number = "880" + customersEmailAddress.getCustomers().getMsisdn();
						smsSender.sendSMS("Dear Valued Customer,\r\n" + 
								"This is to remind you that, you are yet to verify your email address"+ customersEmailAddress.getEmailAddress() +"for e bill service. Please verify your email address.\r\n" + 
								"", number);
					}
					
					try {
						customersEmailAddressHome.merge(customersEmailAddress);
					}catch(Exception ex) {
						ex.printStackTrace();
						System.out.println("Error while sending Non Corporate Email.");
					}
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void sendCorporateEmail(String emailAddress) {
//		send corporate email activity
		List<CustomersEmailAddress> listCustomersEmailAddress = null;
		CustomersEmailAddress kam = new CustomersEmailAddress();
		List<String> listMsisdn = new ArrayList<String>();
		int success = 0;
		String msg_1 ="<div style=\"width: 100%\"><img style=\"width: 100%; height: 40%; \" src=\"https://www.banglalink.net/sites/default/files/4G-%20Slide%202_0%281%29.jpg\" alt=\"BL_4G\"/></div>\r\n" + 
				"<div stype=\"background-color: #fcfdeb\";\">\r\n" + 
				"<p>Dear Valued Customer,</p>\r\n" + 
				"<p>Please click on below button to verify your email address.</p>\r\n" + 
				"<button style=\"background-color: #4CAF50; border: none; color: white; round: 3px 3px; padding: 15px 32px; text-align: center; text-decoration: none; display: inline-block; font-size: 16px; margin: 4px 2px; cursor: pointer;\"><a style=\"text-decoration: none !important; decoration:none; \" href=\"";
		String msg_2 = "\">Verify</a></button>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<div style=\"position: fixed;left: 0;bottom: 0; width: 100%;height: 10%;background-color: #f26f23;color: white;text-align: center;\">© 2018 Banglalink (Banglalink Digital Communications Ltd.)</div>";
		String link = "https://blbs.banglalink.net:8443/IT-DSS/confirmMail";
		try {
			listCustomersEmailAddress = customersEmailAddressHome.findByListEmailAddress(emailAddress);
			
			if(!listCustomersEmailAddress.isEmpty()) {
				for(CustomersEmailAddress cea : listCustomersEmailAddress) {
					listMsisdn.add(cea.getCustomers().getMsisdn());
					if(cea.getCustomers().getKam() != null && cea.getCustomers().getKam() != "" && cea.getCustomers().getKam() != " " && cea.getCustomers().getKam() != "null") {
						kam = cea; // Found KAM Information. Need
					}
				}
				try {
					String l = "?client="+kam.getCustomers().getCustomerSecret()+"&mail="+kam.getEmailAddress();
					String final_link = link + l;
					String final_msg = msg_1 + final_link + msg_2;
					MailSender.getInstance().sendMail(kam.getEmailAddress(), "Banglalink Email Verification", final_msg);
					success = 1;
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				if(kam.getCustomers().getFlag1() != null) {
					try {
						SmsSender smsSender = new SmsSender();
						String number = "880" + kam.getCustomers().getMsisdn();
						smsSender.sendSMS("Dear Valued Customer,\r\n" + 
								"Thank you for registering your email address. Please verify your email address via verification email send to your email address. \r\n" + 
								"", number);
						Customers customers = kam.getCustomers();
						customers.setFlag1("YES");
						customersHome.merge(customers);
					}catch(Exception ex) {
						ex.printStackTrace();
					}
				}
				if(success == 1) {
					if(kam.getVerificationEmail1st() == null) {
						kam.setVerificationEmail1st("YES");
						kam.setVerifEmail1stDate(new Date());
						SmsSender smsSender = new SmsSender();
						String number = "880" + kam.getCustomers().getMsisdn();
						smsSender.sendSMS("Dear Valued Customer,\r\n" + 
								"This is to remind you that, you are yet to verify your email address"+ kam.getEmailAddress() +"for e bill service. Please verify your email address.\r\n" + 
								"", number);
					}
					else if(kam.getVerificationEmail2nd() == null) {
						kam.setVerificationEmail2nd("YES");
						kam.setVerifEmail2ndDate(new Date());
						SmsSender smsSender = new SmsSender();
						String number = "880" + kam.getCustomers().getMsisdn();
						smsSender.sendSMS("Dear Valued Customer,\r\n" + 
								"This is to remind you that, you are yet to verify your email address"+ kam.getEmailAddress() +"for e bill service. Please verify your email address.\r\n" + 
								"", number);
					}
					else if(kam.getVerificationEmail3rd() == null) {
						kam.setVerificationEmail3rd("Yes");
						kam.setVerifEmail3rdDate(new Date());
						SmsSender smsSender = new SmsSender();
						String number = "880" + kam.getCustomers().getMsisdn();
						smsSender.sendSMS("Dear Valued Customer,\r\n" + 
								"This is to remind you that, you are yet to verify your email address"+ kam.getEmailAddress() +"for e bill service. Please verify your email address.\r\n" + 
								"", number);
					}
					
					try {
						customersEmailAddressHome.merge(kam);
					}catch(Exception ex) {
						ex.printStackTrace();
						System.out.println("Error while sending Non Corporate Email.");
					}
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error while sending Corporate Email.");
		}
	}
}
