package com.web.bl.api;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.web.bl.dao.CustomersEmailAddressHome;
import com.web.bl.dao.CustomersHome;
import com.web.bl.model.Customers;
import com.web.bl.model.CustomersEmailAddress;
import com.web.bl.utility.Per_Post_Check;
import com.web.bl.utility.SmsSender;
import com.web.bl.utility.Validator;
import com.web.bl.wrapper.ApiPostWrapper;
import com.web.bl.wrapper.ResponseWrapper;
import com.web.bl.wrapper.VerificationWrapper;
import com.web.bl.utility.BonusMB100;
import com.web.bl.utility.GenCustomerSecret;


@RestController
public class EmailRepoApi {
	
	@Autowired
	private CustomersEmailAddressHome customersEmailAddressHome;
	
	@Autowired
	private CustomersHome customersHome;
	
	@Autowired
	private HttpSession httpSession;
	
	@RequestMapping(value="/postCustomerInfo", method=RequestMethod.POST)
	public ResponseEntity<ResponseWrapper> postCustomerInfo(@RequestBody ApiPostWrapper apiPostWrapper) {
		
		ResponseWrapper responseWrapper = new ResponseWrapper();
		Customers customers = new Customers();
		CustomersEmailAddress customersEmailAddress = new CustomersEmailAddress();
		GenCustomerSecret genCustomerSecret = new GenCustomerSecret();
		
		// EValidate Email Address
		Validator validator = new Validator();
		if(validator.validateEmailAddress(apiPostWrapper.getEmail_primary())) {
			try {
				String msisdn = ""+apiPostWrapper.getMsisdn().substring(3);
				customers.setMsisdn(msisdn);
				customers.setBillCycle(apiPostWrapper.getBillCycle());
				customers.setMedia(apiPostWrapper.getMedia());
				customers.setProduct(apiPostWrapper.getProduct());
				customers.setInterestedforcourier(apiPostWrapper.getInterestedForCourier());
				customers.setInterestedforebill(apiPostWrapper.getInterestedForEbill());
				customers.setCustomerSecret(genCustomerSecret.GencustSec(msisdn));
				customers.setCreatedby(apiPostWrapper.getCreatedBy());
				customers.setCreateddate(new Date());
				BigDecimal cID =  customersHome.persist(customers); // Need to open
				
				customers.setCId(cID);
				customersEmailAddress.setCustomers(customers);
				customersEmailAddress.setEmailAddress(apiPostWrapper.getEmail_primary());
				customersEmailAddress.setSecondEmailAddress(apiPostWrapper.getEmail_secondary());
				customersEmailAddressHome.persist(customersEmailAddress); // Need to open
				
				//Per_Post_Check per_Post_Check = new Per_Post_Check();
				//Integer a = per_Post_Check.PrePaid_PostPaidCheck(msisdn);
				//if(a == 1) { // 1 for Postpaid
					try {
						SmsSender smsSender = new SmsSender();
						String mobile = "880"+msisdn;
						smsSender.sendSMS("Dear Valued Customer,\r\n" + 
								"Thank you for registering your email address. Please verify your email address"+apiPostWrapper.getEmail_primary()+"  via verification email send to your email address. \r\n" + 
								"", mobile);
						}catch(Exception ex) {
							ex.printStackTrace();
							System.out.println("Failed to Send SMS.");
						}
				//}
				
				responseWrapper.setMessage("Success");
			}catch(Exception ex) {
				ex.printStackTrace();
				responseWrapper.setMessage("Failed");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}
		}
		
		
		
		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
	}
	
	@RequestMapping(value="updateVerification", method=RequestMethod.POST) // Calls when click on Confirm button in verification page.
	public ResponseEntity<ResponseWrapper> updateVerification(@RequestBody VerificationWrapper verificationWrapper) {
		
		ResponseWrapper responseWrapper = new ResponseWrapper();
		List<CustomersEmailAddress> listCustomersEmailAddress= new ArrayList<>();
		Customers customers = new Customers();
		try {
			listCustomersEmailAddress = customersEmailAddressHome.findByListEmailAddress(verificationWrapper.getMail());
			for(CustomersEmailAddress customersEmailAddress : listCustomersEmailAddress) {
			if(customersEmailAddress != null) {
				customers = customersEmailAddress.getCustomers();
				customers.setInterestedforebill(verificationWrapper.getIb_need());
				customersHome.merge(customers);
				//customersEmailAddress.setIsverified("Verified");
				customersEmailAddressHome.merge(customersEmailAddress);
				responseWrapper.setMessage("Request Recorded Successfully. Thanks For your Interest.");
				
				try {
					Integer num = 0;
					Per_Post_Check per_Post_Check = new Per_Post_Check();
					num = per_Post_Check.PrePaid_PostPaidCheck(verificationWrapper.getIb_need());
					
					if(num == 1) {
						System.out.println("POSTPAID");
						BonusMB100 bonusMB100 = new BonusMB100();
						if( bonusMB100.getCustomerProduct(verificationWrapper.getMsisdn()) != null) {
							bonusMB100.Bonus100MBData(verificationWrapper.getMsisdn());
						}
					}
					else if(num == 2){
						responseWrapper.setMessage("PREPAID");
					}
					else {
						
					}
					
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
			else {
				responseWrapper.setMessage("Error While Processing Your Request.");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}
			
		}
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
		}catch(Exception ex) {
			ex.printStackTrace();
			responseWrapper.setMessage("Error While Confirming Your Request.");
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		}
		//return null;
	}
	

	


	@RequestMapping(value="checkMSISDN/{msisdn}", method=RequestMethod.GET)
	public ResponseEntity<CustomersEmailAddress> checkMSISDN(@PathVariable("msisdn") String msisdn) {
		
		CustomersEmailAddress customersEmailAddress = new CustomersEmailAddress();
		Customers customers = new Customers();
//		Test Code
			//BigDecimal t = new BigDecimal("12");
			customers.setMsisdn("1962424653");
			customers.setProduct("POSTPAID");
			customers.setBillCycle("BG-31");
			customersEmailAddress.setCustomers(customers);
//			customersEmailAddress.setCeaId(t);
			customersEmailAddress.setEmailAddress("test@test.com");
			customersEmailAddress.setSecondEmailAddress("test2@test2.com");
//		End Test Code
		try {
			customersEmailAddress = customersEmailAddressHome.findByMsisdn(msisdn); // Need to open
		}catch(Exception ex) {
			ex.printStackTrace();
			customersEmailAddress = null;
		}
		
		if(customersEmailAddress != null) {
			return new ResponseEntity<CustomersEmailAddress>(customersEmailAddress, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<CustomersEmailAddress>(customersEmailAddress, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	
	@RequestMapping(value="updateEmailAddress/", method=RequestMethod.POST)
	public ResponseEntity<ResponseWrapper> updateEmailAddress(@RequestBody CustomersEmailAddress customersEmailAddress) {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		Customers customers = new Customers();
		CustomersEmailAddress emailAddress = new CustomersEmailAddress();
		SmsSender smsSender = new SmsSender();
		GenCustomerSecret customerSecret = new GenCustomerSecret();
		customers = customersEmailAddress.getCustomers();
		
		try {
			if(customersEmailAddress.getCustomers().getCId() == null) {
				BigDecimal cID = customersHome.getCustomersId();
				customers.setCId(cID);
				customers.setCustomerSecret(customerSecret.GencustSec(customersEmailAddress.getCustomers().getMsisdn()));
				try {
					emailAddress.getCustomers().setCreatedby(httpSession.getAttribute("userName").toString());
				}catch(Exception ex) {
					ex.printStackTrace();
					System.out.println("Unable to acquire Session Value.");
				}
				emailAddress.getCustomers().setCreateddate(new Date());
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		customersEmailAddress.setCustomers(customers);
		emailAddress = customersEmailAddress;
		emailAddress.setIsapproved("Approved");
		try {
			emailAddress.getCustomers().setUpdateby(httpSession.getAttribute("userName").toString());
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Unable to acquire Session Value.");
		}
		emailAddress.getCustomers().setUpdatedate(new Date());
		try {
			if(null != customersEmailAddress.getCeaId()) {
				customersEmailAddressHome.merge(customersEmailAddress); //Need to Open
				responseWrapper.setMessage("Successfully Data Updated.");
			}else {
				customersEmailAddressHome.persist(emailAddress); // Need to open
				responseWrapper.setMessage("Successfully Data Updated.");
			}
			
			try {
			String mobile = "880"+customers.getMsisdn();
			smsSender.sendSMS("Dear Valued Customer,Thank you for registering your email address. Please verify your email address "+customersEmailAddress.getEmailAddress()+"  via verification email send to your email address.", mobile);
			}catch(Exception ex) {
				ex.printStackTrace();
				System.out.println("Failed to Send SMS.");
			}
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
		}catch(Exception ex) {
			ex.printStackTrace();
			responseWrapper.setMessage("Error While Updating Data.");
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@RequestMapping(value = "emailAddressUpdateFromlanding/", method = RequestMethod.POST)
	public ResponseEntity<ResponseWrapper> emailAddressUpdateFromlanding(@RequestBody CustomersEmailAddress customersEmailAddress){
		ResponseWrapper responseWrapper = new ResponseWrapper();
		try {
			customersEmailAddressHome.merge(customersEmailAddress);
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
		}catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@RequestMapping(value="updateRequest", method=RequestMethod.POST)
	public ModelAndView updateRequest(@RequestParam CommonsMultipartFile file, HttpSession session, Model model) {
		
		System.out.println("Success.");
		Customers customers = new Customers();
		CustomersEmailAddress customersEmailAddress = new CustomersEmailAddress();
		String fileName = file.getOriginalFilename();
		if (!file.isEmpty() && (fileName.contains(".xlsx")|| fileName.contains(".xls"))) {
			try {
				byte[] bytes = file.getBytes();
				//DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "BulkFile");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				FileInputStream fis = new FileInputStream(serverFile);
				try {
					//String generateTicketDetails = null;
					@SuppressWarnings("rawtypes")
					List rightOutput = new ArrayList();
					@SuppressWarnings("rawtypes")
					List wrongOutput = new ArrayList();
					// Get the workbook instance for XLS file
					XSSFWorkbook workbook = new XSSFWorkbook(fis);
					// Get first sheet from the workbook
					XSSFSheet sheet = workbook.getSheetAt(0);
					workbook.close();
					// Iterate through each rows from first sheet
					Iterator<Row> rowIterator = sheet.iterator();
					while (rowIterator.hasNext()) {
						Row row = rowIterator.next();
						if (row.getRowNum() > 0) {
							int i = 0;
							String msisdn = null;
							String emailAddress = null;
							String billCycle = null;
							String media = null;
							String ebill = null;
							String courier = null;
							String cnc = null;
							String remarks = null;
							String createdBy = null;
							
							System.out.print("\n--------------------:: Start ::--------------------");
							// For each row, iterate through each columns
							Iterator<Cell> cellIterator = row.cellIterator();
							while (cellIterator.hasNext()) {
								Cell cell = cellIterator.next();
								if(i == 0) {
									cell.setCellType(Cell.CELL_TYPE_STRING);
									msisdn = cell.getStringCellValue();
									customers.setMsisdn(msisdn);
									customersEmailAddress.setCustomers(customers);
								}
								if(i == 1) {
									cell.setCellType(Cell.CELL_TYPE_STRING);
									emailAddress = cell.getStringCellValue();
									customersEmailAddress.setEmailAddress(emailAddress);
								}
								if(i == 2) {
									cell.setCellType(Cell.CELL_TYPE_STRING);
									emailAddress = cell.getStringCellValue();
									customersEmailAddress.setSecondEmailAddress(emailAddress);
								}
								if(i == 3) {
									cell.setCellType(Cell.CELL_TYPE_STRING);
									billCycle = cell.getStringCellValue();
									customers.setBillCycle(billCycle);
									customersEmailAddress.setCustomers(customers);
								}
								if(i == 4) {
									cell.setCellType(Cell.CELL_TYPE_STRING);
									media = cell.getStringCellValue();
									customers.setMedia(media);
									customersEmailAddress.setCustomers(customers);
								}
								if(i == 5) {
									cell.setCellType(Cell.CELL_TYPE_STRING);
									ebill = cell.getStringCellValue();
									customers.setInterestedforebill(ebill);
									customersEmailAddress.setCustomers(customers);
								}
								if(i == 6) {
									cell.setCellType(Cell.CELL_TYPE_STRING);
									courier = cell.getStringCellValue();
									customers.setInterestedforcourier(courier);
									customersEmailAddress.setCustomers(customers);
								}
								if(i == 7) {
									cell.setCellType(Cell.CELL_TYPE_STRING);
									cnc = cell.getStringCellValue();
									customers.setCnc(cnc);
									customersEmailAddress.setCustomers(customers);
								}
								if(i == 8) {
									cell.setCellType(Cell.CELL_TYPE_STRING);
									remarks = cell.getStringCellValue();
									GenCustomerSecret customerSecret = new GenCustomerSecret();
									customers.setCustomerSecret(customerSecret.GencustSec(msisdn));
									customers.setKam(remarks);
									customersEmailAddress.setCustomers(customers);
								}
								if(i == 9) {
									cell.setCellType(Cell.CELL_TYPE_STRING);
									createdBy = cell.getStringCellValue();
									customers.setCreatedby(createdBy);
									customers.setCreateddate(new Date());
									customersEmailAddress.setCustomers(customers);
								}
								i++;
								
							} // end of while
							try {
								customers.setCId(customersHome.getCustomersId());
								customersEmailAddressHome.persist(customersEmailAddress); // Need to open
							}catch(Exception ex) {
								
							}
							System.out.print("\n--------------------:: End ::--------------------\n");
						}
					}
					model.addAttribute("rightOutput", rightOutput);
					model.addAttribute("wrongOutput", wrongOutput);
					fis.close();
					serverFile.delete();
					model.addAttribute("success", "Bulk Email Successfully Uploaded.");

				} catch (Exception excep) {
					System.out.println("Error message is: " + excep.getMessage());
				}
			} catch (Exception exc) {
			}

		} else if (!file.isEmpty() && !fileName.contains(".xls")) {
			model.addAttribute("error", "Sorry. wrong file: " + fileName.toLowerCase() + " has been selected!!");
		} else if (file.isEmpty()) {
			model.addAttribute("error", "Pelase select .xls formatted file.");
		}
		
		return new ModelAndView();
	}
	
	@RequestMapping(value="/checkTABSData/{msisdn}", method=RequestMethod.GET)
	public ResponseEntity<ResponseWrapper> checkTABSData(@PathVariable("msisdn") String msisdn){
		ResponseWrapper responseWrapper = new ResponseWrapper();
		System.out.println("Test MSISDN: "+msisdn);
		Per_Post_Check per_Post_Check = new Per_Post_Check();
		try {
			Integer num = per_Post_Check.PrePaid_PostPaidCheck(msisdn);
			if(num == 1) {
				responseWrapper.setMessage("POSTPAID");
			}
			else if(num == 2){
				responseWrapper.setMessage("PREPAID");
			}
			else {
				
			}
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
		}catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@RequestMapping(value = "getMsisdn/", method = RequestMethod.POST)
	public ResponseEntity<List<CustomersEmailAddress>> getMsisdn(@RequestBody String emailAddress){
		List<CustomersEmailAddress> listCustomersEmailAddress = new ArrayList<>();
		
		try {
			listCustomersEmailAddress = customersEmailAddressHome.findByListEmailAddress(emailAddress);
			
			if(!listCustomersEmailAddress.isEmpty()) {
				return new ResponseEntity<List<CustomersEmailAddress>>(listCustomersEmailAddress, HttpStatus.OK);
			}
			return new ResponseEntity<List<CustomersEmailAddress>>(listCustomersEmailAddress, HttpStatus.EXPECTATION_FAILED);
		}catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<List<CustomersEmailAddress>>(listCustomersEmailAddress, HttpStatus.EXPECTATION_FAILED);
		}
	}
}
