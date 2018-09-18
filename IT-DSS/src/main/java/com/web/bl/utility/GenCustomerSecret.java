package com.web.bl.utility;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import com.web.bl.utility.ProtectedConfigFile;

public class GenCustomerSecret {

	public String GencustSec(String msisdn) {
		String sec = "";
		try {
			sec = ProtectedConfigFile.encrypt(msisdn);
			sec = sec + ProtectedConfigFile.encrypt("BanglaLinkSecretKey@$^*2468");
			return sec;
		} catch (UnsupportedEncodingException | GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "1sadsd2sadf3das4dsf4sdaf6ds6f8dsf7ds9fv8dv6dsf5g434fd5sdaf5as6df6sad!f$asdf%asd^fasd&f&ad^f%ads#f@ad";		}
	}
}
