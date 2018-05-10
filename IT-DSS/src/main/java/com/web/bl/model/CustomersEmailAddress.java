package com.web.bl.model;
// Generated May 7, 2018 2:52:16 PM by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CustomersEmailAddress generated by hbm2java
 */
@Entity
@Table(name = "CUSTOMERS_EMAIL_ADDRESS", schema = "EADDRESS")
public class CustomersEmailAddress implements java.io.Serializable {

	private BigDecimal ceaId;
	private Customers customers;
	private String primaryEmailAddress;
	private String emailFlag;
	private String isverified;
	private String verificationEmail1st;
	private Date verifEmail1stDate;
	private String verificationEmail2nd;
	private Date verifEmail2ndDate;
	private String verificationEmail3rd;
	private Date verifEmail3rdDate;
	private String flag1;
	private String flag2;
	private String flag3;
	private String flag4;
	private String flag5;
	private String active;
	private String secondEmailAddress;

	public CustomersEmailAddress() {
	}

	public CustomersEmailAddress(BigDecimal ceaId) {
		this.ceaId = ceaId;
	}

	public CustomersEmailAddress(BigDecimal ceaId, Customers customers, String primaryEmailAddress, String emailFlag,
			String isverified, String verificationEmail1st, Date verifEmail1stDate, String verificationEmail2nd,
			Date verifEmail2ndDate, String verificationEmail3rd, Date verifEmail3rdDate, String flag1, String flag2,
			String flag3, String flag4, String flag5, String active, String secondEmailAddress) {
		this.ceaId = ceaId;
		this.customers = customers;
		this.primaryEmailAddress = primaryEmailAddress;
		this.emailFlag = emailFlag;
		this.isverified = isverified;
		this.verificationEmail1st = verificationEmail1st;
		this.verifEmail1stDate = verifEmail1stDate;
		this.verificationEmail2nd = verificationEmail2nd;
		this.verifEmail2ndDate = verifEmail2ndDate;
		this.verificationEmail3rd = verificationEmail3rd;
		this.verifEmail3rdDate = verifEmail3rdDate;
		this.flag1 = flag1;
		this.flag2 = flag2;
		this.flag3 = flag3;
		this.flag4 = flag4;
		this.flag5 = flag5;
		this.active = active;
		this.secondEmailAddress = secondEmailAddress;
	}

	@Id

	@Column(name = "CEA_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getCeaId() {
		return this.ceaId;
	}

	public void setCeaId(BigDecimal ceaId) {
		this.ceaId = ceaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "C_ID")
	public Customers getCustomers() {
		return this.customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	@Column(name = "PRIMARY_EMAIL_ADDRESS", length = 100)
	public String getPrimaryEmailAddress() {
		return this.primaryEmailAddress;
	}

	public void setPrimaryEmailAddress(String primaryEmailAddress) {
		this.primaryEmailAddress = primaryEmailAddress;
	}

	@Column(name = "EMAIL_FLAG", length = 20)
	public String getEmailFlag() {
		return this.emailFlag;
	}

	public void setEmailFlag(String emailFlag) {
		this.emailFlag = emailFlag;
	}

	@Column(name = "ISVERIFIED", length = 10)
	public String getIsverified() {
		return this.isverified;
	}

	public void setIsverified(String isverified) {
		this.isverified = isverified;
	}

	@Column(name = "VERIFICATION_EMAIL_1ST", length = 10)
	public String getVerificationEmail1st() {
		return this.verificationEmail1st;
	}

	public void setVerificationEmail1st(String verificationEmail1st) {
		this.verificationEmail1st = verificationEmail1st;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "VERIF_EMAIL_1ST_DATE", length = 7)
	public Date getVerifEmail1stDate() {
		return this.verifEmail1stDate;
	}

	public void setVerifEmail1stDate(Date verifEmail1stDate) {
		this.verifEmail1stDate = verifEmail1stDate;
	}

	@Column(name = "VERIFICATION_EMAIL_2ND", length = 10)
	public String getVerificationEmail2nd() {
		return this.verificationEmail2nd;
	}

	public void setVerificationEmail2nd(String verificationEmail2nd) {
		this.verificationEmail2nd = verificationEmail2nd;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "VERIF_EMAIL_2ND_DATE", length = 7)
	public Date getVerifEmail2ndDate() {
		return this.verifEmail2ndDate;
	}

	public void setVerifEmail2ndDate(Date verifEmail2ndDate) {
		this.verifEmail2ndDate = verifEmail2ndDate;
	}

	@Column(name = "VERIFICATION_EMAIL_3RD", length = 10)
	public String getVerificationEmail3rd() {
		return this.verificationEmail3rd;
	}

	public void setVerificationEmail3rd(String verificationEmail3rd) {
		this.verificationEmail3rd = verificationEmail3rd;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "VERIF_EMAIL_3RD_DATE", length = 7)
	public Date getVerifEmail3rdDate() {
		return this.verifEmail3rdDate;
	}

	public void setVerifEmail3rdDate(Date verifEmail3rdDate) {
		this.verifEmail3rdDate = verifEmail3rdDate;
	}

	@Column(name = "FLAG1", length = 20)
	public String getFlag1() {
		return this.flag1;
	}

	public void setFlag1(String flag1) {
		this.flag1 = flag1;
	}

	@Column(name = "FLAG2", length = 20)
	public String getFlag2() {
		return this.flag2;
	}

	public void setFlag2(String flag2) {
		this.flag2 = flag2;
	}

	@Column(name = "FLAG3", length = 20)
	public String getFlag3() {
		return this.flag3;
	}

	public void setFlag3(String flag3) {
		this.flag3 = flag3;
	}

	@Column(name = "FLAG4", length = 20)
	public String getFlag4() {
		return this.flag4;
	}

	public void setFlag4(String flag4) {
		this.flag4 = flag4;
	}

	@Column(name = "FLAG5", length = 20)
	public String getFlag5() {
		return this.flag5;
	}

	public void setFlag5(String flag5) {
		this.flag5 = flag5;
	}

	@Column(name = "ACTIVE", length = 10)
	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@Column(name = "SECOND_EMAIL_ADDRESS", length = 100)
	public String getSecondEmailAddress() {
		return this.secondEmailAddress;
	}

	public void setSecondEmailAddress(String secondEmailAddress) {
		this.secondEmailAddress = secondEmailAddress;
	}

}