package com.web.bl.wrapper;

import java.util.List;

import com.web.bl.model.IbRequest;

public class IbReportWraper {

	private List<IbRequest> ibRequestList;
	private String message;
	
	public List<IbRequest> getIbRequestList() {
		return ibRequestList;
	}
	public void setIbRequestList(List<IbRequest> ibRequestList) {
		this.ibRequestList = ibRequestList;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
