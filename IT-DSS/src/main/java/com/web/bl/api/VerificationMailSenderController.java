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
public class VerificationMailSenderController {

	@Autowired
	private CustomersEmailAddressHome customersEmailAddressHome;
	
	@RequestMapping(value="/sendVerificationMail", method=RequestMethod.GET)
	public void sendVerificationMail() {
		
		/*String body="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" + 
				"<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n" + 
				"<head>\r\n" + 
				"  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n" + 
				"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n" + 
				"  <title>Zen Flat Invitation Email</title>\r\n" + 
				"  <style type=\"text/css\" media=\"screen\">\r\n" + 
				"\r\n" + 
				"    \r\n" + 
				"    .ExternalClass {\r\n" + 
				"      display: block !important;\r\n" + 
				"      width: 100%;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    \r\n" + 
				"    .ExternalClass,\r\n" + 
				"    .ExternalClass p,\r\n" + 
				"    .ExternalClass span,\r\n" + 
				"    .ExternalClass font,\r\n" + 
				"    .ExternalClass td,\r\n" + 
				"    .ExternalClass div {\r\n" + 
				"      line-height: 100%;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    body,\r\n" + 
				"    p,\r\n" + 
				"    h1,\r\n" + 
				"    h2,\r\n" + 
				"    h3,\r\n" + 
				"    h4,\r\n" + 
				"    h5,\r\n" + 
				"    h6 {\r\n" + 
				"      margin: 0;\r\n" + 
				"      padding: 0;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    body,\r\n" + 
				"    p,\r\n" + 
				"    td {\r\n" + 
				"      font-family: Arial, Helvetica, sans-serif;\r\n" + 
				"      font-size: 15px;\r\n" + 
				"      color: #333333;\r\n" + 
				"      line-height: 1.5em;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    h1 {\r\n" + 
				"      font-size: 24px;\r\n" + 
				"      font-weight: normal;\r\n" + 
				"      line-height: 24px;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    body,\r\n" + 
				"    p {\r\n" + 
				"      margin-bottom: 0;\r\n" + 
				"      -webkit-text-size-adjust: none;\r\n" + 
				"      -ms-text-size-adjust: none;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    img {\r\n" + 
				"      outline: none;\r\n" + 
				"      text-decoration: none;\r\n" + 
				"      -ms-interpolation-mode: bicubic;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    a img {\r\n" + 
				"      border: none;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    .background {\r\n" + 
				"      background-color: #333333;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    table.background {\r\n" + 
				"      margin: 0;\r\n" + 
				"      padding: 0;\r\n" + 
				"      width: 100% !important;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    .block-img {\r\n" + 
				"      display: block;\r\n" + 
				"      line-height: 0;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    a {\r\n" + 
				"      color: white;\r\n" + 
				"      text-decoration: none;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    a,\r\n" + 
				"    a:link {\r\n" + 
				"      color: #2A5DB0;\r\n" + 
				"      text-decoration: underline;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    table td {\r\n" + 
				"      border-collapse: collapse;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    td {\r\n" + 
				"      vertical-align: top;\r\n" + 
				"      text-align: left;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    .wrap {\r\n" + 
				"      width: 600px;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    .wrap-cell {\r\n" + 
				"      padding-top: 30px;\r\n" + 
				"      padding-bottom: 30px;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    .header-cell,\r\n" + 
				"    .body-cell,\r\n" + 
				"    .footer-cell {\r\n" + 
				"      padding-left: 20px;\r\n" + 
				"      padding-right: 20px;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    .header-cell {\r\n" + 
				"      background-color: #eeeeee;\r\n" + 
				"      font-size: 24px;\r\n" + 
				"      color: #ffffff;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    .body-cell {\r\n" + 
				"      background-color: #ffffff;\r\n" + 
				"      padding-top: 30px;\r\n" + 
				"      padding-bottom: 34px;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    .footer-cell {\r\n" + 
				"      background-color: #eeeeee;\r\n" + 
				"      text-align: center;\r\n" + 
				"      font-size: 13px;\r\n" + 
				"      padding-top: 30px;\r\n" + 
				"      padding-bottom: 30px;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    .card {\r\n" + 
				"      width: 400px;\r\n" + 
				"      margin: 0 auto;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    .data-heading {\r\n" + 
				"      text-align: right;\r\n" + 
				"      padding: 10px;\r\n" + 
				"      background-color: #ffffff;\r\n" + 
				"      font-weight: bold;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    .data-value {\r\n" + 
				"      text-align: left;\r\n" + 
				"      padding: 10px;\r\n" + 
				"      background-color: #ffffff;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    .force-full-width {\r\n" + 
				"      width: 100% !important;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"  </style>\r\n" + 
				"  <style type=\"text/css\" media=\"only screen and (max-width: 600px)\">\r\n" + 
				"    @media only screen and (max-width: 600px) {\r\n" + 
				"      body[class*=\"background\"],\r\n" + 
				"      table[class*=\"background\"],\r\n" + 
				"      td[class*=\"background\"] {\r\n" + 
				"        background: #eeeeee !important;\r\n" + 
				"      }\r\n" + 
				"\r\n" + 
				"      table[class=\"card\"] {\r\n" + 
				"        width: auto !important;\r\n" + 
				"      }\r\n" + 
				"\r\n" + 
				"      td[class=\"data-heading\"],\r\n" + 
				"      td[class=\"data-value\"] {\r\n" + 
				"        display: block !important;\r\n" + 
				"      }\r\n" + 
				"\r\n" + 
				"      td[class=\"data-heading\"] {\r\n" + 
				"        text-align: left !important;\r\n" + 
				"        padding: 10px 10px 0;\r\n" + 
				"      }\r\n" + 
				"\r\n" + 
				"      table[class=\"wrap\"] {\r\n" + 
				"        width: 100% !important;\r\n" + 
				"      }\r\n" + 
				"\r\n" + 
				"      td[class=\"wrap-cell\"] {\r\n" + 
				"        padding-top: 0 !important;\r\n" + 
				"        padding-bottom: 0 !important;\r\n" + 
				"      }\r\n" + 
				"    }\r\n" + 
				"  </style>\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body leftmargin=\"0\" marginwidth=\"0\" topmargin=\"0\" marginheight=\"0\" offset=\"0\" bgcolor=\"\" class=\"background\">\r\n" + 
				"  <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" height=\"100%\" width=\"100%\" class=\"background\">\r\n" + 
				"    <tr>\r\n" + 
				"      <td align=\"center\" valign=\"top\" width=\"100%\" class=\"background\">\r\n" + 
				"        <center>\r\n" + 
				"          <table cellpadding=\"0\" cellspacing=\"0\" width=\"600\" class=\"wrap\">\r\n" + 
				"            <tr>\r\n" + 
				"              <td valign=\"top\" class=\"wrap-cell\" style=\"padding-top:30px; padding-bottom:30px;\">\r\n" + 
				"                <table cellpadding=\"0\" cellspacing=\"0\" class=\"force-full-width\">\r\n" + 
				"                  <tr>\r\n" + 
				"                   <td height=\"60\" valign=\"top\" class=\"header-cell\">\r\n" + 
				"                      <img width=\"196\" height=\"60\" src=\"https://www.filepicker.io/api/file/SU2YFOjPQzahL7orjBgl\" alt=\"logo\">\r\n" + 
				"                    </td>\r\n" + 
				"                  </tr>\r\n" + 
				"                  <tr>\r\n" + 
				"                    <td valign=\"top\" class=\"body-cell\">\r\n" + 
				"                      <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" bgcolor=\"#ffffff\">\r\n" + 
				"                        <tr>\r\n" + 
				"                          <td valign=\"top\" style=\"padding-bottom:15px; background-color:#ffffff;\">\r\n" + 
				"                            <h1>You've been invited to Awesome Co!</h1>\r\n" + 
				"                          </td>\r\n" + 
				"                        </tr>\r\n" + 
				"                      </table>\r\n" + 
				"                      <table cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">\r\n" + 
				"                        <tr>\r\n" + 
				"                          <td>\r\n" + 
				"                            <table cellpadding=\"0\" cellspacing=\"0\" width=\"82\" height=\"82\">\r\n" + 
				"                                <tr>\r\n" + 
				"                                  <td style=\"text-align:left;border: 1px solid #808080;\">\r\n" + 
				"                                    <img width=\"80\" height=\"80\" style=\"display:block\" src=\"https://www.filepicker.io/api/file/OqRXT4JuRbmXSgbxccgK\">\r\n" + 
				"                                  </td>\r\n" + 
				"                                </tr>\r\n" + 
				"                              </table>\r\n" + 
				"                              <table cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
				"                                <tr>\r\n" + 
				"                                  <td style=\"font-size:12px; padding-top:5px; text-align:left;\">\r\n" + 
				"                                    User: <a style=\"color:blue;\" href=\"\">Jon Doe</a>\r\n" + 
				"                                  </td>\r\n" + 
				"                                </tr>\r\n" + 
				"                              </table>\r\n" + 
				"                            </td>\r\n" + 
				"                            <td  width=\"450\" valign=\"middle\" style=\"padding-bottom:20px; padding-left:20px; background-color:#ffffff; vertical-align:middle;\">\r\n" + 
				"                              <b>Hey {{ first_name }},</b><br>\r\n" + 
				"                              I set up an Awesome Co profile where I can do tons of really awesome stuff! Come find you what you've been missing! When you sign up by clicking below you'll receive a <b>20% discount</b> on your first months subscription!\r\n" + 
				"                            </td>\r\n" + 
				"                        </tr>\r\n" + 
				"                      </table>\r\n" + 
				"                      <table cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">\r\n" + 
				"                        <tr>\r\n" + 
				"                          <td>\r\n" + 
				"                            <table cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" bgcolor=\"#ffffff\">\r\n" + 
				"                              <tr>\r\n" + 
				"                                <td style=\"width:200px;background:#008000;\">\r\n" + 
				"                                  <div><!--[if mso]>\r\n" + 
				"                                    <v:rect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"#\" style=\"height:40px;v-text-anchor:middle;width:200px;\" stroke=\"f\" fillcolor=\"#008000\">\r\n" + 
				"                                      <w:anchorlock/>\r\n" + 
				"                                      <center>\r\n" + 
				"                                    <![endif]-->\r\n" + 
				"                                        <a href=\"#\"\r\n" + 
				"                                  style=\"background-color:#008000;color:#ffffff;display:inline-block;font-family:sans-serif;font-size:18px;line-height:40px;text-align:center;text-decoration:none;width:200px;-webkit-text-size-adjust:none;\">Sign up now!</a>\r\n" + 
				"                                    <!--[if mso]>\r\n" + 
				"                                      </center>\r\n" + 
				"                                    </v:rect>\r\n" + 
				"                                  <![endif]--></div>\r\n" + 
				"                                </td>\r\n" + 
				"                                <td width=\"360\" style=\"background-color:#ffffff; font-size:0; line-height:0;\">&nbsp;</td>\r\n" + 
				"                              </tr>\r\n" + 
				"                            </table>\r\n" + 
				"                          </td>\r\n" + 
				"                        </tr>\r\n" + 
				"                        <tr>\r\n" + 
				"                          <td style=\"padding-top:20px;background-color:#ffffff;\">\r\n" + 
				"                            See you soon,<br>\r\n" + 
				"                            Your Awesome Co team\r\n" + 
				"                          </td>\r\n" + 
				"                        </tr>\r\n" + 
				"                      </table>\r\n" + 
				"                    </td>\r\n" + 
				"                  </tr>\r\n" + 
				"                  <tr>\r\n" + 
				"                    <td valign=\"top\" class=\"footer-cell\">\r\n" + 
				"                      Awesome Co<br>\r\n" + 
				"                      an Awesome Co Technologies, INC company\r\n" + 
				"                    </td>\r\n" + 
				"                  </tr>\r\n" + 
				"                </table>\r\n" + 
				"              </td>\r\n" + 
				"            </tr>\r\n" + 
				"          </table>\r\n" + 
				"        </center>\r\n" + 
				"      </td>\r\n" + 
				"    </tr>\r\n" + 
				"  </table>\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>";*/
		//body = "Test";
		MailSender.getInstance().sendMail("reazul.haque@banglalink.net", "Confirmation Mail", "Test Mail");
		
	}
	
	@RequestMapping(value="/getEmail", method=RequestMethod.GET)
	
	public ResponseEntity<CustomCustomersEmailAddressWrapper> getEmail(@RequestParam(value="msisdn", required=false) String msisdn) {
		
		 
		//String msisdn = "1962424653";
		//RestTemplate restTemplate = new RestTemplate();
		//ResponseWrapper responseWrapper = new ResponseWrapper();
		CustomCustomersEmailAddressWrapper customCustomersEmailAddressWrapper = new CustomCustomersEmailAddressWrapper();
		//Integer customerID = 0;
		//Customers customers = null;
		CustomersEmailAddress customersEmailAddress = null;
		
		//UserEmailWrapper userEmailWrapper = restTemplate.getForObject("http://localhost:8080/IT-DSS/setEmail", UserEmailWrapper.class);
		String mailBody = "<div>\r\n" + 
				"                                        <a href=\"#\"\r\n" + 
				"                                  style=\"background-color:#008000;color:#ffffff;display:inline-block;font-family:sans-serif;font-size:18px;line-height:40px;text-align:center;text-decoration:none;width:200px;-webkit-text-size-adjust:none;\">Click to Verify</a>\r\n" + 
				"                                    </div>";
		try {
			
			MailSender.getInstance().sendMail("reazul.haque@banglalink.net", "Test Mail", mailBody);
			
			customersEmailAddress = customersEmailAddressHome.findByMsisdn(msisdn); // Need to open
			
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
			ex.printStackTrace();
			customCustomersEmailAddressWrapper.setMessage("Unexpexted Error Occured.");
			return new ResponseEntity<CustomCustomersEmailAddressWrapper>(customCustomersEmailAddressWrapper, HttpStatus.EXPECTATION_FAILED);
		}
	}
}
