package com.web.bl.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.bl.dao.CustomersEmailAddressHome;
import com.web.bl.dao.UsergrouppageaccessHome;
import com.web.bl.model.CustomersEmailAddress;
import com.web.bl.model.Userandusergroupmap;
import com.web.bl.model.Usergrouppageaccess;
import com.web.bl.utility.Validator;


@Controller
public class HomeController {
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private UsergrouppageaccessHome usergrouppageaccessHome;
	
	@Autowired
	private CustomersEmailAddressHome customersEmailAddressHome;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String root(Model model) {
		
		/*System.out.println("Index Page Requested");
		BigDecimal pageId = new BigDecimal(1);
		if( "" != httpSession.getAttribute("userName") || null != httpSession.getAttribute("userName")) {
			try {
				//@SuppressWarnings("unused")
				//String userName = httpSession.getAttribute("userName").toString();
				Userandusergroupmap userandusergroupmap = (Userandusergroupmap) httpSession.getAttribute("userAndUserGroupMap");
				System.out.println(userandusergroupmap);
				List<Usergrouppageaccess> usergrouppageaccesses = usergrouppageaccessHome.findByUserGroupandPageID(userandusergroupmap.getUsergroup(), pageId);
				
				if(!usergrouppageaccesses.isEmpty()) {
					return "index";
				}else {
					return "unauthorizedUser";
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
				return "login";
			}
		}
		return "login";*/
		//return "index";
		httpSession.invalidate();
		return "login";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(Model model) {
		/*System.out.println("User Page Requested");
		
		if( "" != httpSession.getAttribute("userName") || null != httpSession.getAttribute("userName")) {
			try {
				String userName = httpSession.getAttribute("userName").toString();
			}
			catch(Exception ex) {
				ex.printStackTrace();
				return "login";
			}
			return "user";
		}
		return "login";*/
		return "user";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		/*System.out.println("Index Page Requested");
		BigDecimal pageId = new BigDecimal(1);
		if( "" != httpSession.getAttribute("userName") || null != httpSession.getAttribute("userName")) {
			try {
				//@SuppressWarnings("unused")
				//String userName = httpSession.getAttribute("userName").toString();
				Userandusergroupmap userandusergroupmap = (Userandusergroupmap) httpSession.getAttribute("userAndUserGroupMap");
				System.out.println(userandusergroupmap);
				List<Usergrouppageaccess> usergrouppageaccesses = usergrouppageaccessHome.findByUserGroupandPageID(userandusergroupmap.getUsergroup(), pageId);
				
				if(!usergrouppageaccesses.isEmpty()) {
					return "index";
				}else {
					return "unauthorizedUser";
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
				return "login";
			}
		}
		return "login";*/
		return "index";
	}
	
	@RequestMapping(value = "/requestDetails")
	public String requestDetails(Model model, @RequestParam(value = "requestID", required=true) Integer requestID) {
		
		model.addAttribute("requestID", requestID);
		return "requestDetails";
	}
	
	@RequestMapping(value="/pendingVerifications")
	public String pendingVerifications(Model model) {
		
		/*if( "" != httpSession.getAttribute("userName") || null != httpSession.getAttribute("userName")) {
			try {
				String userName = httpSession.getAttribute("userName").toString();
			}
			catch(Exception ex) {
				//ex.printStackTrace();
				return "login";
			}
			return "pendingVerifications";
		}
		
		return "login";*/
		return "pendingVerifications";
	}
	
	@RequestMapping(value="/updateRequest")
	public String updateRequest(Model model) {
		
		/*if( "" != httpSession.getAttribute("userName") || null != httpSession.getAttribute("userName")) {
			try {
				String userName = httpSession.getAttribute("userName").toString();
			}
			catch(Exception ex) {
				//ex.printStackTrace();
				return "login";
			}
			return "updateRequest";
		}
		
		return "login";*/
		return "updateRequest";
	}
	
	@RequestMapping(value="/uploadPOD")
	public String uploadPOD(Model model) {
		
		/*System.out.println("Upload POD Page Requested.");
		
		//httpSession.setAttribute("userName", null);
		
		
		
		
		if( "" != httpSession.getAttribute("userName") || null != httpSession.getAttribute("userName")) {
			try {
				String userName = httpSession.getAttribute("userName").toString();
			}
			catch(Exception ex) {
				//ex.printStackTrace();
				return "login";
			}
			return "uploadPOD";
		}
		
		
		
		return "login";*/
		return "uploadPOD";
	}
	
	@RequestMapping(value="/ibRequest")
	public String ibRequest(Model model) {
		
		/*if( "" != httpSession.getAttribute("userName") || null != httpSession.getAttribute("userName")) {
			try {
				String userName = httpSession.getAttribute("userName").toString();
			}
			catch(Exception ex) {
				//ex.printStackTrace();
				return "login";
			}
			return "ibRequest";
		}
		
		return "login";*/
		return "ibRequest";
	}
	
	@RequestMapping(value="/login")
	public String login(Model model) {
		
		httpSession.invalidate();
		
		return "login";
	}
	
	@RequestMapping(value="/registration")
	public String registration(Model model) {
		return "registration";
	}
	
	@RequestMapping(value="/logout")
	public String logout() {
		
		httpSession.invalidate();
		return "login";
	}
	
	@RequestMapping(value="/confirmMail")
	public String confirmMail(Model model, @RequestParam(value = "client", required=true) String client, @RequestParam(value = "mail", required=true) String mail) {
		List<CustomersEmailAddress> listCustomersEmailAddress = new ArrayList<CustomersEmailAddress>();
		int success = 0;
		try {
			listCustomersEmailAddress = customersEmailAddressHome.findByListEmailAddress(mail);
			for(CustomersEmailAddress customersEmailAddress : listCustomersEmailAddress) {
				if(customersEmailAddress.getCustomers().getCustomerSecret().equals(client)) {
					model.addAttribute("client", client);
					model.addAttribute("mail",mail);
					model.addAttribute("msisdn", customersEmailAddress.getCustomers().getMsisdn());
					success =1;
				}
				if(customersEmailAddress != null) {
						
						customersEmailAddress.setIsverified("YES");
						customersEmailAddressHome.merge(customersEmailAddress);
						success = 1;
						
					
					
				}
			}
			if(success == 0) {
				model.addAttribute("isValid", "invalid");
				return "confirmMail";
			}
			return "confirmMail";
		}catch(Exception ex) {
			ex.printStackTrace();
			model.addAttribute("isValid", "invalid");
			return "confirmMail";
		}
		
//		model.addAttribute("isValid", "invalid");
//		return "confirmMail";
	}
	
	@RequestMapping(value="/ibReport")
	public String ibReport() {
		
		return "ibReport";
	}
	
	@RequestMapping(value="/podReport")
	public String podReport() {
		
		return "podReport";
	}
	
	@RequestMapping(value="/emailAddressReport")
	public String emailAddressReport() {
		
		return "emailAddressReport";
	}
	
	@RequestMapping(value="/test")
	public void test() {
		/*String msg_1 ="<div style=\"width: 100%\"><img style=\"width: 100%; height: 40%; \" src=\"https://www.banglalink.net/sites/default/files/4G-%20Slide%202_0%281%29.jpg\" alt=\"BL_4G\"/></div>\r\n" + 
				"<div stype=\"background-color: #fcfdeb\";\">\r\n" + 
				"<p>Dear Valued Customer,</p>\r\n" + 
				"<p>Please click on below button to verify your email address.</p>\r\n" + 
				"<button style=\"background-color: #4CAF50; border: none; color: white; round: 3px 3px; padding: 15px 32px; text-align: center; text-decoration: none; display: inline-block; font-size: 16px; margin: 4px 2px; cursor: pointer;\"><a style=\"text-decoration: none !important; decoration:none; \" href=\"";*/
		/*String msg_2 = "\">Verify</a></button>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<div style=\"position: fixed;left: 0;bottom: 0; width: 100%;height: 10%;background-color: #f26f23;color: white;text-align: center;\">© 2018 Banglalink (Banglalink Digital Communications Ltd.)</div>";*/
		
		//String link = "https://blbs.banglalink.net:8443/BLBP";
		
		//String final_msg = msg_1 + link + msg_2;
		/*try {
			MailSender.getInstance().sendMail("reazulhaque20@gmail.com", "Banglalink Email Verification", final_msg);
		}catch(Exception ex) {
			ex.printStackTrace();
		}*/
		
		/*BonusMB100 bonusMB100 = new BonusMB100();
		bonusMB100.getCustomerProduct("1914444867");*/
		
		/*Validator validator = new Validator();
		Boolean a = validator.validateEmailAddress("reazul.haque@banglalinknet");
		System.out.println(a);*/
	}
}
