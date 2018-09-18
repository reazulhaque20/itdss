package com.web.bl.model;

public class UserEmail {

	
	private String email;
	private String msisdn;
	private String product;
	private String channel;
	private Integer billCycle;
	
	public UserEmail() {
		
	}
	
	

	public UserEmail(String email, String msisdn, String product, String channel, Integer billCycle) {
		super();
		this.email = email;
		this.msisdn = msisdn;
		this.product = product;
		this.channel = channel;
		this.billCycle = billCycle;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public Integer getBillCycle() {
		return billCycle;
	}

	public void setBillCycle(Integer billCycle) {
		this.billCycle = billCycle;
	}
	
	
}
