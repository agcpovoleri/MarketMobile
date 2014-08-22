package com.marketmobile.common.security.dao;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.memory.InMemoryDaoImpl;

@SuppressWarnings("deprecation")
public class InMemoryChangePassword extends InMemoryDaoImpl implements IChangePassword{

	public void changePassword(String username, String password) {

		User userDetails = (User) getUserMap().getUser(username);
		
		User newUserDetails = new User(userDetails.getUsername(), password,
				userDetails.isEnabled(),
				userDetails.isAccountNonExpired(),
				userDetails.isCredentialsNonExpired(),
				userDetails.isAccountNonLocked(),
				userDetails.getAuthorities());
		
		getUserMap().addUser(newUserDetails);
	}

}
