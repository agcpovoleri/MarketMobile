package com.marketmobile.utils;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class BasicUtils {

	/**
	 * Codifica password utilizando MD5
	 * @param password 
	 * @return
	 */
	public static String passwordMd5Encoder(String password){
		
		String passwordHash = null;
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
	    try {
	    	passwordHash = encoder.encodePassword(password, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return passwordHash;
	}
	
	
}
