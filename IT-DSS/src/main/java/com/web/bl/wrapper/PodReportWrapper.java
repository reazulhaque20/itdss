package com.web.bl.wrapper;

import java.util.List;

import com.web.bl.model.Uploadpod;

public class PodReportWrapper {
	
	private List<Uploadpod> listuploadpod;
	private String message;
	public List<Uploadpod> getListuploadpod() {
		return listuploadpod;
	}
	public void setListuploadpod(List<Uploadpod> listuploadpod) {
		this.listuploadpod = listuploadpod;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
