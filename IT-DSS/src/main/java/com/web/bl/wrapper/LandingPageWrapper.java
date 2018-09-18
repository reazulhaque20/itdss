package com.web.bl.wrapper;

import java.util.List;

import com.web.bl.model.CustomersEmailAddress;
import com.web.bl.model.IbRequest;

public class LandingPageWrapper {

	private List<IbRequest> listIbRequest;
	private List<CustomersEmailAddress> listCustomerEmailAddress;
	private CustomersEmailAddress customersEmailAddress;
	
	
	public List<IbRequest> getListIbRequest() {
		return listIbRequest;
	}
	public void setListIbRequest(List<IbRequest> listIbRequest) {
		this.listIbRequest = listIbRequest;
	}
	public List<CustomersEmailAddress> getListCustomerEmailAddress() {
		return listCustomerEmailAddress;
	}
	public void setListCustomerEmailAddress(List<CustomersEmailAddress> listCustomerEmailAddress) {
		this.listCustomerEmailAddress = listCustomerEmailAddress;
	}
	public CustomersEmailAddress getCustomersEmailAddress() {
		return customersEmailAddress;
	}
	public void setCustomersEmailAddress(CustomersEmailAddress customersEmailAddress) {
		this.customersEmailAddress = customersEmailAddress;
	}
	
	
}
