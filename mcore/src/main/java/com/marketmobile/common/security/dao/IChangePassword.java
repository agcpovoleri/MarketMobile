package com.marketmobile.common.security.dao;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface IChangePassword extends UserDetailsService{
	
	void changePassword(String username, String password);

}
