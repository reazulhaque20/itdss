package com.web.bl.wrapper;

import java.util.List;

import com.web.bl.model.CustomersEmailAddress;

public class EmailAddressReportWrapper {

	private List<CustomersEmailAddress> listCustomersEmailAddress;
	private String message;
	public List<CustomersEmailAddress> getListCustomersEmailAddress() {
		return listCustomersEmailAddress;
	}
	public void setListCustomersEmailAddress(List<CustomersEmailAddress> listCustomersEmailAddress) {
		this.listCustomersEmailAddress = listCustomersEmailAddress;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
