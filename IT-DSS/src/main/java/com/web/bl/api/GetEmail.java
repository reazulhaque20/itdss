package com.web.bl.api;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.web.bl.dao.EmailsHome;
import com.web.bl.dao.UploadpodHome;
import com.web.bl.model.Emails;
import com.web.bl.model.Uploadpod;
import com.web.bl.model.UserEmail;
import com.web.bl.wrapper.UserEmailWrapper;

@RestController
public class GetEmail {

	@Autowired
	private EmailsHome emailsHome;
	
	@Autowired
	private UploadpodHome uploadpodHome;
	
	@RequestMapping(value="/getDataFronDB", method=RequestMethod.GET)
	public ResponseEntity<Emails> getDataFronDB(){
		
		Emails emails = new Emails();
		
		try {
			emails = emailsHome.finfByMSISDN("1962424653"); // need to open
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		Emails persist_EmailsID = new Emails();
		
		persist_EmailsID.setMsisdn("1234");
		persist_EmailsID.setEmail("test");
		
		Emails newEmails = new Emails();
		newEmails.setMsisdn("1962424653");
		newEmails.setBillcycle("1");
//		newEmails.setId(persist_EmailsID);
		try {
			emailsHome.persist(newEmails); //Need to open
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return new ResponseEntity<Emails>(emails, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getEmail", method=RequestMethod.POST)
	public ResponseEntity<UserEmailWrapper> getEmail(@RequestBody UserEmailWrapper userEmailWrapper){
		
		
		
		return new ResponseEntity<UserEmailWrapper>(userEmailWrapper, HttpStatus.OK);
	}
	
	@RequestMapping(value="/setEmail", method=RequestMethod.GET)
	public ResponseEntity<UserEmailWrapper> setEmail(){
		
		UserEmail userEmail = new UserEmail();
		List<UserEmail> listUserEmail = new ArrayList<UserEmail>();
		
		userEmail.setEmail("reazul.haque@banglalink.net");
		userEmail.setBillCycle(5);
		userEmail.setChannel("POC");
		userEmail.setMsisdn("01962424653");
		userEmail.setProduct("Postpaid");
		listUserEmail.add(userEmail);
		
		userEmail = new UserEmail();
		userEmail.setBillCycle(2);
		userEmail.setChannel("BOS");
		userEmail.setMsisdn("01962424649");
		userEmail.setProduct("Postpaid");
		userEmail.setEmail("shakil.ahmed@banglalink.net");
		listUserEmail.add(userEmail);
		
		UserEmailWrapper userEmailWrapper = new UserEmailWrapper();
		
		userEmailWrapper.setListUserEmail(listUserEmail);
		
		return new ResponseEntity<UserEmailWrapper>(userEmailWrapper, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "uploadPOD", method = RequestMethod.POST)
	public ModelAndView uploadPOD(@RequestParam CommonsMultipartFile file, HttpSession session, Model model) {
		
		System.out.println("Success.");
		Uploadpod uploadpod = new Uploadpod();
		String fileName = file.getOriginalFilename();
		if (!file.isEmpty() && (fileName.contains(".xlsx")|| fileName.contains(".xls"))) {
			try {
				byte[] bytes = file.getBytes();
				DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

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
							String category = null;
							String contrno = null;
							String msisdn = null;
							String name = null;
							String address = null;
							String iB_NIB = null;
							String bill_Cycle = null;
							String month = null;
							String year = null;
							String received_By = null;
							String relation = null;
							Date del_Return_Date = new Date();
							String del_ReturnBy = null;
							String return_Reason = null;
							String status = null;
							String courier = null;
							
							System.out.print("\n--------------------:: Start ::--------------------");
							// For each row, iterate through each columns
							Iterator<Cell> cellIterator = row.cellIterator();
							while (cellIterator.hasNext()) {
								Cell cell = cellIterator.next();
								if(i == 0) {
									cell.setCellType(Cell.CELL_TYPE_STRING);
									category = cell.getStringCellValue();
									uploadpod.setCategory(category);
								}
								if(i == 1) {
									cell.setCellType(Cell.CELL_TYPE_STRING);
									contrno = cell.getStringCellValue();
									uploadpod.setContrno(contrno);
								}
								if(i == 2) {
									cell.setCellType(Cell.CELL_TYPE_STRING);
									msisdn = cell.getStringCellValue();
									uploadpod.setMsisdn(msisdn);
								}
								if(i == 3) {
									cell.setCellType(Cell.CELL_TYPE_STRING);
									name = cell.getStringCellValue();
									uploadpod.setName(name);
								}
								if(i == 4) {
									cell.setCellType(Cell.CELL_TYPE_STRING);
									address = cell.getStringCellValue();
									uploadpod.setAddress(address);
								}
								if(i == 5) {
									cell.setCellType(Cell.CELL_TYPE_STRING);
									iB_NIB = cell.getStringCellValue();
									uploadpod.setIbNib(iB_NIB);
								}
								if(i == 6) {
									cell.setCellType(Cell.CELL_TYPE_STRING);
									bill_Cycle = cell.getStringCellValue();
									uploadpod.setBillCycle(bill_Cycle);
								}
								if(i == 7) {
									cell.setCellType(Cell.CELL_TYPE_STRING);
									month = cell.getStringCellValue();
									uploadpod.setMonth(month);
								}
								if(i == 8) {
									cell.setCellType(Cell.CELL_TYPE_STRING);
									year = cell.getStringCellValue();
									uploadpod.setYear(year);
								}
								if(i == 9) {
									cell.setCellType(Cell.CELL_TYPE_STRING);
									received_By = cell.getStringCellValue();
									uploadpod.setReceivedBy(received_By);
								}
								if(i == 10) {
									cell.setCellType(Cell.CELL_TYPE_STRING);
									relation = cell.getStringCellValue();
									uploadpod.setRelation(relation);
								}
								if(i == 11) {
									cell.setCellType(Cell.CELL_TYPE_STRING);
									del_Return_Date = format.parse(cell.getStringCellValue());
									uploadpod.setDelReturnDate(del_Return_Date);
								}
								if(i == 12) {
									cell.setCellType(Cell.CELL_TYPE_STRING);
									del_ReturnBy = cell.getStringCellValue();
									uploadpod.setDelReturnBy(del_ReturnBy);
								}
								if(i == 13) {
									cell.setCellType(Cell.CELL_TYPE_STRING);
									return_Reason = cell.getStringCellValue();
									uploadpod.setReturnReason(return_Reason);
								}
								if(i == 14) {
									cell.setCellType(Cell.CELL_TYPE_STRING);
									status = cell.getStringCellValue();
									uploadpod.setStatus(status);
								}
								if(i == 15) {
									cell.setCellType(Cell.CELL_TYPE_STRING);
									courier = cell.getStringCellValue();
									uploadpod.setCourier(courier);
								}
								i++;
								
							} // end of while
							uploadpodHome.persist(uploadpod); // Need to open

							System.out.print("\n--------------------:: End ::--------------------\n");
						}
					}
					model.addAttribute("rightOutput", rightOutput);
					model.addAttribute("wrongOutput", wrongOutput);
					fis.close();
					serverFile.delete();
					model.addAttribute("success", "POD Successfully Uploaded.");

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
}
