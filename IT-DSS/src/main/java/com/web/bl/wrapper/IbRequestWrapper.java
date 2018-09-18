package com.web.bl.wrapper;

import java.util.List;

import com.web.bl.model.IbRequest;

public class IbRequestWrapper {

	private IbRequest ibRequest;
	private List<String> months;
	public IbRequest getIbRequest() {
		return ibRequest;
	}
	public void setIbRequest(IbRequest ibRequest) {
		this.ibRequest = ibRequest;
	}
	public List<String> getMonths() {
		return months;
	}
	public void setMonths(List<String> months) {
		this.months = months;
	}
	
	
}
