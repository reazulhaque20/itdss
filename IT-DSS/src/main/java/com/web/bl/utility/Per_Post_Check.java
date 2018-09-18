package com.web.bl.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Per_Post_Check {
	
	public Integer PrePaid_PostPaidCheck(String msisdn) {
		Integer a = 0;
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.10.75:2633/bldw", "VAS", "vas"); // TABS DB
			Statement select = conn.createStatement();
			String sql = "SELECT IT_VG.GET_PRE_POST('"+msisdn+"') from dual";
			ResultSet result = select.executeQuery(sql);
			while(result.next()) {
				System.out.println("Result is: "+ result.getInt(1));
				a = result.getInt(1);
			}
			return a;
		}catch(Exception ex) {
			ex.printStackTrace();
			return 1;
		}
		
		
	}

}
