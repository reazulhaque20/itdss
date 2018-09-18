package com.web.bl.utility;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.bl.dao.CustomerProductHome;
import com.web.bl.model.CustomerProduct;

public class BonusMB100 {
	/*PROCEDURE: POSTPAID_DATA_BONUS_PROV_VAS (P_MSISDN IN VARCHAR2, P_PKG_ID IN VARCHAR2, P_RESULT OUT VARCHAR2) 

Below is the parameter details:
PARAMETER	TYPE	INPUT VALUE
P_MSISDN	VARCHAR2	19XXXXXXXX
P_PKG_ID	VARCHAR2	“GPRS3GDP90” for 100MB Bonus
P_RESULT	VARCHAR2	‘1’ for success 

Mail Subject: New Promotional Offer for e bill registration penetration*/
@Autowired
private CustomerProductHome customerProductHome;

	public String Bonus100MBData(String msisdn) {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.10.75:2633/bldw", "VAS", "vas"); // TABS DB
			CallableStatement cs = null;
			try {
				cs = conn.prepareCall("{call POSTPAID_DATA_BONUS_PROV_VAS (?,?,?)}");
				cs.setString(1, msisdn);
				cs.setString(2, "GPRS3GDP90");
				cs.setString(3, "1");
				cs.execute();
				String str = cs.getString(1);
				System.out.println("TABS Procedure Call Output: " + str);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			return "Success";
		}catch(Exception ex) {
			ex.printStackTrace();
			return "Fail";
		}
	}
	
	public String getCustomerProduct(String msisdn) {
		// TODO for customer get customer product
		// 1. Store all existing product in DB.
		// 2. Get current customer product from TABS.
		// 3. Query to DB with current customer product;
		// 4. If not found return null.
		String a = "";
		List<CustomerProduct> customerProducts = new ArrayList<>();
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.10.75:2633/bldw", "VAS", "vas"); // TABS DB
			Statement select = conn.createStatement();
			String sql = "select equipid from crm_user_equipments@tabsprod where subno='"+msisdn+"' and equipid like 'EQ%'";
			ResultSet result = select.executeQuery(sql);
			while(result.next()) {
				System.out.println("Result is: "+ result.getString(1));
				a = result.getString(1);
			}
			try {
				customerProducts = customerProductHome.findByProductName(a);
				if(customerProducts.isEmpty()) {
					return null;
				}else {
					return a;
				}
			}catch(Exception ex) {
				ex.printStackTrace();
				return null;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
